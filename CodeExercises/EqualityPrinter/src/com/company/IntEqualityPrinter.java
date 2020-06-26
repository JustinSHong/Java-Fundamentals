package com.company;

public class IntEqualityPrinter {
    // write a method printEqual with 3 parameters of type int
    // if one of the parameters is less than 0 print "Invalid Value"
    // if all numbers are equal print "All numbers are equal"
    // if all numbers are different print text "All numbers are different"
    // otherwise print "Neither all are equal or different"

    public static void printEqual(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0) {
            System.out.println("Invalid Value");
            return;
        }

        if (x == y && y == z) {
            System.out.println("All numbers are equal");
        } else if ((x == y && y != z )|| (x != y && y == z) || (x == z && y != z )) {
            System.out.println("Neither all are equal or different");
        } else {
            System.out.println("All numbers are different");
        }
    }
}
