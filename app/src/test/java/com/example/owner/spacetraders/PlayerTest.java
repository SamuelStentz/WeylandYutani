package com.example.owner.spacetraders;

import org.junit.Before;
import org.junit.Test;

import com.example.owner.spacetraders.Model.Player;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class PlayerTest {
    private Player p;

    @Before
    public void setUp() {
        p = new Player();
    }

    @Test
    public void testPlayer() {
        p = new Player("Kyle", 8, 4, 2, 2);

        //Check if player attributes are set to correct values
        assertEquals("Condition true", "Kyle", p.getName());
        assertEquals("Condition true", 8, p.getPilotSkill());
        assertEquals("Condition true", 4, p.getFighterSkill());
        assertEquals("Condition true", 2, p.getTraderSkill());
        assertEquals("Condition true", 2, p.getEngineerSkill());
        assertEquals("Condition true", 1000, p.getCredits());
    }

    @Test
    public void testSkills() {
        //Check if initially set to 0
        assertEquals("Condition true", 0, p.getPilotSkill());
        assertEquals("Condition true", 0, p.getFighterSkill());
        assertEquals("Condition true", 0, p.getTraderSkill());
        assertEquals("Condition true", 0, p.getEngineerSkill());

        //Check if set methods set skill values to correct number
        p.setPilotSkill(4);
        assertEquals("Condition true", 4, p.getPilotSkill());
        p.setFighterSkill(3);
        assertEquals("Condition true", 3, p.getFighterSkill());
        p.setTraderSkill(2);
        assertEquals("Condition true", 2, p.getTraderSkill());
        p.setEngineerSkill(1);
        assertEquals("Condition true", 1, p.getEngineerSkill());
    }

    @Test
    public void testCredits() {
        //Check if initially set to 1000
        assertEquals("Condition true", 1000, p.getCredits());

        //Check if correct amount of credits is set
        p.setCredits(1500);
        assertEquals("Condition true", 1500, p.getCredits());
        p.setCredits(1000);
        assertEquals("Condition true", 1000, p.getCredits());

        //Check if removing correct amount
        p.removeCredits(750);
        assertEquals("Condition true", 250, p.getCredits());
        p.removeCredits(250);
        assertEquals("Condition true", 0, p.getCredits());

        //Check if removing too many credits results in condition being false
        p.removeCredits(300);
        assertEquals("Condition false", -50, p.getCredits());

        //Check if removing at 0 keeps credits at 0
        p.removeCredits(100);
        assertEquals("Condition true", 0, p.getCredits());

        //Check if adding correct amount
        p.addCredits(750);
        assertEquals("Condition true", 750, p.getCredits());
        p.addCredits(250);
        assertEquals("Condition true", 1000, p.getCredits());
    }

    @Test
    public void testName() {
        //Check if initially set to null
        assertEquals("Condition true", null, p.getName());

        //Check if correct name is set
        p.setName("Kyle");
        assertEquals("Condition true", "Kyle", p.getName());
    }
}