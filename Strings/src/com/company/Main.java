package com.company;

// classes are custom data types that combine primitive types
// String is a special data type that is not a primitive - it's a Class

// strings in Java are immutable - new strings are created and old ones are discarded
// manipulating strings like this is inefficient -> use a StringBuffer

public class Main {

    public static void main(String[] args) {
	// byte
    // short
    // int
    // long
    // float
    // double
    // char
    // boolean

        String myStr = "this is a string";
        System.out.println("my string is equal to " + myStr);

        String numberString = "250.55"; // numbers as strings are treated as text not numbers
        numberString = numberString + "49.99";
        System.out.println(numberString);

        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("Last string is equal to " + lastString); // "1050"

        double doubleNumber = 120.47d;
        lastString = lastString + doubleNumber;
        System.out.println("Last string is equal to " + lastString); // "1050120.47"
    }

}
