package com.company;

public class BankAccount {

    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    // USE CONSTRUCTOR CHAINING TO AVOID DUPLICATING CODE

    public BankAccount() {
        // calling a constructor from another constructor
        this("1111", 1.00d, "John", "johnDoe@gmail.com", "222-222-2222");
        System.out.println("Empty constructor called");
    }
    // constructors can be overloaded
    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber) {
        System.out.println("CONSTRUCTOR SETTING FIELD VALUES");
        // best practice to set field values in constructors directly without using setters
            // in certain situations setters might not be called
            // when constructors are called - parts of initialization may not be finished
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    // constructor to partially assign some field members and default others
    public BankAccount(String customerName, String email, String phoneNumber) {
        this("1111", 1.00d, customerName, email, phoneNumber);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void depositFunds(double funds) {
        System.out.println("previous balance is " + getBalance());
        setBalance(this.balance + funds);
        System.out.println("funds being deposited are " + funds);
        System.out.println("new balance is " + getBalance());
    }

    public void withdrawFunds(double funds) {
        if (funds > this.balance) {
            System.out.println("oops you do not have sufficient funds to make this withdrawal");
            return;
        }

        System.out.println("previous balance is " + getBalance());
        setBalance(this.balance - funds);
        System.out.println("funds being withdrawn are " + funds);
        System.out.println("new balance is " + getBalance());
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

}
