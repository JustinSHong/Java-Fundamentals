package com.company;

public class FactorPrinter {
    // write a method named printFactors with one param named number
    // number less than 1 print "Invalid Value"
    // print all factors of a number
    // a factor is an integer which divides that number without a remainder

    public static void printFactors(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }
}
