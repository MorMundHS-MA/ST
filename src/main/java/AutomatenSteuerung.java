import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class AutomatenSteuerung implements KaffeeAutomat {
    private static Protokoll protokoll = new Protokoll();
    private Produkt selectedProdukt = null;
    private List<String> selectedOptions = null;
    private int eingeworfenesGeld = 0;


    public AutomatenSteuerung() {
    }

    public int GetUmsatz() {
        throw new NotImplementedException();
    }

    public String[] ListeVerkaeufe() {
        throw new NotImplementedException();
    }

    public void bezahleBetrag(int betrag) {
        eingeworfenesGeld += betrag;
        System.out.printf("Noch ausstehender Betrag %s. Oder schreiben sie 'Abbruch' zum abbrechen. \n",
                Helper.formatMoney(
                        Math.max(0,
                                selectedProdukt.getPreis() + getOptionsCost() - eingeworfenesGeld), '€'));
    }

    public void waehleProdukt(String produkt) {
        if (produkt.equalsIgnoreCase("Kaffee")) {
            selectedProdukt = new Kaffee();
        } else if (produkt.equalsIgnoreCase("Tee")) {
            selectedProdukt = new Tee();
        } else if (produkt.equalsIgnoreCase("Kakao")) {
            selectedProdukt = new Kakao();
        } else {
            return;
        }

        System.out.println(printSelectionInfo());
    }

    public void waehleOption(String option) {
        if (option == null) {
            return;
        }

        if (selectedOptions == null) {
            selectedOptions = new ArrayList<String>();
        }

        if (Helper.stringEqualsAny(option, selectedProdukt.getOptionen(), true) && !selectedOptions.contains(option)) {
            selectedOptions.add(option);
            System.out.println(printSelectionInfo());
        } else if (selectedOptions.contains(option)) {
            System.out.println(printSelectionInfo());
        } else {
            System.out.printf("Leider besitzt %s keine Option %s. Moegliche Optionen sind : %s \n",
                    selectedProdukt.getBezeichnung(),
                    option,
                    Helper.makePrettyList(selectedProdukt.getOptionen(), "und", ','));
        }
    }

    public int fordereWechselgeld() {
        if (selectedProdukt == null) {
            int wechselGeld = eingeworfenesGeld;
            System.out.printf("Hier ist ihr Wechselgeld in Höhe von %s.", Helper.formatMoney(wechselGeld, '€'));
            eingeworfenesGeld = 0;
            return wechselGeld;
        }

        int wechselGeld = Math.max(0, eingeworfenesGeld - (selectedProdukt.getPreis() + getOptionsCost()));
        System.out.printf("Hier ist ihr Wechselgeld in Höhe von %s.", Helper.formatMoney(wechselGeld, '€'));
        eingeworfenesGeld = 0;
        return wechselGeld;
    }

    public int zapfeProdukt() {
        if (selectedProdukt == null) {
            System.out.println("Warum bin ich hier?");
            return 0;
        }

        System.out.printf("Frischer %s kommt sofort! Bitte beehren sie uns bald wieder!\n", selectedProdukt.getBezeichnung());
        AutomatenSteuerung.protokoll.verkaufeProdukt(
                selectedProdukt,
                selectedOptions.toArray(new String[selectedOptions.size()]),
                selectedProdukt.getPreis() + getOptionsCost());
        selectedProdukt = null;
        selectedOptions = null;
        eingeworfenesGeld = 0;
        return fordereWechselgeld();
    }

    public int abbruch() {
        System.out.println("Abbrechen.");
        int wechselGeld = fordereWechselgeld();
        selectedProdukt = null;
        selectedOptions = null;
        eingeworfenesGeld = 0;
        return wechselGeld;
    }

    public boolean istBezahlt() {
        if (selectedProdukt == null) {
            return false;
        }

        return selectedProdukt.getPreis() + getOptionsCost() <= eingeworfenesGeld;
    }

    private int getOptionsCost() {
        if (selectedOptions == null) {
            return 0;
        } else {
            return selectedOptions.size() * 10;
        }
    }

    private String printSelectionInfo() {
        if (selectedProdukt == null) {
            return "Kein Produkt ausgewaehlt!";
        }
        if (selectedOptions != null) {
            return String.format("%s wurde mit %s ausgewählt. Preis ist : %s. Optionen sind : %s",
                    selectedProdukt.getBezeichnung(),
                    Helper.makePrettyList(selectedOptions.toArray(new String[selectedOptions.size()]), "und", ','),
                    Helper.formatMoney(selectedProdukt.getPreis() + getOptionsCost(), '€'),
                    Helper.makePrettyList(selectedProdukt.getOptionen(), "und", ','));
        } else {
            return String.format("%s wurde ausgewählt. Preis ist : %s. Optionen sind : %s",
                    selectedProdukt.getBezeichnung(),
                    Helper.formatMoney(selectedProdukt.getPreis() + getOptionsCost(), '€'),
                    Helper.makePrettyList(selectedProdukt.getOptionen(), "und", ','));
        }
    }
}
