package com.coffee.machine.states;

import com.coffee.machine.AutomatenStatus;
import com.coffee.machine.AutomatenSteuerung;

public class Leerlauf implements AutomatenStatus {

    public Leerlauf() {
        System.out.println("Guten Tag bei McDonalds, Ihre Bestellung bitte!");
        System.out.println("OH, Sie fragen was wir überhaupt anbieten? Das kann"
                + " ich Ihnen gerne sagen. Wir bieten Kaffee zu 1,20€,"
                + " Kakao zu 0,90€, Tee zu 1€ und meine Handynummer zu 1€ an. =)");
        System.out.println("Anmerkung der Redaktion, gebe jetzt 'Kaffee', 'Tee' oder 'Kakao' ein."
                + " Mit 'Abbruch' kannst du bis zur Bezahlung jederzeit abbrechen.");
    }

    public void bezahleBetrag(AutomatenSteuerung automat, int betrag) {
        System.out.println("Noch kein Getraenk ausgewaehlt! Du kannst noch nicht bezahlen!");
    }

    public void waehleProdukt(AutomatenSteuerung automat, String produkt) {
        if (produkt.equalsIgnoreCase("Kakao")) {
            automat.changeState(new HeisserKakao(0));
        } else if (produkt.equalsIgnoreCase("Tee")) {
            automat.changeState(new Tee(0));
        } else if (produkt.equalsIgnoreCase("Kaffee")){
            automat.changeState(new Kaffee(0));
        } else {
            System.out.println("Unbekanntes Getraenk gewaehlt. Dieser Automat liefert nur Kaffee, Tee und Kakao.");
        }
    }

    public void waehleOption(AutomatenSteuerung automat, String option) {
        System.out.println("Noch kein Getraenk ausgewaehlt! Du kannst noch keine Option waehlen!");
    }

    public int fordereWechselgeld(AutomatenSteuerung automat) {
        System.out.println("Noch nichts bezahlt!");
        return 0;
    }

    public int zapfeProdukt(AutomatenSteuerung automat) {
        System.out.println("Noch kein Getraenk ausgewaehlt! Du kannst noch nicht Zapfen!");
        return 0;
    }

    public int abbruch(AutomatenSteuerung automat) {
       return 0;
    }
}
