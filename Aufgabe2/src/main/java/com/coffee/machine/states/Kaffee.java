package com.coffee.machine.states;

import com.coffee.machine.AutomatenStatus;
import com.coffee.machine.AutomatenSteuerung;

public class Kaffee  extends Produkt {
    public Kaffee(int bereitsBezahlt) {
        super(bereitsBezahlt);
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

    protected String[] getMoeglicheOptionen() {
        return new String[0];
    }

    public String getProduktName() {
        return null;
    }

    public int getPreis() {
        return 0;
    }

    public int getOptionsCost() {
        return 0;
    }
}
