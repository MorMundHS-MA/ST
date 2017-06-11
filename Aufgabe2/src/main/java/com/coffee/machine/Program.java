package com.coffee.machine;

import com.coffee.machine.states.*;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        Scanner in = new Scanner(System.in);

        while (true) {
            AutomatenStatus status = automat.getStatus();
            String input = in.nextLine();
            int geld = -1;
            try {
                geld = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                geld = -1;
            }

            if (input.equalsIgnoreCase("Abbruch")) {
                automat.abbruch();
            }else if(input.equalsIgnoreCase("Zapfen")){
                automat.zapfeProdukt();
            } else if (geld > 0) {
                automat.bezahleBetrag(geld);
            } else if (status instanceof Leerlauf) {
                automat.waehleProdukt(input);
            } else if (status instanceof Produkt) {
                automat.waehleOption(input);
            }
        }
    }
}
