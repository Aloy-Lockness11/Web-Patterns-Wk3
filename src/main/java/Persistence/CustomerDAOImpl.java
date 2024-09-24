package Persistence;

import Business.Customer;
import Database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl extends DAO implements CustomerDAO {
    public CustomerDAOImpl(String databaseName){
        super(databaseName);
    }

    //Get all Customers matching the supplied name exactly
    @Override
    public List<Customer> selectCustomeByName(String name){

        List<Customer> custList = new ArrayList<>();
        Connection con = super.getConnection();

        String querry = "SELECT * FROM customer WHERE customerName = ?";

        try(PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setString(1,name);
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Customer customer = new Customer(
                            rs.getInt("customerNumber"),
                            rs.getString("contactLastName"),
                            rs.getString("contactFirstName"),
                            rs.getString("phone"),
                            rs.getString("addressLine1"),
                            rs.getString("addressLine2"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getString("postalCode"),
                            rs.getString("country"),
                            rs.getInt("salesRepEmployeeNumber"),
                            rs.getDouble("creditLimit")
                    );
                    custList.add(customer);
                }
            }catch(SQLException e){
                System.out.println(LocalDateTime.now() + ": An SQLException  occurred while running the query" +
                        " or processing the result.");
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }catch(SQLException e){
            System.out.println(LocalDateTime.now() + ": An SQLException  occurred while preparing the SQL " +
                    "statement.");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }


        super.freeConnection(con);

        return custList;
    }

    //Get all Customers with a customer name containing the supplied text
    @Override
    public List<Customer> selectCustomersContainingName(String name){

        List<Customer> custList = new ArrayList<>();
        Connection con = super.getConnection();

        String querry = "SELECT * FROM customer WHERE customerName like ?";

        try(PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setString(1,name);
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Customer customer = new Customer(
                            rs.getInt("customerNumber"),
                            rs.getString("contactLastName"),
                            rs.getString("contactFirstName"),
                            rs.getString("phone"),
                            rs.getString("addressLine1"),
                            rs.getString("addressLine2"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getString("postalCode"),
                            rs.getString("country"),
                            rs.getInt("salesRepEmployeeNumber"),
                            rs.getDouble("creditLimit")
                    );
                    custList.add(customer);
                }
            }catch(SQLException e){
                System.out.println(LocalDateTime.now() + ": An SQLException  occurred while running the query" +
                        " or processing the result.");
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }catch(SQLException e){
            System.out.println(LocalDateTime.now() + ": An SQLException  occurred while preparing the SQL " +
                    "statement.");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }


        super.freeConnection(con);

        return custList;
    }

    //Get the Customer matching the specified customer id number
    @Override
    public Customer findCustomerById(int customerNumber){
        Connection con = super.getConnection();
        Customer customer = null;

        String querry = "SELECT * FROM customer WHERE customerNumber = ?";

        try(PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setInt(1, customerNumber);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    customer = new Customer(
                            rs.getInt("customerNumber"),
                            rs.getString("contactLastName"),
                            rs.getString("contactFirstName"),
                            rs.getString("phone"),
                            rs.getString("addressLine1"),
                            rs.getString("addressLine2"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getString("postalCode"),
                            rs.getString("country"),
                            rs.getInt("salesRepEmployeeNumber"),
                            rs.getDouble("creditLimit")
                    );
                }
            }catch(SQLException e){
                System.out.println(LocalDateTime.now() + ": An SQLException  occurred while running the query" +
                        " or processing the result.");
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }catch(SQLException e){
            System.out.println(LocalDateTime.now() + ": An SQLException  occurred while preparing the SQL " +
                    "statement.");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }


        super.freeConnection(con);

        return customer;
    }

    //Add the supplied Customer object to the database (return true if successful & false
    //otherwise). Remember that when you do an insert, you need an extra catch!
    @Override
    public boolean addCustomer(Customer c) {
        return false;
    }
}
