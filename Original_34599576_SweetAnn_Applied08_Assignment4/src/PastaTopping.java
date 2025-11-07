/**
 * Enum representing the toppings of pasta available in
 *  the restaurant.
 * Each topping has its own price and meal type (vegan, vegetarian or meat)
 *
 * @author Lim Sweet Ann
 * @version 2.1
 */
public enum PastaTopping
{
    BOLOGNESE(5.20, MealType.MEAT),
    MARINARA(6.80, MealType.MEAT),
    PRIMAVERA(5.20, MealType.VEGETARIAN),
    TOMATO(4.00, MealType.VEGAN),
    NONE(0.00, MealType.VEGAN);

    private final double price;
    private final MealType type;

    /**
     * Non-default constructor for PastaTopping with
     *  specified price and meal type
     *
     * @param price price of the topping
     * @param type meal type category of the topping
     */
    PastaTopping(double price, MealType type)
    {
        // private constructor: enum cannot be created outside enum class
        this.price = price;
        this.type = type;
    }

    // only have getter methods as enum is constant and
    //   cannot be modified after defined
    public double getPrice()
    {
        return price;
    }

    public MealType getMealType()
    {
        return type;
    }
}
