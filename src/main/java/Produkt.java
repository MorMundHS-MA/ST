public abstract class Produkt {
    private String bezeichnung;
    private int preis;
    private String[] optionen;


    public Produkt(String bezeichnung, int preis, String[] optionen) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.optionen = optionen;
    }

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

    public int getPreis() {
        return preis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public String[] getOptionen() {
        return optionen;
    }

}
