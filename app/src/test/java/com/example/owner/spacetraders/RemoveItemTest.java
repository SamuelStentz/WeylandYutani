package com.example.owner.spacetraders;

import com.example.owner.spacetraders.Model.Item;
import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.Model.PlayerInventory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RemoveItemTest {
    private PlayerInventory inventory;
    @Before
    public void setUp() {
        Player player = new Player();
        inventory = player.getInventory();
    }
    @Test
    public void removeSuccessfulTest() {
        inventory.addItem(Item.ITEM_LIST.get(0), 10);
        assertTrue("remove 5 (should be true)", inventory.removeItem(Item.ITEM_LIST.get(0), 5));
        assertEquals("capacity should be 5", 5, inventory.getCapacity());
        assertTrue("remove 2 more (should be true)", inventory.removeItem(Item.ITEM_LIST.get(0), 2));
        assertEquals("capacity should be 3", 3, inventory.getCapacity());
        assertTrue("remove 3 more (should be true)", inventory.removeItem(Item.ITEM_LIST.get(0), 3));
        assertEquals("capacity should be 0", 0, inventory.getCapacity());
    }
    @Test
    public void removeEmptyInventory() {
        assertFalse("should be false", inventory.removeItem(Item.ITEM_LIST.get(0), 1));
    }
    @Test
    public void removeTooManyItems(){
        inventory.addItem(Item.ITEM_LIST.get(0), 10);
        assertFalse("Should fail on removing 11 items from 10 units", inventory.removeItem(Item.ITEM_LIST.get(0), 11));
    }
    @Test
    public void multipleRemovesTest(){
        inventory.addItem(Item.ITEM_LIST.get(0), 10);
        inventory.addItem(Item.ITEM_LIST.get(1), 5);
        inventory.addItem(Item.ITEM_LIST.get(2), 5);
        assertEquals("capacity should be 20", 20, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(0), 7));
        assertEquals("capacity should be 13", 13, inventory.getCapacity());
        assertEquals("should be 3", 3, inventory.getQuantity(Item.ITEM_LIST.get(0)));
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(1), 4));
        assertEquals("capacity should be 9", 9, inventory.getCapacity());
        assertEquals("should be 1", 1, inventory.getQuantity(Item.ITEM_LIST.get(1)));
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(2), 2));
        assertEquals("capacity should be 7", 7, inventory.getCapacity());
        assertEquals("should be 3", 3, inventory.getQuantity(Item.ITEM_LIST.get(2)));
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(0), 3));
        assertEquals("capacity should be 4", 4, inventory.getCapacity());
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(0)));
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(1), 1));
        assertEquals("capacity should be 3", 3, inventory.getCapacity());
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(1)));
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(2), 3));
        assertEquals("capacity should be 0", 0, inventory.getCapacity());
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(2)));
    }
    @Test
    public void extensiveRemoveTest(){
        inventory.addItem(Item.ITEM_LIST.get(0), 5);
        inventory.addItem(Item.ITEM_LIST.get(1), 5);
        inventory.addItem(Item.ITEM_LIST.get(2), 5);
        inventory.addItem(Item.ITEM_LIST.get(3), 5);
        inventory.addItem(Item.ITEM_LIST.get(4), 5);
        inventory.addItem(Item.ITEM_LIST.get(5), 5);
        assertEquals("capacity should be 30", 30, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(0), 5));
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(0)));
        assertEquals("capacity should be 25", 25, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(1), 3));
        assertEquals("should be 2", 2, inventory.getQuantity(Item.ITEM_LIST.get(1)));
        assertEquals("capacity should be 22", 22, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(1), 2));
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(1)));
        assertEquals("capacity should be 20", 20, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(2), 1));
        assertEquals("should be 4", 4, inventory.getQuantity(Item.ITEM_LIST.get(2)));
        assertEquals("capacity should be 19", 19, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(3), 4));
        assertEquals("should be 1", 1, inventory.getQuantity(Item.ITEM_LIST.get(3)));
        assertEquals("capacity should be 15", 15, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(2), 4));
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(2)));
        assertEquals("capacity should be 11", 11, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(3), 1));
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(3)));
        assertEquals("capacity should be 10", 10, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(4), 1));
        assertEquals("should be 4", 4, inventory.getQuantity(Item.ITEM_LIST.get(4)));
        assertEquals("capacity should be 9", 9, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(5), 1));
        assertEquals("should be 4", 4, inventory.getQuantity(Item.ITEM_LIST.get(5)));
        assertEquals("capacity should be 8", 8, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(4), 1));
        assertEquals("should be 3", 3, inventory.getQuantity(Item.ITEM_LIST.get(4)));
        assertEquals("capacity should be 7", 7, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(5), 1));
        assertEquals("should be 3", 3, inventory.getQuantity(Item.ITEM_LIST.get(5)));
        assertEquals("capacity should be 6", 6, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(4), 1));
        assertEquals("should be 2", 2, inventory.getQuantity(Item.ITEM_LIST.get(4)));
        assertEquals("capacity should be 5", 5, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(5), 1));
        assertEquals("should be 2", 2, inventory.getQuantity(Item.ITEM_LIST.get(5)));
        assertEquals("capacity should be 4", 4, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(4), 1));
        assertEquals("should be 1", 1, inventory.getQuantity(Item.ITEM_LIST.get(4)));
        assertEquals("capacity should be 3", 3, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(5), 1));
        assertEquals("should be 1", 1, inventory.getQuantity(Item.ITEM_LIST.get(5)));
        assertEquals("capacity should be 2", 2, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(4), 1));
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(4)));
        assertEquals("capacity should be 1", 1, inventory.getCapacity());
        assertTrue("should return true", inventory.removeItem(Item.ITEM_LIST.get(5), 1));
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(5)));
        assertEquals("capacity should be 0", 0, inventory.getCapacity());
    }
    @Test
    public void mixValidAndInvalidRemovesTest(){
        inventory.addItem(Item.ITEM_LIST.get(0), 10);
        inventory.addItem(Item.ITEM_LIST.get(1), 5);
        assertTrue("should be true", inventory.removeItem(Item.ITEM_LIST.get(0), 5));
        assertEquals("should be 5", 5, inventory.getQuantity(Item.ITEM_LIST.get(0)));
        assertEquals("should be 10", 10, inventory.getCapacity());
        assertFalse("should be false", inventory.removeItem(Item.ITEM_LIST.get(0), 10));
        assertEquals("should still be 5", 5, inventory.getQuantity(Item.ITEM_LIST.get(0)));
        assertEquals("should still be 10", 10, inventory.getCapacity());
        assertFalse("should not remove items not in inventory", inventory.removeItem(Item.ITEM_LIST.get(2), 1));
        assertTrue("should be true", inventory.removeItem(Item.ITEM_LIST.get(1), 5));
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(1)));
        assertEquals("should be 5", 5, inventory.getCapacity());
        assertFalse("cannot remove more now that item is gone", inventory.removeItem(Item.ITEM_LIST.get(1), 1));
        assertEquals("should still be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(1)));
        assertEquals("should still be 5", 5, inventory.getCapacity());
        assertTrue("should be true", inventory.removeItem(Item.ITEM_LIST.get(0), 5));
        assertEquals("should be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(0)));
        assertEquals("should be 0", 0, inventory.getCapacity());
        assertFalse("cannot remove more now that item is gone", inventory.removeItem(Item.ITEM_LIST.get(0), 1));
        assertEquals("should still be 0", 0, inventory.getQuantity(Item.ITEM_LIST.get(0)));
        assertEquals("should still be 0", 0, inventory.getCapacity());
    }
    @Test
    public void removeZeroFromEmptyInventoryTest(){
        assertFalse("should not be able to remove 0 from empty list", inventory.removeItem(Item.ITEM_LIST.get(0), 0));
    }
    @Test
    public void removeZeroFromNonemptyInventoryTest(){
        inventory.addItem(Item.ITEM_LIST.get(0), 1);
        assertFalse("should not be able to remove zero", inventory.removeItem(Item.ITEM_LIST.get(0), 0));
        assertEquals("capacity should be 1", 1, inventory.getQuantity(Item.ITEM_LIST.get(0)));
    }
    @Test
    public void removeNegativeFromEmptyInventoryTest(){
        assertFalse("should not be able to remove negative of something", inventory.removeItem(Item.ITEM_LIST.get(0), -1));
    }
    @Test
    public void removeNegativeFromNonEmptyInventoryTest(){
        inventory.addItem(Item.ITEM_LIST.get(0), 1);
        assertFalse("should not be able to remove a negative of something", inventory.removeItem(Item.ITEM_LIST.get(0), -1));
        inventory.removeItem(Item.ITEM_LIST.get(0), -1);
        assertEquals("capacity should be 1", 1, inventory.getQuantity(Item.ITEM_LIST.get(0)));
    }
}
