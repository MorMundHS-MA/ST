import java.util.Scanner;

public class Program {

    private static AutomatenSteuerung automat;

    public static void main(String[] args) {
        automat = new AutomatenSteuerung();
        while(true) {
            begrueßeKunde();
        }
    }

    //Diese Methode begrueßt den Kunden per Konsolenausgabe und fordert zur
    //Auswahl und Eingabe von Produkten auf.
    private static void begrueßeKunde() {
        System.out.println("Guten Tag bei McDonalds, Ihre Bestellung bitte!");
        System.out.println("OH, Sie fragen was wir überhaupt anbieten? Das kann"
                + " ich Ihnen gerne sagen. Wir bieten Kaffee zu 1,20€,"
                + " Kakao zu 0,90€, Tee zu 1€ und meine Handynummer zu 1€ an. =)");
        System.out.println("Anmerkung der Redaktion, gebe jetzt 'Kaffee', 'Tee' oder 'Kakao' ein."
                + " Mit 'Abbruch' kannst du bis zur Bezahlung jederzeit abbrechen.");

        setProdukt();
    }

    /**
     * Diese Methode Filtert die Eingabe.
     */
    private static void setProdukt() {
        Scanner in = new Scanner(System.in);

        String produkt = null;

        while (produkt == null) {
            try {
                produkt = in.nextLine();
                if (produkt.equalsIgnoreCase("Abbruch")) {
                    automat.abbruch();
                    return;
                } else if (!Helper.stringEqualsAny(produkt, new String[]{"Kakao", "Tee", "Kaffee"}, true)) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Wie schwer ist es Kakao oder Tee oder Kaffee einzutippen?");
                produkt = null;
            }
        }

        automat.waehleProdukt(produkt);
        while (true) {
            System.out.println("Gib eine Zusatzoption ein oder 'Start' zum ausfuehren der Bestellung oder 'Abbruch' zum abbrechen.");
            String option;
            option = in.nextLine();
            if (option.equalsIgnoreCase("Abbruch")) {
                automat.abbruch();
                return;
            } else if (option.equalsIgnoreCase("Start")) {
                break;
            } else {
                automat.waehleOption(option);
            }
        }

        automat.bezahleBetrag(0);
        while (!automat.istBezahlt()) {
            String geld = in.nextLine();
            if (geld.equalsIgnoreCase("Abbruch")) {
                automat.abbruch();
                return;
            } else {
                try {
                    int betrag = Integer.parseInt(geld);
                    automat.bezahleBetrag(betrag);
                } catch (NumberFormatException fe) {
                    System.out.println("Nein kein Monopoly Geld.");
                    automat.abbruch();
                }
            }
        }

        automat.zapfeProdukt();
        in.close();
    }
}

