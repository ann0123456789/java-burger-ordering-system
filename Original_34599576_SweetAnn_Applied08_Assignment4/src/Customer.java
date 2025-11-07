/**
 * This customer class is used to store information
 * of customers of the restaurant
 *
 * @author Lim Sweet Ann
 * @version 3.2
 * */
public class Customer
{
    private String name;
    private String contactNumber;
    private String deliveryAddress;

    /**
     * This is a default constructor which used to initialize
     *  a default value for each field in Customer class
     */
    public Customer()
    {
        name = "Alice";
        contactNumber = "0123456789";
        deliveryAddress = "James Road";
    }

    /**
     * This is a non-default constructor that used to
     *  assign 3 parameters to the attribute
     *
     * @param name name of the customer
     * @param contactNumber contact number of the customer
     * @param deliveryAddress delivery address of the customer
     */
    public Customer(String name, String contactNumber, String deliveryAddress)
    {
        this.name = name;
        this.contactNumber = contactNumber;
        this.deliveryAddress = deliveryAddress;
    }

    //accessor/getter method
    //the following getter methods are used to
    //  retrieves the value of each field
    public String getContactNumber()
    {
        return contactNumber;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public String getName()
    {
        return name;
    }

    //mutator/setter method
    //the following setter methods are used to alter/update value of each field
    public  void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    public void setDeliveryAddress(String deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * This is a method used to return formatted string that represents
     *  the customer details
     *
     * @return String containing all the details of customer
     */
    public String toString()
    {
        return "Name: " + name + ", Contact Number: " + contactNumber +
                ", Delivery Address:" + deliveryAddress;
    }
}
