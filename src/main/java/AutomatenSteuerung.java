import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class AutomatenSteuerung implements KaffeeAutomat {
    private Protokoll protokoll;
    private Produkt selectedProdukt = null;

    public AutomatenSteuerung() {
        this.protokoll = new Protokoll();
    }

    public int GetUmsatz() {
        throw new NotImplementedException();
    }

    public String[] ListeVerkaeufe() {
        throw new NotImplementedException();
    }

    public void bezahleBetrag(int betrag) {
        throw new NotImplementedException();
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
    }

    public void waehleOption(String option) {
        throw new NotImplementedException();
    }

    public int fordereWechselgeld() {
        throw new NotImplementedException();
    }

    public int zapfeProdukt() {
        throw new NotImplementedException();
    }

    public int abbruch() {
        throw new NotImplementedException();
    }
}
