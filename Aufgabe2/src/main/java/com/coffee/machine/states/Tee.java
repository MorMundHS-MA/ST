package com.coffee.machine.states;

import com.coffee.machine.AutomatenStatus;
import com.coffee.machine.AutomatenSteuerung;
import com.coffee.machine.Helper;

public class Tee extends Produkt {

    private final static String[] optionen = new String[]{"Milch", "Zucker"};
    private final static int preis = 100;
    private final static String name = "Tee";
    private final static int preisPerOption = 10;

    public Tee(int bereitsBezahlt) {
        super(bereitsBezahlt);
    }

    public void waehleProdukt(AutomatenSteuerung automat, String produkt) {
        System.out.println("Brechen Sie die momentane Bestellung ab um das Produkt neu zuwaehlen.");
    }

    public void waehleOption(AutomatenSteuerung automat, String option) {
        if (Helper.stringEqualsAny(option, optionen, true)
                && !Helper.stringEqualsAny(option, gewaehlteOptionen.toArray(new String[gewaehlteOptionen.size()]), true)) {
            gewaehlteOptionen.add(option);
            printSelectionInfo(super.bezahlterBetrag);
        } else if (Helper.stringEqualsAny(option, optionen, true)) {
            System.out.printf("Option %s bereits ausgewaehlt.", option);
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
        return super.gewaehlteOptionen.size() * preisPerOption;
    }
}
