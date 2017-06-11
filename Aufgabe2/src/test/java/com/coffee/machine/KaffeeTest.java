package com.coffee.machine;

import com.coffee.machine.states.Kaffee;
import org.junit.Test;
import static org.junit.Assert.*;

public class KaffeeTest {
    /**
     * Test of waehleProdukt method, of class Kaffee.
     */
    @Test
    public void testWaehleProdukt() {
        System.out.println("waehleProdukt");
        AutomatenSteuerung automat = new AutomatenSteuerung();
        String produkt = "";
        Kaffee instance = new Kaffee(0);
        instance.waehleProdukt(automat, produkt);
    }

    /**
     * Test of waehleOption method, of class Kaffee.
     */
    @Test
    public void testWaehleOption() {
        System.out.println("waehleOption");
        AutomatenSteuerung automat = new AutomatenSteuerung();
        Kaffee instance = new Kaffee(140);
        instance.waehleOption(automat, "Milch");
        instance.waehleOption(automat, "Zucker");
        assertEquals(0, instance.zapfeProdukt(automat));
        instance = new Kaffee(140);
        instance.waehleOption(automat, "Keks");
        instance.waehleOption(automat, "Zwiebel");
        assertEquals(20, instance.zapfeProdukt(automat));
    }

    /**
     * Test of fordereWechselgeld method, of class Kaffee.
     */
    @Test
    public void testFordereWechselgeld() {
        System.out.println("fordereWechselgeld");
        AutomatenSteuerung automat = new AutomatenSteuerung();;
        Kaffee instance = new Kaffee(150);
        int expResult = 30;
        int result = instance.fordereWechselgeld(automat);
        System.out.println("Wechselgeld: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of zapfeProdukt method, of class Kaffee.
     */
    @Test
    public void testZapfeProdukt() {
        System.out.println("zapfeProdukt");
        AutomatenSteuerung automat = new AutomatenSteuerung();;
        Kaffee instance = new Kaffee(120);
        int expResult = 0;
        int result = instance.zapfeProdukt(automat);
        assertEquals(expResult, result);
        instance = new Kaffee(130);
        instance.waehleOption(automat, "Milch");
        result = instance.zapfeProdukt(automat);
        assertEquals(expResult, result);
        instance = new Kaffee(140);
        instance.waehleOption(automat, "Milch");
        instance.waehleOption(automat, "Zucker");
        result = instance.zapfeProdukt(automat);
        assertEquals(expResult, result);
        instance = new Kaffee(150);
        instance.waehleOption(automat, "Milch");
        instance.waehleOption(automat, "Zucker");
        instance.waehleOption(automat, "Schokostreusel");
        result = instance.zapfeProdukt(automat);
        assertEquals(expResult, result);
        expResult = 10;
        instance = new Kaffee(160);
        instance.waehleOption(automat, "Milch");
        instance.waehleOption(automat, "Zucker");
        instance.waehleOption(automat, "Schokostreusel");
        result = instance.zapfeProdukt(automat);
        assertEquals(expResult, result);

    }

    /**
     * Test of abbruch method, of class Kaffee.
     */
    @Test
    public void testAbbruch() {
        System.out.println("abbruch");
        AutomatenSteuerung automat = new AutomatenSteuerung();
        Kaffee instance = new Kaffee(1);
        int expResult = 1;
        int result = instance.abbruch(automat);
        assertEquals(expResult, result);
        instance = new Kaffee(2);
        expResult = 2;
        result = instance.abbruch(automat);
        assertEquals(expResult, result);
        instance = new Kaffee(400);
        expResult = 400;
        result = instance.abbruch(automat);
        assertEquals(expResult, result);
        instance = new Kaffee(0);
        expResult = 0;
        result = instance.abbruch(automat);
        assertEquals(expResult, result);
        instance = new Kaffee(-1);
        expResult = -1;
        result = instance.abbruch(automat);
        assertEquals(expResult, result);
        instance = new Kaffee(200);
        expResult = 200;
        result = instance.abbruch(automat);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProduktName method, of class Kaffee.
     */
    @org.junit.Test
    public void testGetProduktName() {
        System.out.println("getProduktName");
        Kaffee instance = new Kaffee(2);
        String expResult = "Kaffee";
        String result = instance.getProduktName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPreis method, of class Kaffee.
     */
    @org.junit.Test
    public void testGetPreis() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        System.out.println("getPreis");
        Kaffee instance = new Kaffee(700);
        int expResult = 120;
        int result = instance.getPreis();
        assertEquals(expResult, result);
        instance.waehleOption(automat, "Milch");
        assertEquals(expResult, result);
        instance.waehleOption(automat, "Banane");
        instance.waehleOption(automat, "Milch");
        assertEquals(expResult, result);
        instance.waehleOption(automat, "Banane");
        assertEquals(expResult, result);
        instance.waehleOption(automat, "Milch");
        instance.waehleOption(automat, "Zucker");
        assertEquals(expResult, result);
        instance.waehleOption(automat, "");
        assertEquals(expResult, result);
    }

    /**
     * Test of getOptionsCost method, of class Kaffee.
     */
    @Test
    public void testGetOptionsCost() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        System.out.println("getOptionsCost");
        Kaffee instance = new Kaffee(0);
        int expResult = 0;
        int result = instance.getOptionsCost();
        assertEquals(expResult, result);
        instance.waehleOption(automat, "Milch");
        assertEquals(10, instance.getOptionsCost());
        instance.waehleOption(automat, "Milch");
        assertEquals(10, instance.getOptionsCost());
        instance.waehleOption(automat, "Milch");
        instance.waehleOption(automat, "Milch");
        assertEquals(10, instance.getOptionsCost());
        instance.waehleOption(automat, "Zucker");
        assertEquals(20, instance.getOptionsCost());
        instance.waehleOption(automat, "Milch");
        assertEquals(20, instance.getOptionsCost());
        instance.waehleOption(automat, "Schokostreusel");
        assertEquals(30, instance.getOptionsCost());
        instance.waehleOption(automat, "Schokostreusel");
        instance.waehleOption(automat, "Paprika");
        instance.waehleOption(automat, "Vegane Milch");
        assertEquals(30, instance.getOptionsCost());
    }

}
