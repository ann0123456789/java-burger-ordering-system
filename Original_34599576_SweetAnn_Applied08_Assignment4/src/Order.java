import java.util.ArrayList;

/**
 * Order class used to represent food ordered by customers in the restaurant
 * Each order has a unique ID, customer, a list of food items, meal type and
 *  total price of that order
 *
 * @author Lim Sweet Ann
 * @version 4.2
 */
public class Order
{
    // class variable used to generate unique order ID
    private static int nextOrderId = 1;

    private int orderId;
    private Customer customer;
    private ArrayList<FoodItem> foodItems;
    private MealType mealType;
    private double totalCost;

    /**
     * This is a default constructor which used to initialize
     *  a default value for each field in Order class
     */
    public Order()
    {
        this.orderId = nextOrderId++;
        this.customer = null;
        this.foodItems = new ArrayList<>();
        this.mealType = MealType.VEGAN;
        this.totalCost = 0.0;
    }

    /**
     * This is a non-default constructor that used to
     *  assign 2 parameters to the attribute
     *
     * @param customer customer who place the order
     * @param foodItems list of food items in the order
     */
    public Order(Customer customer, ArrayList<FoodItem> foodItems)
    {
        this.orderId = nextOrderId++;
        this.customer = customer;
        this.foodItems = new ArrayList<>(foodItems);
        this.mealType = determineMealType();
        this.totalCost = calculateTotalCost();
    }

    /**
     * Determines the overall meal type of the order
     *
     * @return MealType of the entire order
     */
    private MealType determineMealType()
    {
        // track if vegetarian topping exists
        boolean hasVegetarian = false;

        // for each loop to check category of food item in order
        for (FoodItem item : foodItems)
        {
            // call getMealType() method implemented in subclass
            MealType type = item.getMealType();

            if (type == MealType.MEAT)
            {
                // if have meat type - order directly categorized as MEAT
                return MealType.MEAT;
            }
            else if (type == MealType.VEGETARIAN)
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
     * Calculates total cost of the order that includes all food items
     *
     * @return total cost of the order
     */
    private double calculateTotalCost()
    {
        double sum = 0;
        for (FoodItem item : foodItems)
        {
            // get price of each food item
            sum += item.getPrice();
        }
        return sum;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public ArrayList<FoodItem> getFoodItems()
    {
        return foodItems;
    }

    public MealType getMealType()
    {
        return mealType;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public void setCustomer(Customer customer)
    {
        if (customer != null)
        {
            this.customer = customer;
        }
    }

    /**
     * Set the food items list and recalculates meal type and total
     *
     * @param foodItems list of FoodItem
     */
    public void setFoodItems(ArrayList<FoodItem> foodItems)
    {
        if (foodItems != null)
        {
            this.foodItems = new ArrayList<>(foodItems);
            this.mealType = determineMealType();
            this.totalCost = calculateTotalCost();
        }
    }

    /**
     * This is a method used to return formatted string that represents
     *  the order details
     *
     * @return String containing all the details of order
     */
    @Override
    public String toString() {
        String result = "Order #" + orderId + "\n" +
                "Customer: " + customer.getName() +
                " (" + customer.getContactNumber() + ")\n" +
                "Address: " + customer.getDeliveryAddress() + "\n" +
                "Meal Type: " + mealType + "\n" +
                "Items:\n";

        for (FoodItem item : foodItems) {
            result += "- " + item + "\n";
        }

        result += String.format("Total Cost: $%.2f", totalCost);
        return result;
    }

    /**
     * Adds a food item to the order and updates total
     *
     * @param item FoodItem to be added
     */
    public void addFoodItem(FoodItem item)
    {
        foodItems.add(item);
        mealType = determineMealType();
        totalCost = calculateTotalCost();
    }

    /**
     * Removes a food item from the order and updates total
     *
     * @param item FoodItem to be removed
     */
    public void removeFoodItem(FoodItem item) {
        foodItems.remove(item);
        mealType = determineMealType();
        totalCost = calculateTotalCost();
    }


}
