public class Kaffee extends Produkt {

    public Kaffee() {
        setBezeichnung("Kaffee");
        setPreis(120);
        //setOptionen();
    }

    /*

    /**
     * Methode frägt den Kunden via Konsoleausgabe ob er Zusatzoptionen für seinen Kaffee
     * wählt, welche er per Konsoleneingabe äußert.
     *
    public void setOptionen() {

        String optionen;

        //Optionen: Extra Milch, Zucker oder Schockostreusel
        System.out.println("Durch einfaches drücken der Eingabetaste wird der Kaffee"
                + " zubereitet. Sie können aber auch extra Milch, Zucker"
                + " oder Schockostreusel eingeben und sie bekommen es jeweils"
                + " für 10ct extra oben drauf. Um eine Option rückgängig zu machen,"
                + " wählen Sie diese ein zweites Mal an.");

    private void inputOptionen() {

        /**
         * Liste legt fest, welche Optionen gewählt wurden.
         * Die Erste Option in der Liste ist die Milch,
         * die Zweite ist Zucker und die Dritte sind
         * Schockostreusel.
         *
        private String[] optionsListe = {null, null, null};

        try {
            optionen = in.nextLine();
            if(!optionen.equalsIgnoreCase("Milch" || "Zucker" || "Schockostreusel" || "Abbruch")) {
                throw new Exception();
            }
        }
        catch(Exception e) {
            System.out.println("Regen Sie mich bitte nicht auf und konzentrieren Sie"
                    + " sich bei der Eingabe. Probieren Sie es nochmal.");
            inputOptionen();
        }

        if(optionen.equalsIgnoreCase("Abbruch")) {
            KaffeeAutomatInterface.abbruch();
        }

        else if(optionen.equals("")) {
            setOptionen(optionsListe);
            //TODO: Kehre zur main() zurück und fahre dort fort.
        }

        else if(optionen.equalsIgnoreCase("Milch")) {
            (optionsListe[0].equals("Milch") ? String[0] = null : String[0] = "Milch";
        }

        else if(optionen.equalsIgnoreCase("Zucker")) {
            (optionsListe[1].equals("Zucker") ? String[1] = null : String[1] = "Zucker";
        }

        else if(optionen.equalsIgnoreCase("Schockostreusel")) {
            (optionsListe[2].equals("Schockostreusel") ? String[2] = null : String[2] = "Schockostreusel";
        }
    }*/
}

