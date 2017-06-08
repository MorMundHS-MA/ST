import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Kaffee extends Produkt {

    public Kaffee() {
        super("Kaffee", 120, new String[]{"Milch", "Zucker", "Schokostreusel"});
    }

    /**
     * Methode frägt den Kunden via Konsoleausgabe ob er Zusatzoptionen für
     * seinen Kaffee wählt, welche er per Konsoleneingabe äußert.
     */
    public void setOptionen() {

        String optionen;

        // Optionen: Extra Milch, Zucker oder Schockostreusel
        System.out.println("Eingabe 1: Kaffee wird zubereitet./n"
                + "Eingabe 2: Extra Milch./n"
                + "Eingabe 3: Extra Zucker./n"
                + "Eingabe 4: Extra Schockostreusel."
                + "Eingabe 5: Abbruch");
        inputOptionen();
    }

    private void inputOptionen() {

        final String[] listeDerOptionen = {"Milch", "Zucker", "Schockostreusel", "Abbruch"};
        ArrayList<String> gewählteOptionen = new ArrayList();

        Scanner in = new Scanner(System.in);

        try {
            int eingabe = in.nextInt();

            if (eingabe < 1 || eingabe > 5) {
                throw new InputMismatchException();
            } else if (eingabe == 5) {
                //TODO: Rufe irgendwie KaffeeAutomat.abbruch() auf
            } else if (eingabe == 1) {
                /*TODO: Rufe irgendwie KaffeeAutomat.zapfeProdukt() auf,
				wenn das die Methode sein soll die das Zeug zubereitet.*/
            } else {
                gewählteOptionen.add(listeDerOptionen[eingabe]);
                setOptionen(gewählteOptionen.toArray(new String[gewählteOptionen.size()]));
            }
        } catch (InputMismatchException e) {
            System.out.println("Sehr witzig. Geben Sie bitte eine valide Zahl ein.");
            inputOptionen();
        }

    }
}
