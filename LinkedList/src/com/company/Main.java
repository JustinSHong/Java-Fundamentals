package com.company;

//  java allocates 4 bytes of memory for each integer
    // take base address of the 1st array element to grab the value
    // calculate address of any value: (base address) + 4 * index
    // this is similar for other primitives

// what about Strings and objects? they can have variable sizes
    // 8 bytes for a string in an array ----> points to an address where the string is
        // allows java to keep track of string values
        // allows strings to be a variable link

// garbage collection frees up used memory

// string addresses are not contiguous

// linked lists are alternatives to arrays
	// store link to next item
	// store data

// linked lists offer better performance for modifications O(1) - insertions and deletions, sorting

// in Java linked lists are doubly-linked --> references to the previous items are stored as well

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Customer customer = new Customer("John", 54.96);
	    Customer anotherCustomer;

	    anotherCustomer = customer;
	    anotherCustomer.setBalance(12.18);

        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(2);
        intList.add(3);

        for (int i = 0; i < intList.size(); i++) {
			System.out.println(i + ": " + intList.get(i));
		}

        // modifications to ArrayList force other elements to be repositioned
			// can be quite costly if there are millions of items
        intList.add(1, 2); // insert 2 at position 1

		for (int i = 0; i < intList.size(); i++) {
			System.out.println(i + ": " + intList.get(i));
		}
    }
}
