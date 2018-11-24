/*
 * TCSS 305 Autumn 2018
 * Assignment 2
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import org.junit.Before;
import org.junit.Test;

/**
 * This contains the tests for the Item class.
 * 
 * @author Michael Zachary Loria
 * @version October 16 2018
 */
public class ItemOrderTest
{

    /** The ItemOrder that will be used in the tests. */
    private ItemOrder myItemOrder;
    
    /**
     * This is a method to initialize the ItemOrder for each of the tests.
     */
    @Before
    public void setUp()
    {
        myItemOrder = new ItemOrder(new Item("Shoes", new BigDecimal("39.99")), 5);
    }

    /**
     * Test method for {@link model.ItemOrder#getItem()}.
     */
    @Test
    public void testGetItem()
    {
        assertEquals(new Item("Shoes", new BigDecimal("39.99")), myItemOrder.getItem());
    }

    /**
     * Test method for {@link model.ItemOrder#getQuantity()}.
     */
    @Test
    public void testGetQuantity()
    {
        assertEquals(5, myItemOrder.getQuantity());
    }

    /**
     * Test method for {@link model.ItemOrder#toString()}.
     */
    @Test
    public void testToString()
    {
        assertEquals("Shoes, $39.99, Quantity: 5", myItemOrder.toString());
    }
}
