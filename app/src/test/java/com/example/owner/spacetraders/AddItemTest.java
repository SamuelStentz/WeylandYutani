package com.example.owner.spacetraders;

import com.example.owner.spacetraders.Model.Item;
import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.Model.PlayerInventory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for addItem.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AddItemTest {

    private PlayerInventory playerInventory;

    @Before
    public void setUp() {
        Player player = new Player();
        playerInventory = player.getInventory();
    }

    @Test
    public void testOverCapacity() {
        assertFalse("Should return false.", playerInventory.addItem(Item.ITEM_LIST.get(0), 35));
    }

    @Test
    public void testAddItemNotInInventory() {
        assertTrue("Should return true.", playerInventory.addItem(Item.ITEM_LIST.get(0), 10));
        assertEquals("Capacity incorrect.", 10, playerInventory.getCapacity());
        assertEquals("Amount of items incorrect.", 10, playerInventory.getQuantity(Item.ITEM_LIST.get(0)));
    }

    @Test
    public void testAddMultipleItems() {
        assertTrue("Should return true.", playerInventory.addItem(Item.ITEM_LIST.get(0), 10));
        assertEquals("Capacity incorrect.", playerInventory.getCapacity(), 10);
        assertEquals("Amount of items incorrect.", 10, playerInventory.getQuantity(Item.ITEM_LIST.get(0)));
        assertTrue("Should return true.", playerInventory.addItem(Item.ITEM_LIST.get(1), 10));
        assertEquals("Capacity incorrect.", 20, playerInventory.getCapacity());
        assertEquals("Amount of items incorrect.", 10, playerInventory.getQuantity(Item.ITEM_LIST.get(1)));
        assertTrue("Should return true.", playerInventory.addItem(Item.ITEM_LIST.get(0), 5));
        assertEquals("Capacity incorrect.", 25, playerInventory.getCapacity());
        assertEquals("Amount of items incorrect.", 15, playerInventory.getQuantity(Item.ITEM_LIST.get(0)));
    }
}