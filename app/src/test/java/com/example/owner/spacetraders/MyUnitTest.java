package com.example.owner.spacetraders;

import com.example.owner.spacetraders.Model.Spaceship;

import org.junit.Before;
import org.junit.Test;
import android.util.Log;

import com.example.owner.spacetraders.Model.Spaceship;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MyUnitTest {
    private Spaceship s;

    @Before
    public void setUp() {
        s = new Spaceship();
    }

    @Test
    public void testLoseFuelGreaterThanCurr(){
        double currFuel = s.getCurrentFuel();
        s.loseFuel(300);
        assertEquals("condition true", currFuel, s.getCurrentFuel());
    }

    @Test
    public void testLoseFuelSmallerThanCurr() {
        double currFuel = s.getCurrentFuel();
        s.loseFuel(30);
        assertEquals("condition false", currFuel - 30, s.getCurrentFuel());
    }

    @Test
    public void testLoseAllFuel() {
        double currFuel = s.getCurrentFuel();
        s.setCurrentFuel(1000);
        currFuel = s.getCurrentFuel();
        s.loseFuel(0);
        assertEquals("condition false", currFuel, s.getCurrentFuel());
        s.setCurrentFuel(1000);
        currFuel = s.getCurrentFuel();
        s.loseFuel(1000);
        assertEquals("condition false", 0.0, s.getCurrentFuel());

    }

    @Test
    public void testLoseZeroFuel() {
        double currFuel = s.getCurrentFuel();
        s.loseFuel(0);
        assertEquals("condition false", currFuel, s.getCurrentFuel());
    }
}
