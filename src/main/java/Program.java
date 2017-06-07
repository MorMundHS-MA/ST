import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        begrueßeKunde();
    }

    //Diese Methode begrueßt den Kunden per Konsolenausgabe und fordert zur
    //Auswahl und Eingabe von Produkten auf.
    private static void begrueßeKunde() {
        System.out.println("Guten Tag bei McDonalds, Ihre Bestellung bitte!");
        System.out.println("OH, Sie fragen was wir überhaupt anbieten? Das kann"
                + " ich Ihnen gerne sagen. Wir bieten Kaffee zu 1,20€,"
                + " Kakao zu 99,99€, Tee zu 1€ und meine Handynummer zu 1€ an. =)");
        System.out.println("Anmerkung der Redaktion, gebe jetzt 'Kaffee', 'Tee' oder 'Kakao' ein."
                + " Mit 'Abbruch' kannst du bis zur Bezahlung jederzeit abbrechen.");

        setProdukt();
    }

    /**
     * Diese Methode Filtert die Eingabe.
     */
    private static void setProdukt() {
        Scanner in = new Scanner(System.in);

        String produkt;

        try {
             produkt = in.nextLine();
            if(!Helper.stringEqualsAny(produkt, new String[]{"Kakao" , "Tee" , "Kaffee" , "Abbruch"},true)) {
                throw new Exception();
            }
        }
        catch(Exception e) {
            System.out.println("Wie schwer ist es Kakao oder Tee oder Kaffee einzutippen?");
            setProdukt();
        }

       // waehleProdukt(produkt);
    }
}

