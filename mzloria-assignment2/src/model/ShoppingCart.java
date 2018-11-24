/*
 * TCSS 305 Autumn 2018
 * Assignment 2
 */

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the class that handles a customer's
 * overall purchase.
 * 
 * @author Michael Zachary Loria
 * @version October 16 2018
 */
public class ShoppingCart
{
    // Constant Fields (Static Final Fields)
    
    /** The 15% discount given to customers with store memberships. */
    private static final BigDecimal MEMBERSHIP_DISCOUNT = new BigDecimal("0.85");
    
    // Instance Fields
    
    /** Map that holds information about all the items the customer has ordered. */
    private final Map<Item, Integer> myMap;
    
    /** Keeps track of the total cost of all purchases made by the customer. */
    private BigDecimal myTotal;
    
    /** Keeps track of whether or not the customer has a membership. */
    private boolean myMembership;

    //Constructor
    
    /**
     * This is a constructor that creates an empty shopping cart.
     */
    public ShoppingCart()
    {
        myMap = new HashMap<Item, Integer>();
    }

    //Commands
    
    /**
     * Adds the item order to the shopping cart. It replaces
     * any previous order for an equivalent item.
     * 
     * @param theOrder The customer order that will be added to the cart.
     */
    public void add(final ItemOrder theOrder)
    {
        myMap.put(theOrder.getItem(), theOrder.getQuantity());
    }

    /**
     * Sets membership to true if the customer for this
     * shopping cart has a store membership. If not, the 
     * membership is set to false.
     * 
     * @param theMembership True if the customer has a membership; false otherwise.
     */
    public void setMembership(final boolean theMembership)
    {
        myMembership = theMembership;
    }

    /**
     * Finds the total cost of all items in the
     * shopping cart, and returns it.
     * 
     * @return A BigDecimal value representing the total cost of this shopping cart.
     */
    public BigDecimal calculateTotal()
    {
        myTotal = BigDecimal.ZERO;
        for (Item i : myMap.keySet())
        {
            if (i.isBulk())
            {
                final BigDecimal numberOfBulk = new BigDecimal(myMap.get(i) 
                                                               / i.getBulkQuantity());
                myTotal = myTotal.add(numberOfBulk.multiply(i.getBulkPrice()));
                final BigDecimal numberOfRegular = new BigDecimal(myMap.get(i)
                                                                  % i.getBulkQuantity());
                myTotal = myTotal.add(numberOfRegular.multiply(i.getPrice()));
            }
            else
            {
                myTotal = myTotal.add(i.getPrice().multiply(new BigDecimal(myMap.get(i))));
            }
        }
        if (myMembership && myTotal.compareTo(new BigDecimal("20.00")) == 1)
        {
            myTotal = myTotal.multiply(MEMBERSHIP_DISCOUNT);
        }
        return myTotal.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * Clears the current shopping cart.
     */
    public void clear()
    {
        myMap.clear();
    }
    
    //Overridden Method from Class Object
    
    /**
     * Returns a string that represents all of the 
     * items in the cart and all of their corresponding
     * quantities.
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return myMap.toString();
    }

}
