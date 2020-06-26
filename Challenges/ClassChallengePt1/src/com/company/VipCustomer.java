package com.company;

public class VipCustomer {

    private String name;
    private double creditLimit;
    private String email;

    // constructor 3 - save all the fields
    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }
    // constructor 1 - call with 3 parameters with defaults
    public VipCustomer() {
        this("John Doe", 1000d, "johnDoeVIP@gmail.com");
    }
    // constructor 2 - pass on 2 values it receives on init, default the 3rd
    public VipCustomer(String name, String email) {
        this(name, 11111d, email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
