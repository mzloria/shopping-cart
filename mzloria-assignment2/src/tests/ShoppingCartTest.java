/*
 * TCSS 305 Autumn 2018
 * Assignment 2
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import model.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

/**
 * This contains the tests for the ShoppingCart class.
 * 
 * @author Michael Zachary Loria
 * @version October 16 2018
 */
public class ShoppingCartTest
{
    /** The ShoppingCart that will be used in the tests. */
    private ShoppingCart myShoppingCart;

    /**
     * This is a method to initialize the ShoppingCart for each of the tests.
     */
    @Before
    public void setUp()
    {
        myShoppingCart = new ShoppingCart();
    }


    /**
     * Test method for {@link model.ShoppingCart#calculateTotal()}.
     */
    @Test
    public void testCalculateTotal()
    {
        //Without Membership Over $20
        myShoppingCart.setMembership(false);
        myShoppingCart.add(new ItemOrder(new Item("Shoes", new BigDecimal("39.99")), 5));
        myShoppingCart.add(new ItemOrder(new Item("Car", new BigDecimal("19.99")), 2));
        assertEquals(new BigDecimal("239.93"), myShoppingCart.calculateTotal());
        
        //With Membership Over $20
        myShoppingCart.setMembership(true);
        assertEquals(new BigDecimal("203.94"), myShoppingCart.calculateTotal());
        
        //No Items In Cart
        myShoppingCart.clear();
        assertEquals(new BigDecimal("0.00"), myShoppingCart.calculateTotal());
        
        //Without Membership Under $20
        myShoppingCart.setMembership(false);
        myShoppingCart.add(new ItemOrder(new Item("Shoes", new BigDecimal("9.99")), 2));
        assertEquals(new BigDecimal("19.98"), myShoppingCart.calculateTotal());
        
        //With Membership Under $20
        myShoppingCart.setMembership(true);
        myShoppingCart.add(new ItemOrder(new Item("Shoes", new BigDecimal("9.99")), 1));
        assertEquals(new BigDecimal("9.99"), myShoppingCart.calculateTotal());
        
        //With Bulk Quantity
        myShoppingCart.clear();
        myShoppingCart.setMembership(false);
        myShoppingCart.add(new ItemOrder(new Item("Car", new BigDecimal("19.99"), 4, 
                                                  new BigDecimal("79.99")), 10));
        assertEquals(new BigDecimal("199.96"), myShoppingCart.calculateTotal());
    }

    /**
     * Test method for {@link model.ShoppingCart#toString()}.
     */
    @Test
    public void testToString()
    {
        myShoppingCart.add(new ItemOrder(new Item("Shoes", new BigDecimal("39.99")), 5));
        myShoppingCart.add(new ItemOrder(new Item("Car", new BigDecimal("19.99")), 2));
        assertEquals("{Shoes, $39.99=5, Car, $19.99=2}", myShoppingCart.toString());
    }

}
