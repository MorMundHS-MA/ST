/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffee.machine.states;

import com.coffee.machine.AutomatenSteuerung;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class KaffeeTest {

    public KaffeeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of bezahleBetrag method, of class Kaffee.
     */
    @org.junit.Test
    public void testBezahleBetrag() {
        System.out.println("bezahleBetrag");
        AutomatenSteuerung automat = null;
        int betrag = 0;
        Kaffee instance = null;
        instance.bezahleBetrag(automat, betrag);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of waehleProdukt method, of class Kaffee.
     */
    @org.junit.Test
    public void testWaehleProdukt() {
        System.out.println("waehleProdukt");
        AutomatenSteuerung automat = null;
        String produkt = "";
        Kaffee instance = null;
        instance.waehleProdukt(automat, produkt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of waehleOption method, of class Kaffee.
     */
    @org.junit.Test
    public void testWaehleOption() {
        System.out.println("waehleOption");
        AutomatenSteuerung automat = null;
        String option = "";
        Kaffee instance = null;
        instance.waehleOption(automat, option);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of fordereWechselgeld method, of class Kaffee.
//     */
//    @org.junit.Test
//    public void testFordereWechselgeld() {
//        System.out.println("fordereWechselgeld");
//        AutomatenSteuerung automat = new AutomatenSteuerung();;
//        Kaffee instance = new Kaffee(2000);
//        int expResult = 1880;
//        instance.bezahleBetrag(automat, 120);
//        instance.zapfeProdukt(automat);
//        int result = instance.fordereWechselgeld(automat);
//        assertEquals(expResult, result);
//    }

//    /**
//     * Test of zapfeProdukt method, of class Kaffee.
//     */
//    @org.junit.Test
//    public void testZapfeProdukt() {
//        System.out.println("zapfeProdukt");
//        AutomatenSteuerung automat = new AutomatenSteuerung();;
//        Kaffee instance = new Kaffee(2000);
//        int expResult = 1900;
//        int result = instance.fordereWechselgeld(automat);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of abbruch method, of class Kaffee.
     */
    @org.junit.Test
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
     * Test of getMoeglicheOptionen method, of class Kaffee.
     */
    @org.junit.Test
    public void testGetMoeglicheOptionen() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        System.out.println("getMoeglicheOptionen");
        Kaffee instance = new Kaffee(1);
        String[] expResult = new String[]{"Milch", "Schokostreusel", "Zucker"};
        String[] result = instance.getMoeglicheOptionen();
        assertArrayEquals(expResult, result);
        instance.waehleOption(automat, "Milch");
        result = instance.getMoeglicheOptionen();
        assertArrayEquals(expResult, result);
        instance.waehleOption(automat, "Zucker");
        instance.waehleOption(automat, "Schokostreusel");
        instance.waehleOption(automat, "Keks");
        result = instance.getMoeglicheOptionen();
        assertArrayEquals(expResult, result);
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
