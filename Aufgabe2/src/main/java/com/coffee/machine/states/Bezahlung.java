package com.coffee.machine.states;

import com.coffee.machine.AutomatenStatus;
import com.coffee.machine.AutomatenSteuerung;

public class Bezahlung implements AutomatenStatus {
    private  Produkt gewaehltesProdukt;
    private int bezahlterBetrag = 0;

    public Bezahlung(Produkt produkt, int bezahlterBetrag) {
        this.gewaehltesProdukt = produkt;
        this.bezahlterBetrag = bezahlterBetrag;
    }

    public void bezahleBetrag(AutomatenSteuerung automat, int betrag) {

    }

    public void waehleProdukt(AutomatenSteuerung automat, String produkt) {

    }

    public void waehleOption(AutomatenSteuerung automat, String option) {

    }

    public int fordereWechselgeld(AutomatenSteuerung automat) {
        return 0;
    }

    public int zapfeProdukt(AutomatenSteuerung automat) {
        return 0;
    }

    public int abbruch(AutomatenSteuerung automat) {
        return 0;
    }
}
