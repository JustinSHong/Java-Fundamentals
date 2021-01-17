package com.company;

// final - used to define constant values
    // can be modified once before the constructor() finishes
        // assign a value at declaration or in constructor

// static final - real constants associated with a class
	// each instance doesn't need to maintain a separate value of a constant

// final classes - prevent class from being sub-classed (no-inheritance)
// final constructors - prevent instances from being made
// final methods - prevent overrides

// static initialization blocks --> static constructors
	// only executed once when a class is first loaded in to the project
	// ALL STATIC FINAL VARIABLES MUST BE INITIALIZED BEFORE A STATIC CONSTRUCTOR IS TERMINATED
		// assign value of a static final variable in a static initialization block
		// RARELY USED

public class Main {

    public static void main(String[] args) {
	    SumClass one = new SumClass("one");
	    SumClass two  = new SumClass("two");
	    SumClass three  = new SumClass("three");

	    // each instance maintains its own value
		System.out.println(one.getInstanceNumber());
		System.out.println(two.getInstanceNumber());
		System.out.println(three.getInstanceNumber());

		// has private access
//		Math m = new Math();

		int pw = 674312;
		Password password = new Password(pw);
		password.storePassword();
		password.letMeIn(1234);
		password.letMeIn(123);
		password.letMeIn(12);
		password.letMeIn(1);
		password.letMeIn(674312);

		Password password1 = new ExtendedPassword(pw);
		password1.storePassword(); // exposes the actual password!
		password1.letMeIn(1234);
		password1.letMeIn(123);
		password1.letMeIn(12);
		password1.letMeIn(1);
		password1.letMeIn(674312);

		System.out.println("Main method called");
		SIBTest test = new SIBTest();
		test.someMethod();
		System.out.println("Owner is " + SIBTest.owner);
    }
}
