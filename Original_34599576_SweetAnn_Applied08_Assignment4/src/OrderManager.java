import java.util.ArrayList;

/**
 * OrderManager class used to manage a list of customer orders of restaurant
 * It allows adding new orders, delivering next order,
 *  printing all current orders and checking active orders
 *
 * @author Lim Sweet Ann
 * @version 3.1
 */
public class OrderManager
{
    private ArrayList<Order> orders;

    /**
     * Constructs a new OrderManager with an empty order list
     */
    public OrderManager()
    {
        orders = new ArrayList<>();
    }

    /**
     * Add new order to the list
     *
     * @param order Order object to be added
     */
    public void addOrder(Order order)
    {
        orders.add(order);
    }

    /**
     * Delivers (removes) the next order in the list
     *
     * @return delivered Order (null if the list is empty)
     */
    public Order deliverOrder()
    {
        if (orders.isEmpty())
        {
            return null;
        }
        return orders.remove(0);
    }

    public ArrayList<Order> getOrders()
    {
        return orders;
    }

    /**
     * Prints the details of all orders available
     */
    public void printAllOrders()
    {
        if (orders.isEmpty())
        {
            System.out.println("No orders to display.");
        }
        for (Order order : orders)
        {
            System.out.println(order);
            System.out.println("-----------");
        }
    }

    /**
     * Check for active orders
     *
     * @return true if there are one or more orders (false if no order)
     */
    public boolean hasOrders()
    {
        return !orders.isEmpty();
    }
}
