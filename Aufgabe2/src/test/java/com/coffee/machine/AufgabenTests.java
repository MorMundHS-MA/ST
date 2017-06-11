package com.coffee.machine;

import com.coffee.machine.states.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Alle Tests die auf dem Aufgabenblatt vorgeben wurden.
 */
public class AufgabenTests {
    /**
     * Der Benutzer waehlt ein Getraenk, waehlt eine Option und bricht den Vorgang ab.
     */
    @Test
    public void TestI() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        automat.waehleProdukt("Tee");
        assertThat(automat.getStatus(), instanceOf(Tee.class));
        automat.waehleOption("Zucker");
        assertThat(automat.getStatus(), instanceOf(Tee.class));
        automat.abbruch();
        assertThat(automat.getStatus(), instanceOf(Leerlauf.class));
    }

    /**
     * Der Benutzer waehlt ein Getraenk, zahlt zu viel Geld, zapft das Getraenk und erhaelt Wechselgeld
     */
    @Test
    public void TestII() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        automat.waehleProdukt("Kaffee");
        assertThat(automat.getStatus(), instanceOf(Kaffee.class));
        automat.waehleOption("Milch");
        assertThat(automat.getStatus(), instanceOf(Kaffee.class));
        automat.bezahleBetrag(300);
        assertThat(automat.getStatus(), instanceOf(Bezahlung.class));
        assertEquals(170, automat.zapfeProdukt());
        assertThat(automat.getStatus(), instanceOf(Leerlauf.class));
    }

    /**
     * Der Benutzer waehlt Kakao, zahlt passend aber waehlt keine Temperatur aus.
     */
    @Test
    public void TestIII() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        automat.waehleProdukt("Kakao");
        assertThat(automat.getStatus(), instanceOf(HeisserKakao.class));
        automat.bezahleBetrag(90);
        assertThat(automat.getStatus(), instanceOf(Bezahlung.class));
        assertEquals(0, automat.zapfeProdukt());
        assertThat(automat.getStatus(), instanceOf(Leerlauf.class));
    }

    /**
     * Der Benutzer waehlt ein Getraenk mit einer unzulaessigen Option.
     */
    @Test
    public void TestIV() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        automat.waehleProdukt("Kaffee");
        assertThat(automat.getStatus(), instanceOf(Kaffee.class));
        automat.waehleOption("Rum");
        assertThat(automat.getStatus(), instanceOf(Kaffee.class));
        assertEquals(0, ((Kaffee) automat.getStatus()).getOptionsCost());
    }

    /**
     * Der Benutzer waehlt eine Option bevor ein Getraenk ausgewaehlt wurde.
     */
    @Test
    public void TestV() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        automat.waehleOption("Extra Kaese");
        assertThat(automat.getStatus(), instanceOf(Leerlauf.class));
    }

    /**
     * Der Benutzer zahlt passend fur ein Getraenk, waehlt eine Option und versucht das Getraenk zu zapfen.
     */
    @Test
    public void TestVI() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        automat.waehleProdukt("Tee");
        automat.bezahleBetrag(100);
        assertThat(automat.getStatus(), instanceOf(Bezahlung.class));
        automat.waehleOption("Zucker");
        assertThat(automat.getStatus(), instanceOf(Bezahlung.class));
        assertEquals(0, automat.zapfeProdukt());
        assertThat(automat.getStatus(), instanceOf(Bezahlung.class));
    }

}
