/**
 * This is a super abstract class that used to represent general food items
 *  in the restaurant
 *
 * @author Lim Sweet Ann
 * @version 1.2
 */
public abstract class FoodItem
{
    protected String name;
    public final static double BASEPRICE = 11.50;

    /**
     * Non-default constructor that assign FoodItem with specified name
     *
     * @param name name of the food item
     */
    public FoodItem(String name)
    {
        this.name = name;
    }

    /**
     * Getter method for the food item's meal type
     *
     * @return the meal type of the food item
     */
    public abstract MealType getMealType();

    /**
     * Getter method for the food item's price
     *
     * @return price of the food item
     */
    public abstract double getPrice();

    /**
     * Getter method for the food item's name
     *
     * @return name of the food item
     */
    public String getName()
    {
        return name;
    }

    /**
     * This is a method used to return formatted string that represents
     *  the food item details
     *
     * @return string representation of the food item
     */
    @Override
    public String toString()
    {
        return name + " ($" + String.format("%.2f", getPrice()) + ")";
    }
}
