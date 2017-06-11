package com.coffee.machine.states;

import com.coffee.machine.AutomatenStatus;
import com.coffee.machine.AutomatenSteuerung;
import com.coffee.machine.Helper;

import java.util.ArrayList;
import java.util.List;

public abstract class Produkt implements AutomatenStatus {

    protected List<String> gewaehlteOptionen = new ArrayList<String>();
    protected int bezahlterBetrag = 0;

    public Produkt(int bereitsBezahlt) {
        this.bezahlterBetrag = bereitsBezahlt;
        printSelectionInfo(bereitsBezahlt);
    }

    public void bezahleBetrag(AutomatenSteuerung automat, int betrag) {
        automat.changeState(new Bezahlung(this, this.bezahlterBetrag + betrag));
    }

    protected abstract String[] getMoeglicheOptionen();

    public abstract String getProduktName();

    public abstract int getPreis();

    public abstract int getOptionsCost();

    public void printSelectionInfo(int bezahlterBetrag) {
        int restBetrag = getPreis() + getOptionsCost() - bezahlterBetrag;
        if (gewaehlteOptionen.size() > 0) {
            System.out.printf("%s wurde mit %s ausgewählt. Preis ist : %s. Optionen sind : %s\n",
                    getProduktName(),
                    Helper.makePrettyList(gewaehlteOptionen.toArray(new String[gewaehlteOptionen.size()]), "und", ','),
                    Helper.formatMoney(restBetrag, '€'),
                    Helper.makePrettyList(getMoeglicheOptionen(), "und", ','));
        } else {
            System.out.printf("%s wurde ausgewählt. Preis ist : %s. Optionen sind : %s\n",
                    getProduktName(),
                    Helper.formatMoney(restBetrag, '€'),
                    Helper.makePrettyList(getMoeglicheOptionen(), "und", ','));
        }

        if (restBetrag <= 0) {
            System.out.println("Zapfe dein Getraenk mit 'Zapfen'.");
        }
    }
}
