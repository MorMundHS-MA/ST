package com.coffee.machine;

public interface KaffeeAutomat {
    /**
     * Methode nimmt den Geldbetrag vom Kunden entgegen.
     */
    void bezahleBetrag(int betrag);

    /**
     * Methode setzt das Produkt, welches der Kunde gewählt hat.
     */
    void waehleProdukt(String produkt);

    /**
     * Methode setzt die Optionen für das jeweilige Produkt.
     */
    void waehleOption(String option);

    /**
     * Keine Ahnung warum der Automat selbst Wechselgeld fordern soll.
     */
    int fordereWechselgeld();

    /**
     * Die Methodennamen sind ja mal echt zum Schießen. Ich gehe mal
     * davon aus das hier das Produkt zubereitet und ausgegeben
     * wird.
     */
    int zapfeProdukt();

    /**
     * Methode, um den kompletten Bestellvorgang zu stornieren und
     * diesen auf den Anfangszustand setzen.
     */
    int abbruch();
}
