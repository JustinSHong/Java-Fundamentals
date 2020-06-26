package com.company;

// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name) {
        if (queryBranch(name)) {
            System.out.println("Oops that branch already exists");
            return false;
        } else {
            branches.add(Branch.createBranch(name));
            return true;
        }
    }

    public void addCustomer(String branchName, String customerName, double initialAmount) {
//        if (findCustomer(customer.getName()) >= 0) {
//            System.out.println("Oops that customer already exists");
//        }

        int position = findBranch(branchName);
        if (position >= 0) {
            Branch branch = branches.get(position);
            branch.addCustomer(customerName, initialAmount);
        } else {
            System.out.println("Oops that branch does not exist");
        }
    }

    public void addCustomerTransaction(String branchName, String customerName, double transaction) {
        int position = findBranch(branchName);
        int customersBranch = findCustomer(customerName);

        if (position >= 0 && customersBranch >= 0) {
            branches.get(customersBranch).addTransaction(customerName, transaction);
        } else if (position < 0) {
            System.out.println("Oops that branch does not exist");
        } else {
            System.out.println("Oops that customer does not exist");
        }
    }

    private boolean queryBranch(String name) {
        int position = findBranch(name);

        if (position >= 0) {
            return true;
        }
        return false;
    }

    private int findBranch(String name) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int findCustomer(String name) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).queryCustomer(name)) {
                return i;
            }
        }
        return -1;
    }

    public void printBranches() {
        for (int i = 0; i < branches.size(); i++) {
            System.out.println(i + ". " + branches.get(i).getName());
        }
    }

    public void printCustomers() {
        for (int i = 0; i < branches.size(); i++) {
            System.out.println("***Customers for " + branches.get(i).getName() + " branch***");
            branches.get(i).printCustomers();
        }
    }

    public void printCustomerTransaction() {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            ArrayList<Customer> customers = branch.getCustomers();

            for (int j = 0; j < customers.size(); j++) {
                System.out.println("***Transactions for " + customers.get(i).getName());
                customers.get(i).printTransaction();
            }
        }
    }
}
