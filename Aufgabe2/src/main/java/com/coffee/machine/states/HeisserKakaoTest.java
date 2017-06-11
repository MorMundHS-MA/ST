package com.coffee.machine.states;

import com.coffee.machine.AutomatenStatus;
import com.coffee.machine.AutomatenSteuerung;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeisserKakaoTest {
    
    public HeisserKakaoTest() {
    }

    /**
     * Kakao und dessen Temperaturauswahl geschieht in einem Schritt.
     */
    @Test
    public void testIII() {
        AutomatenSteuerung automat = new AutomatenSteuerung();
        AutomatenStatus status = automat.getStatus();
        HeisserKakao instance = new HeisserKakao(90);
    }
    
}
