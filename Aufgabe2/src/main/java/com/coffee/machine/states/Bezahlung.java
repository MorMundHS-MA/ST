package com.coffee.machine.states;

import com.coffee.machine.AutomatenStatus;
import com.coffee.machine.AutomatenSteuerung;

public class Bezahlung implements AutomatenStatus {

    private Produkt gewaehltesProdukt;
    private int bezahlterBetrag = 0;

    public Bezahlung(Produkt produkt, int bezahlterBetrag) {
        this.gewaehltesProdukt = produkt;
        this.bezahlterBetrag = bezahlterBetrag;
    }

    public void bezahleBetrag(AutomatenSteuerung automat, int betrag) {
        this.bezahlterBetrag += betrag;
    }

    public void waehleProdukt(AutomatenSteuerung automat, String produkt) {
        System.out.println("Brechen Sie die momentane Bestellung ab um das Produkt neu zuwaehlen.");
    }

    public void waehleOption(AutomatenSteuerung automat, String option) {
        gewaehltesProdukt.waehleOption(automat, option);
    }

    public int fordereWechselgeld(AutomatenSteuerung automat) {
        return bezahlterBetrag - (gewaehltesProdukt.getPreis() + gewaehltesProdukt.getOptionsCost());
    }

    public int zapfeProdukt(AutomatenSteuerung automat) {
        return fordereWechselgeld(automat);
    }

    public int abbruch(AutomatenSteuerung automat) {
        return fordereWechselgeld(automat);
    }
}
