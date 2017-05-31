import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class AutomatenSteuerung implements KaffeeAutomat {
    private Produkt[] produkte;
    private Protokoll protokoll;

    public AutomatenSteuerung() {
        this.protokoll = new Protokoll();
    }

    public int GetUmsatz(){
        throw  new NotImplementedException();
    }

    public String[] ListeVerkaeufe() {
        throw  new NotImplementedException();
    }

    public void bezahleBetrag(int betrag){
        throw  new NotImplementedException();
    }

    public void waehleProdukt(String produkt) {
        throw  new NotImplementedException();
    }

    public void waehleOption(String option) {
        throw  new NotImplementedException();
    }

    public int fordereWechselgeld() {
        throw  new NotImplementedException();
    }

    public int zapfeProdukt() {
        throw  new NotImplementedException();
    }

    public int abbruch() {
        throw  new NotImplementedException();
    }
}
