package ws14;

import ws14.EtikettenDrucker;
import ws14.Farbe;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class EtikettenDruckerTest {

    private EtikettenDrucker printer = new DruckerTestBewerter();

    @AfterClass
    public static void druckeTestergebnis() throws Exception {
        DruckerTestBewerter.druckeTestergebnis();
    }

    /**
     * Deckt Gültige Äquivalenzklassen #000, #001, #002, #100, #101, #200 und
     * Randwerte {7, 30} ab.
     */
    @Test
    public void gültigeParameterKombinationen() {
        printer.druckeEtikett(Farbe.ROT, false, 7);
        printer.druckeEtikett(Farbe.GRUEN, false, 30);
        printer.druckeEtikett(Farbe.BLAU, true, 7);
    }

    /**
     * Deckt Ungültige Äquivalenzklasse #010 ab
     */
    @Test(expected = IllegalArgumentException.class)
    public void ungültigeFarbe() {
        printer.druckeEtikett(Farbe.GELB, true, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullAlsFarbe() {
        printer.druckeEtikett(null, true, 7);
    }

    /**
     * Deckt Ungültige Äquivalenzklasse #210 und kritische Werte {-1, 0, 5} ab
     * und Randwerte {Integer.MIN_VALUE, 6} ab.
     */
    @Test//(expected = IllegalArgumentException.class)
    public void zuKleineBreite() {
        printer.druckeEtikett(Farbe.ROT, false, (int) Integer.MIN_VALUE);
        printer.druckeEtikett(Farbe.ROT, false, -1);
        printer.druckeEtikett(Farbe.ROT, false, 0);
        printer.druckeEtikett(Farbe.ROT, false, 5);
        printer.druckeEtikett(Farbe.ROT, false, 6);
    }

    /**
     * Deckt Ungültige Äquivalenzklasse #211 und kritischen Wert {32} und
     * Randwerte {31, Integer.MAX_VALUE} ab.
     */
    @Test(expected = IllegalArgumentException.class)
    public void zuGroßeBreite() {
        printer.druckeEtikett(Farbe.ROT, false, 31);
        printer.druckeEtikett(Farbe.ROT, false, 32);
        printer.druckeEtikett(Farbe.ROT, false, (int) Integer.MAX_VALUE);
    }

}
