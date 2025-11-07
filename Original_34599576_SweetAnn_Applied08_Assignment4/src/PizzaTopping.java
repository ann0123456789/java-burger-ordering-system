/**
 * Enum representing the toppings of pizza available in
 *  the restaurant.
 * Each topping has its own price and meal type
 *
 * @author Lim Sweet Ann
 * @version 2.1
 */
public enum PizzaTopping
{
    HAM(2, MealType.MEAT),
    CHEESE(2, MealType.VEGETARIAN),
    PINEAPPLE(2.5, MealType.VEGETARIAN),
    MUSHROOMS(2, MealType.VEGETARIAN),
    TOMATO(2, MealType.VEGETARIAN),
    SEAFOOD(3.5, MealType.MEAT);

    private final double price;
    private final MealType mealType;

    /**
     * Non-default constructor for PizzaTopping with
     *  specified price and meal type
     *
     * @param price price of the topping
     * @param mealType meal type category of the topping
     */
    PizzaTopping(double price, MealType mealType)
    {
        this.price = price;
        this.mealType = mealType;
    }

    /**
     * Check is the topping categorized as meat
     *
     * @return true if it is categorized as meat
     */
    public boolean isMeat()
    {
        return this.mealType == MealType.MEAT;
    }

    /**
     * Check is the topping categorized as vegetarian
     *
     * @return true if it is categorized as vegetarian
     */
    public boolean isVegetarian()
    {
        return this.mealType == MealType.VEGETARIAN;
    }

    // only have getter methods as enum is constant and
    //   cannot be modified after defined
    public double getPrice()
    {
        return price;
    }

    public MealType getMealType()
    {
        return mealType;
    }
}
