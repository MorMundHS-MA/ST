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
     * Deckt Gültige Äquivalenzklassen #000, #001, #002, #100, #101, #200 ab
     */
    @Test
    public void gültigeParameterKombinationen() {
        printer.druckeEtikett(Farbe.ROT, true, 7);
        printer.druckeEtikett(Farbe.BLAU, false, 30);
        printer.druckeEtikett(Farbe.GRUEN, true, 7);
    }

    /**
     * Deckt Ungültige Äquivalenzklasse #010 ab
     */
    @Test(expected = IllegalArgumentException.class)
    public void ungültigeFarbe() {
        printer.druckeEtikett(Farbe.LILA, true, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullAlsFarbe() {
        printer.druckeEtikett(null, true, 7);
    }
    /**
     * Deckt Ungültige Äquivalenzklasse #200 ab
     */
    @Test
    public void legaleBreite() {
        printer.druckeEtikett(Farbe.ROT, false, 30);
    }
    /**
     * Deckt Ungültige Äquivalenzklasse #210 ab
     */
    @Test(expected = IllegalArgumentException.class)
    public void zuKleineBreite() {
        printer.druckeEtikett(Farbe.ROT, true, 6);
    }

    /**
     * Deckt Ungültige Äquivalenzklasse #211 ab
     */
    @Test(expected = IllegalArgumentException.class)
    public void zuGroßeBreite() {
        printer.druckeEtikett(Farbe.ROT, true, 31);
    }

}
