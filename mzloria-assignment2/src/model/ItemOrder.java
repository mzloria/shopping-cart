/*
 * TCSS 305 Autumn 2018
 * Assignment 2
 */

package model;

/**
 * This is the class that handles information
 * about an order for a particular Item.
 * 
 * @author Michael Zachary Loria
 * @version October 16 2018
 */
public final class ItemOrder
{
    // Instance Fields
    
    /** The specific Item for this order. */
    private final Item myItem;
    
    /** The quantity of the given Item in this order. */
    private final int myQuantity;
    
    // Constructor
    
    /**
     * This is the constructor that takes in a specific 
     * item and a quantity for the item.
     * 
     * @param theItem The item that will be used for this order.
     * @param theQuantity The amount of the item needed for this order.
     */
    public ItemOrder(final Item theItem, final int theQuantity)
    {
        myItem = theItem;
        myQuantity = theQuantity;
    }
    
    // Queries
    
    /** 
     * What is the Item in this order?
     * 
     * @return The Item that is used in this order.
     */
    public Item getItem()
    {
        return myItem;
    }
    
    /**
     * How many of the Item is needed in this order?
     * 
     * @return An integer value representing the amount of Items needed.
     */
    public int getQuantity()
    {
        return myQuantity;
    }
    
    //Overridden Method from Class Object

    /**
     * Returns a String that represents this item order.
     * Displays in the format: Shoes, $39.99, Quantity: 5
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder(128);
        builder.append(myItem);
        builder.append(", Quantity: ");
        builder.append(myQuantity);
        return builder.toString();
    }

}