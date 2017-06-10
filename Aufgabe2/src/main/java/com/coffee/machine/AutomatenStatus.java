package com.coffee.machine;

public interface AutomatenStatus {
    void bezahleBetrag(AutomatenSteuerung automat, int betrag);
    void waehleProdukt(AutomatenSteuerung automat, String produkt);
    void waehleOption(AutomatenSteuerung automat, String option);
    int fordereWechselgeld(AutomatenSteuerung automat);
    int zapfeProdukt(AutomatenSteuerung automat);
    int abbruch(AutomatenSteuerung automat);
}
