package com.coffee.machine;

import com.coffee.machine.states.Leerlauf;

public class AutomatenSteuerung implements KaffeeAutomat {
    private AutomatenStatus status;

    public AutomatenSteuerung() {
        this.status = new Leerlauf();
    }

    public void bezahleBetrag(int betrag) {
        status.bezahleBetrag(this,betrag);
    }

    public void waehleProdukt(String produkt) {
        status.waehleProdukt(this,produkt);
    }

    public void waehleOption(String option) {
        status.waehleOption(this,option);
    }

    public int fordereWechselgeld() {
        return status.fordereWechselgeld(this);
    }

    public int zapfeProdukt() {
        return status.zapfeProdukt(this);
    }

    public int abbruch() {
        return status.abbruch(this);
    }

    public void changeState(AutomatenStatus status) {
        this.status = status;
    }

    public AutomatenStatus getStatus() {
        return status;
    }
}
