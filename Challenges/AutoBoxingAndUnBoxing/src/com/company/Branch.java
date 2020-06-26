package com.company;

// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(String name, double transaction) {
        if (queryCustomer(name)) {
            System.out.println("Oops that customer already exists!");
            return false;
        } else {
            customers.add(Customer.createCustomer(name, transaction));
            return true;
        }
    }

    public boolean addTransaction(String name, double transaction) {
        int position = findCustomer(name);

        if (queryCustomer(name)) {
            Customer customer = customers.get(position);
            customer.addTransaction(transaction);
            System.out.println("Customer " + name +
                                " was found and added a new transaction " +
                                transaction
            );
            return true;
        } else {
            System.out.println("Oops that customer does not exist");
            return false;
        }
    }

    public boolean queryCustomer(String name) {
        int position = findCustomer(name);

        if (position >= 0) {
            return true;
        }
        return false;
    }

    private int findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void printCustomers() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(i + ". " + customers.get(i).getName());
        }
    }

    public static Branch createBranch(String name) {
        System.out.println("Branch: " + name + " created");
        return new Branch(name);
    }

}
