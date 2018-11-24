/*
 * TCSS 305 Autumn 2018
 * Assignment 2
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

/**
 * This is the class that handles information about an
 * individual item.
 * 
 * @author Michael Zachary Loria
 * @version October 16 2018
 */
public final class Item
{
    // Constant Fields (Static Final Fields)

    /** This is the constant field for the number formatting. */
    private static final NumberFormat NUM_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);
    
    // Instance Fields
    
    /** This stores the name of the item. */
    private final String myName;
    
    /** This stores the price of the item. */
    private final BigDecimal myPrice;
    
    /** This stores the bulk quantity of the item (if applicable). */
    private final int myBulkQuantity;
    
    /** This stores the bulk price of the item (if applicable). */
    private final BigDecimal myBulkPrice;
    
    // Constructors
    
    /**
     * This is the constructor that takes a name 
     * and the price for the item. 
     * 
     * @param theName The name of the item.
     * @param thePrice The price of the item.
     */
    public Item(final String theName, final BigDecimal thePrice)
    {
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = 0;
        myBulkPrice = null;
    }
    
    /**
     *  This is the constructor that takes a name,
     *  a price, a bulk quantity, and a bulk price
     *  for the item.
     *  
     * @param theName The name of the item.
     * @param thePrice The price of the item.
     * @param theBulkQuantity The bulk quantity of the item.
     * @param theBulkPrice The bulk price of the item.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice)
    {
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;
    }
    
    //Queries
    
    /**
     * What is the name of the item?
     * 
     * @return The name of the item.
     */
    public String getName()
    {
        return myName;
    }
    
    /**
     * What is the the price of the item?
     * 
     * @return The price of the item.
     */
    public BigDecimal getPrice()
    {
        return myPrice;
    }
    
    /**
     *  What is the bulk quantity of the item?
     *  
     * @return The bulk quantity of the item.
     */
    public int getBulkQuantity()
    {
        return myBulkQuantity;
    }
    
    /**
     * What is the bulk price of the item?
     * 
     * @return The bulk price of the item.
     */
    public BigDecimal getBulkPrice()
    {

        return myBulkPrice;
    }
    
    /**
     * Does this item have bulk pricing?
     * 
     * @return True if the item has bulk pricing; false otherwise.
     */
    public boolean isBulk()
    {
        if (myBulkQuantity == 0)
        {
            return false;
        }
        return true;
    }
    
    //Overridden Methods from Class Object
    
    /**
     * Returns a String that represents this Item. 
     * If there is no bulk quantity: Shoes, $39.99
     * If there is a bulk quantity: Shoes, $39.99 (2 for $69.99)
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder(128);
        builder.append(myName);
        builder.append(", ");
        builder.append(NUM_FORMAT.format(myPrice));
        if (isBulk())
        {
            builder.append(" (");
            builder.append(myBulkQuantity);
            builder.append(" for ");
            builder.append(NUM_FORMAT.format(myBulkPrice));
            builder.append(")");
        }
        return builder.toString();
    }
    
    /**
     * Returns true if the parameter is an item with equivalent
     * names, prices, bulk quantities, and bulk prices.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object theOther)
    {
        boolean result = false;
        if ((theOther != null)  && (theOther.getClass() == this.getClass()))
        {
            final Item otherItem = (Item) theOther;
            
            result = Objects.equals(myPrice, otherItem.myPrice)
                    && Objects.equals(myBulkPrice, otherItem.myBulkPrice) 
                    && Objects.equals(myName, otherItem.myName)
                    && (myBulkQuantity == otherItem.myBulkQuantity);
        }
        return result;
    }
    
    /**
     * Returns an integer hash code for the current item.
     * 
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
    }

}
