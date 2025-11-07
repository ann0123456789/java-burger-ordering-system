/**
 * This is a sub class that inherits from FoodItem abstract class,
 *  which used to represent pasta food item in the restaurant
 * Each pasta is only allowed to have 1 topping
 *
 * @author Lim Sweet Ann
 * @version 2.1
 */
public class Pasta extends FoodItem
{
    private PastaTopping topping;

    /**
     * This is a default constructor which used to initialize
     *  a default value for each field
     */
    public Pasta()
    {
        super("Pasta");
        topping = PastaTopping.NONE;
    }

    /**
     * This is a non-default constructor that used to
     *  assign 2 parameters to the attribute
     *
     * @param name name of the pasta
     * @param topping pasta topping chosen
     */
    public Pasta(String name, PastaTopping topping)
    {
        super(name);
        setTopping(topping);
    }

    /**
     * Set the topping of this pasta
     *
     * @param topping PastaTopping to be set
     */
    public void setTopping(PastaTopping topping)
    {
        if (topping == null)
        {
            this.topping = PastaTopping.NONE;
        }
        else
        {
            this.topping = topping;
        }
    }

    /**
     * Override the parent class method to determine the meal type of pasta
     *  based on the topping's category
     *
     * @return MealType of the pasta
     */
    @Override
    public MealType getMealType()
    {
        // get topping meal type from PastaTopping enum class
        return topping.getMealType();
    }

    /**
     * Override the parent class method to calculate total price of pasta
     *
     * @return total price of pasta including base price and topping cost
     */
    @Override
    public double getPrice()
    {
        // get topping price from PastaTopping enum class
        return BASEPRICE + topping.getPrice();
    }

    /**
     * This is a method used to return formatted string that represents
     *  the detail of pasta including its name, price, topping and meal type
     *
     * @return String containing all the details of pasta
     */
    @Override
    public String toString()
    {
        return super.toString() + " with topping [" + topping.name() + "] - MealType: " + getMealType();
    }
}
