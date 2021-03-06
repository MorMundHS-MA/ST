package com.coffee.machine.states;

import com.coffee.machine.AutomatenStatus;
import com.coffee.machine.AutomatenSteuerung;

public class KalterKakao extends Produkt {

    private final static String[] optionen = new String[]{"Heiss"};
    private final static int preis = 90;
    private final static String name = "Kalter Kakao";
    // Kakao hat keine Optionen

    public KalterKakao(int bereitsBezahlt) {
        super(bereitsBezahlt);
    }

    public void waehleProdukt(AutomatenSteuerung automat, String produkt) {
        System.out.println("Brechen Sie die momentane Bestellung ab um das Produkt neu zu waehlen.");
    }

    public void waehleOption(AutomatenSteuerung automat, String option) {
        if (option.equalsIgnoreCase("Heiss")) {
            automat.changeState(new HeisserKakao(super.bezahlterBetrag));
        } else {
            System.out.printf("Option %s ist leider nicht verfügbar.", option);
        }
    }

    public int fordereWechselgeld(AutomatenSteuerung automat) {
        automat.changeState(new Bezahlung(this, super.bezahlterBetrag));
        return automat.fordereWechselgeld();
    }

    public int zapfeProdukt(AutomatenSteuerung automat) {
        automat.changeState(new Bezahlung(this, super.bezahlterBetrag));
        return automat.zapfeProdukt();
    }

    public int abbruch(AutomatenSteuerung automat) {
        automat.changeState(new Leerlauf());
        return bezahlterBetrag;
    }

    protected String[] getMoeglicheOptionen() {
        return optionen;
    }

    public String getProduktName() {
        return name;
    }

    public int getPreis() {
        return preis;
    }

    public int getOptionsCost() {
        return 0;
    }
}
