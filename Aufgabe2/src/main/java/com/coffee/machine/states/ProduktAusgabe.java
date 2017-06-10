package com.coffee.machine.states;

import com.coffee.machine.AutomatenStatus;
import com.coffee.machine.AutomatenSteuerung;

public class ProduktAusgabe  implements AutomatenStatus {
    private int bezahlterBetrag, kostenProdukt;

    public ProduktAusgabe(int bezahlterBetrag, int kostenProdukt) {
        this.bezahlterBetrag = bezahlterBetrag;
        this.kostenProdukt = kostenProdukt;
    }

    public void bezahleBetrag(AutomatenSteuerung automat, int betrag) {
        if(bezahlterBetrag < kostenProdukt) {
            throw new IllegalArgumentException();
        }
    }

    public void waehleProdukt(AutomatenSteuerung automat, String produkt) {
        System.out.println("Produkt wird bereits gezapft. Jetzt ist es etwas zu spät zum Umentscheiden.");
    }

    public void waehleOption(AutomatenSteuerung automat, String option) {
        System.out.println("Produkt wird bereits gezapft. Jetzt ist es etwas zu spät für Extrawünsche.");
    }

    public int fordereWechselgeld(AutomatenSteuerung automat) {
        automat.changeState(new Leerlauf());
        return bezahlterBetrag - kostenProdukt;
    }

    public int zapfeProdukt(AutomatenSteuerung automat) {
        return automat.fordereWechselgeld();
    }

    public int abbruch(AutomatenSteuerung automat) {
        automat.changeState(new Leerlauf());
        return bezahlterBetrag;
    }
}
