package Persistence;

import Business.Customer;

import java.util.List;

public interface CustomerDAO {


    //Get all Customers matching the supplied name exactly
    public List<Customer> selectCustomeByName(String name);

    //Get all Customers with a customer name containing the supplied text
    public List<Customer> selectCustomersContainingName(String name);

    //Get the Customer matching the specified customer id number
    public Customer findCustomerById(int customerNumber);

    //Add the supplied Customer object to the database (return true if successful & false
    //otherwise). Remember that when you do an insert, you need an extra catch!
    public boolean addCustomer(Customer c);



}
