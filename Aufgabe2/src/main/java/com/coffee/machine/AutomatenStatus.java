package com.coffee.machine;

public interface AutomatenStatus {
    /**
     * Der Nutzer zahlt einen Geldbetrag.
     * @param automat
     * @param betrag der gezahlte Geldbetrag in Eurocent
     */
    void bezahleBetrag(AutomatenSteuerung automat, int betrag);
    /**
     * Der Nutzer wählt ein Produkt aus.
     * @param automat
     * @param produkt das Wunschprodukt
     */
    void waehleProdukt(AutomatenSteuerung automat, String produkt);
    /**
     * Der Nutzer wählt eine Option für sein Produkt aus.
     * @param automat
     * @param option die ausgewählte Option
     */
    void waehleOption(AutomatenSteuerung automat, String option);
    /**
     * Gibt das Wechselgeld aus.
     * @param automat
     * @return das Wechselgeld
     */
    int fordereWechselgeld(AutomatenSteuerung automat);
    /**
     * Schenkt das Produkt aus.
     * @param automat
     * @return das Restwechselgeld
     */
    int zapfeProdukt(AutomatenSteuerung automat);
    /**
     * Der Nutzer bricht den Bestellvorgang ab.
     * @param automat
     * @return das Geld, das der Nutzer zurückbekommt
     */
    int abbruch(AutomatenSteuerung automat);
}
