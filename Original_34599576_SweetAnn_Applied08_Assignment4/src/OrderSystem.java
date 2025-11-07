import java.util.ArrayList;
import java.util.Scanner;

/**
 * The OrderSystem class handles interaction between user and takeaway system
 * This class interacts with the OrderManager, Customer and FoodItem classes
 * It handles user input and validation for customer details and menu selections
 *
 * @author Lim Sweet Ann
 * @version 6.2
 */
public class OrderSystem
{
    private OrderManager orderManager;
    private Scanner scanner;
    private InputValidator inputValidator;

    /**
     * Constructs a new OrderSystem instance
     */
    public OrderSystem()
    {
        orderManager = new OrderManager();
        scanner = new Scanner(System.in);
        inputValidator = new InputValidator(scanner);
    }

    /**
     * Displays the main menu loop, allowing the user to
     * select options until they choose to exit
     */
    public void mainMenu()
    {
        int choice = 0;
        do
        {
            printMenu();
            System.out.print("Enter your choice: ");
            String userChoice = scanner.nextLine();

            try
            {
                choice = Integer.parseInt(userChoice);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number!");
                continue;
            }

            switch (choice)
            {
                case 1:
                    addNewOrder();
                    break;
                case 2:
                    deliverOrder();
                    break;
                case 3:
                    printAllOrders();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }
        while (choice != 4);
    }

    /**
     * Prints the main menu options to the console
     */
    public void printMenu()
    {
        System.out.println("\n--- Takeaway Order System Menu ---");
        System.out.println("1. Enter new customer order");
        System.out.println("2. Deliver order");
        System.out.println("3. Print all orders");
        System.out.println("4. Exit");
    }

    /**
     * Handles the process of adding a new customer order,
     * including inputting customer details and selecting food items
     */
    public void addNewOrder()
    {
        System.out.println("\nEnter Customer Details:");

        String name = inputValidator.validateName();
        String contact = inputValidator.validateContact();
        String address = inputValidator.validateAddress();

        Customer customer = new Customer(name, contact, address);

        ArrayList<FoodItem> foodItems = new ArrayList<>();

        boolean addingItems = true;
        while (addingItems) {
            System.out.println("\nSelect Food Item to add:");
            System.out.println("1. Pizza");
            System.out.println("2. Pasta");
            System.out.println("3. Done adding items");

            int foodChoice = inputValidator.validateFoodChoice();

            switch (foodChoice) {
                case 1:
                    FoodItem pizza = createPizza();
                    if (pizza != null) {
                        foodItems.add(pizza);
                        System.out.println("Pizza added.");
                    }
                    break;
                case 2:
                    FoodItem pasta = createPasta();
                    if (pasta != null) {
                        foodItems.add(pasta);
                        System.out.println("Pasta added.");
                    }
                    break;
                case 3:
                    addingItems = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        if (foodItems.isEmpty()) {
            System.out.println("No food items added. Order cancelled.");
            return;
        }

        Order order = new Order(customer, foodItems);
        orderManager.addOrder(order);
        System.out.println("\nOrder added:\n" + order);
    }

    /**
     * Creates a new Pizza object by prompting the user
     * to select toppings
     *
     * @return a new Pizza object with selected toppings
     */
    public FoodItem createPizza() {
        ArrayList<PizzaTopping> toppings = new ArrayList<>();

        System.out.println("Add pizza toppings:");
        PizzaTopping[] allToppings = PizzaTopping.values();
        int toppingIndex = 1;
        for (PizzaTopping topping : allToppings) {
            System.out.println(toppingIndex + " " + topping.name() + " $" + topping.getPrice());
            toppingIndex++;
        }

        boolean finishAdd = false;
        while (!finishAdd) {
            System.out.print("Your topping choice (0 to stop): ");
            String userInput = scanner.nextLine();

            try {
                int toppingAdd = Integer.parseInt(userInput);
                if (toppingAdd == 0) {
                    finishAdd = true;
                } else if (toppingAdd >= 1 && toppingAdd <= allToppings.length) {
                    PizzaTopping selectedTopping = allToppings[toppingAdd - 1];
                    toppings.add(selectedTopping);
                    System.out.println(selectedTopping.name() + " added.");
                } else {
                    System.out.println("Invalid option number! Please select between 1 and " + allToppings.length);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return new Pizza("Pizza", toppings);
    }

    /**
     * Creates a new Pasta object by prompting the user
     * to select one topping
     *
     * @return a new Pasta object with selected topping
     */
    public FoodItem createPasta() {
        System.out.println("Select pasta topping:");

        PastaTopping[] allToppings = PastaTopping.values();
        int toppingIndex = 1;
        for (PastaTopping topping : allToppings) {
            System.out.println(toppingIndex + " " + topping.name() + " $" + topping.getPrice());
            toppingIndex++;
        }

        int toppingChoice = -1;
        boolean validChoice = false;
        do {
            System.out.print("Your topping choice: ");
            String userInput = scanner.nextLine();

            try {
                toppingChoice = Integer.parseInt(userInput);
                if (toppingChoice < 1 || toppingChoice > allToppings.length) {
                    System.out.println("Invalid choice. Please select between 1 and " + allToppings.length);
                } else {
                    validChoice = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!validChoice);

        PastaTopping selectedTopping = allToppings[toppingChoice - 1];
        System.out.println(selectedTopping.name() + " selected.");
        return new Pasta("Pasta", selectedTopping);
    }

    /**
     * Delivers the next order in the queue
     */
    public void deliverOrder() {
        if (!orderManager.hasOrders()) {
            System.out.println("No orders to deliver.");
        }
        else
        {
            Order delivered = orderManager.deliverOrder();
            System.out.println("Delivering Order:\n" + delivered);
        }

    }

    /**
     * Prints all current orders in the system.
     */
    public void printAllOrders() {
        System.out.println("\nAll Current Orders:");
        orderManager.printAllOrders();
    }

    /**
     * Validates and returns a non-empty customer name from user input.
     *
     * @return the validated customer name
     */
    public String validateName() {
        String name;
        do {
            System.out.print("Name: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Customer name cannot be empty!");
            }
        } while (name.isEmpty());
        return name;
    }

    /**
     * Validates and returns a numeric contact number from user input.
     *
     * @return the validated contact number as a string
     */
    public String validateContact() {
        String contact;
        boolean validNumber = false;

        do {
            System.out.print("Contact Number: ");
            contact = scanner.nextLine();

            if (contact.isEmpty()) {
                System.out.println("Contact number cannot be empty!");
            } else {
                try {
                    // Long handle big numbers
                    Long.parseLong(contact);
                    validNumber = true;
                } catch (NumberFormatException e) {
                    System.out.println("Contact number must contain digits only!");
                }
            }
        } while (!validNumber);

        return contact;
    }

    /**
     * Validates and returns a non-empty delivery address from user input.
     *
     * @return the validated delivery address
     */
    public String validateAddress()
    {
        String address;
        do
        {
            System.out.print("Delivery Address: ");
            address = scanner.nextLine();
            if (address.isEmpty())
            {
                System.out.println("Delivery address cannot be empty!");
            }
        }
        while (address.isEmpty());
        return address;
    }

    /**
     * Validates the user's food item menu choice (1–3).
     *
     * @return the validated food choice as an integer
     */
    public int validateFoodChoice() {
        int foodChoice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Input your choice: ");
            String userInput = scanner.nextLine();
            try {
                foodChoice = Integer.parseInt(userInput);
                if (foodChoice >= 1 && foodChoice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid option. Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return foodChoice;
    }

    /**
     * Run the main program
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        OrderSystem system = new OrderSystem();
        system.mainMenu();
    }
}
