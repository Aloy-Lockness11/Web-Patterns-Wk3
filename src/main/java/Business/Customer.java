package Business;

import java.util.Objects;

public class Customer {
    /*customerNumber int(11) NOT NULL,
       customerName varchar(50) NOT NULL,
       contactLastName varchar(50) NOT NULL,
       contactFirstName varchar(50) NOT NULL,
       phone varchar(50) NOT NULL,
       addressLine1 varchar(50) NOT NULL,
       addressLine2 varchar(50) default NULL,
       city varchar(50) NOT NULL,
       `state` varchar(50) default NULL,
       postalCode varchar(15) default NULL,
       country varchar(50) NOT NULL,
       salesRepEmployeeNumber int(11) default NULL,
       creditLimit double default NULL,

     */
    private int customerNumber;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private int salesEmployeeNumber;
    private double creditLimit;

    public Customer(int customerNumber, String contactLastName, String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, int salesEmployeeNumber, double creditLimit) {
        this.customerNumber = customerNumber;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesEmployeeNumber = salesEmployeeNumber;
        this.creditLimit = creditLimit;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public int getSalesEmployeeNumber() {
        return salesEmployeeNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", contactLastName='" + contactLastName + '\'' +
                ", contactFirstName='" + contactFirstName + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", salesEmployeeNumber=" + salesEmployeeNumber +
                ", creditLimit=" + creditLimit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getCustomerNumber() == customer.getCustomerNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerNumber());
    }
}
