package com.company;

// use constructors to set initial values of class fields
// Java creates constructors for you when you use "new" keyword -> calls constructor() to create object

// constructors only have access modifier and class name
// constructors can be called from other constructors - use one constructor to create an object with default values (no params passed)

public class Main {

    public static void main(String[] args) {

//	    BankAccount checking = new BankAccount("123456789", 100d, "Justin", "lakdfjal@gmail.com", "000-000-0000");
        BankAccount checking = new BankAccount(); // default constructor called
	    checking.setAccountNumber("123456789");
	    checking.depositFunds(100d);
	    checking.setCustomerName("Justin");
	    checking.setEmail("lakdfjal@gmail.com");
	    checking.setPhoneNumber("000-000-0000");

        System.out.println("account number: " + checking.getAccountNumber());
        System.out.println("funds available " + checking.getBalance());
        System.out.println("customer name " + checking.getCustomerName());
        System.out.println("customer email " + checking.getEmail());
        System.out.println("customer phone number " + checking.getPhoneNumber());

        checking.withdrawFunds(1000d);
        checking.depositFunds(100d);

        System.out.println("**************");

        BankAccount justinAccount = new BankAccount("Justin", "justin123@gmail.com", "222-222-2222");

        System.out.println("justin's name " + justinAccount.getCustomerName());
        System.out.println("justin's email " + justinAccount.getEmail());
        System.out.println("justin's phone # " + justinAccount.getPhoneNumber());
        System.out.println("justin's account number " + justinAccount.getAccountNumber());
        System.out.println("justin's balance " + justinAccount.getBalance());

        System.out.println("**************");

        VipCustomer jamesBond = new VipCustomer("James Bond", 999999d, "333-333-3333");
        System.out.println("james bond name " + jamesBond.getName());
        System.out.println("james bond credit " + jamesBond.getCreditLimit());
        System.out.println("james bond email " + jamesBond.getEmail());

        System.out.println("**************");

        VipCustomer johnDoe = new VipCustomer();
        System.out.println("name " + johnDoe.getName());
        System.out.println("credit " + johnDoe.getCreditLimit());
        System.out.println("email " + johnDoe.getEmail());

        System.out.println("**************");

        VipCustomer janeDoe = new VipCustomer("Jane Doe", "janeDoe232@gmail.com");
        System.out.println("jane doe name " + janeDoe.getName());
        System.out.println("jane doe credit " + janeDoe.getCreditLimit());
        System.out.println("jane doe email " + janeDoe.getEmail());
    }
}
