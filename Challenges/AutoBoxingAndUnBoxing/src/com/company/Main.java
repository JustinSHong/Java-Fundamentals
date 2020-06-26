package com.company;

// You job is to create a simple banking application.
// There should be a Bank class
    // It should have an arraylist of Branches
    // Each Branch should have an arraylist of Customers

// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions

public class Main {

    public static void main(String[] args) {
	    Bank bank_of_washington = new Bank("Bank of Washington");

	    bank_of_washington.addBranch("North Seattle");
	    bank_of_washington.addBranch("West Seattle");

	    bank_of_washington.printBranches();

	    bank_of_washington.addCustomer("North Seattle", "John", 100d);
	    bank_of_washington.addCustomer("North Seattle", "Mike", 200d);
	    bank_of_washington.addCustomer("North Seattle", "Justin", 300d);

	    bank_of_washington.addCustomer("West Seattle", "Jessica", 150d);
	    bank_of_washington.addCustomer("West Seattle", "Alice", 175d);
	    bank_of_washington.addCustomer("West Seattle", "Tessa", 232d);

		bank_of_washington.addCustomerTransaction("North Seattle", "John", 555d);
		bank_of_washington.addCustomerTransaction("North Seattle", "Mike", 666d);
		bank_of_washington.addCustomerTransaction("North Seattle", "Justin", 777d);

		bank_of_washington.addCustomerTransaction("West Seattle", "Jessica", 3333d);
		bank_of_washington.addCustomerTransaction("West Seattle", "Alice", 4444d);
		bank_of_washington.addCustomerTransaction("West Seattle", "Tessa", 5555d);

		bank_of_washington.printCustomers();
		bank_of_washington.printCustomerTransaction();

		bank_of_washington.addCustomer("xxx", "Luke", 999d);
		bank_of_washington.addBranch("North Seattle");
		bank_of_washington.addCustomerTransaction("North Seattle", "xxx", 111d);
		bank_of_washington.addCustomer("North Seattle", "John", 100d);
    }
}
