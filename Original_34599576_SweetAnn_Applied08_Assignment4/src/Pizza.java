import java.util.ArrayList;

/**
 * This is a sub class that inherits from FoodItem abstract class,
 *  which used to represent pizza food item in the restaurant
 *
 * @author Lim Sweet Ann
 * @version 3.2
 */
public class Pizza extends FoodItem
{
    private ArrayList<PizzaTopping> toppings;

    /**
     * This is a default constructor which used to initialize
     *  a default value for each field
     */
    public Pizza()
    {
        super("Pizza");
        // initialize toppings to empty list
        toppings = new ArrayList<>();
    }


    /**
     * This is a non-default constructor that used to
     *  assign 2 parameters to the attribute
     *
     * @param name name of the pizza
     * @param toppings list of pizza toppings
     */
    public Pizza(String name, ArrayList<PizzaTopping> toppings)
    {
        super(name);
        setToppings(toppings);
    }

    /**
     * Set the toppings of this pizza
     * @param toppings list of pizza toppings
     */
    public void setToppings(ArrayList<PizzaTopping> toppings)
    {
        if (toppings == null)
        {
            this.toppings = new ArrayList<>();
        }
        else
        {
            this.toppings = new ArrayList<>(toppings);
        }
    }

    /**
     * Override the parent class method to determine the meal type of the pizza
     *
     * @return MealType of the pizza
     */
    @Override
    public MealType getMealType()
    {
        if (toppings.isEmpty())
        {
            return MealType.VEGAN;
        }

        // track if vegetarian topping exists
        boolean hasVegetarian = false;

        // for each loop to check category of pizza based on toppings
        for (PizzaTopping topping : toppings)
        {
            if (topping.isMeat())
            {
                // if have meat toppings - pizza directly categorized as MEAT
                return MealType.MEAT;
            }
            else if (topping.isVegetarian())
            {
                hasVegetarian = true;
            }
        }

        // Check if vegetarian topping exists
        if (hasVegetarian)
        {
            return MealType.VEGETARIAN;
        }
        else
        {
            return MealType.VEGAN;
        }
    }

    /**
     * Override the parent class method to calculate total price of pizza
     *
     * @return total price of pizza including base price and topping cost
     */
    @Override
    public double getPrice()
    {
        double toppingCost = 0;
        for (PizzaTopping topping : toppings)
        {
            // get topping price from PizzaTopping enum class
            toppingCost += topping.getPrice();
        }
        return BASEPRICE + toppingCost;
    }

    /**
     * This is a method used to return formatted string that represents
     *  the detail of pizza including its name, price, toppings and meal type
     *
     * @return String containing all the details of pizza
     */
    @Override
    public String toString()
    {
        return super.toString() + " with toppings " + toppings.toString() +
                " - MealType: " + getMealType();
    }
}