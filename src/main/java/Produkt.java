public abstract class Produkt {
    private String bezeichnung;
    private int preis;
    private String[] optionen;

    /**
     * Methode legt die Bezeichnung des Produktes fest.
     */
    protected void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    /**
     * Methode legt den entgültigen Preis fest.
     */
    protected void setPreis(int preis) {
        this.preis = preis;
    }

    /**
     * Methode speichert die gewählten Methoden für die
     * Statistik.
     */
    protected void setOptionen(String[] optionen) {
        this.optionen = optionen;
    }
}
