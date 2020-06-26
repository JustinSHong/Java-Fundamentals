package com.company;

// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();

        addTransaction(transaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }


    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("Transaction " + i + ": " + transactions.get(i));
        }
    }

    public static Customer createCustomer(String name, double transaction) {
        System.out.println("Customer: " + name + " created with transaction: " + transaction);
        return new Customer(name, transaction);
    }
}

