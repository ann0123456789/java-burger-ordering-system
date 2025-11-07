import java.util.Scanner;

public class InputValidator
{
    private Scanner scanner;

    public InputValidator(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public String validateName()
    {
        String name;
        do
        {
            System.out.print("Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty())
            {
                System.out.println("Customer name cannot be empty!");
            }
        }
        while (name.isEmpty());
        return name;
    }

    public String validateContact()
    {
        String contact;
        boolean validNumber = false;

        do
        {
            System.out.print("Contact Number (with country code, +60): ");
            contact = scanner.nextLine().trim();

            if (contact.isEmpty())
            {
                System.out.println("Contact number cannot be empty!");
            }
            else if (!contact.substring(0,3).equals("+60")){
                System.out.println("Contact number must start with '+60'!");
            }
            else
            {
                String numberPart = contact.substring(1);
                try
                {
                    Long.parseLong(numberPart);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Contact number must contain digits only!");
                }

                if (numberPart.length() > 9)
                {
                    validNumber = true;
                }
                else
                {
                    System.out.println("Contact number cannot be less than 10 digit!");
                }
            }
        }
        while (!validNumber);

        return contact;
    }

    public String validateAddress()
    {
        String address;
        do
        {
            System.out.print("Delivery Address: ");
            address = scanner.nextLine().trim();
            if (address.isEmpty())
            {
                System.out.println("Delivery address cannot be empty!");
            }
        }
        while (address.isEmpty());
        return address;
    }

    public int validateFoodChoice()
    {
        int foodChoice = 0;
        boolean validChoice = false;
        while (!validChoice)
        {
            System.out.print("Input your choice: ");
            String userInput = scanner.nextLine().trim();
            try
            {
                foodChoice = Integer.parseInt(userInput);
                if (foodChoice >= 1 && foodChoice <= 3)
                {
                    validChoice = true;
                }
                else
                {
                    System.out.println("Invalid option. Please enter 1, 2, or 3.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return foodChoice;
    }
}
