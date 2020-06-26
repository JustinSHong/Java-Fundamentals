package com.company;

public class TeenNumberChecker {
    // a number is teen if it is in the range 13-19 inclusive
    // write a method hasTeen with 3 parameters
    // return true if one of the params is in range 13-19
    // otherwise return false

    // write another method isTeen with one parameter
    // return true if it is in the range 13-19

    public static boolean hasTeen(int num1, int num2, int num3) {
        boolean num1InRange = num1 >= 13 && num1 <= 19;
        boolean num2InRange = num2 >= 13 && num2 <= 19;
        boolean num3InRange = num3 >= 13 && num3 <= 19;

        return num1InRange || num2InRange || num3InRange;
    }

    public static boolean isTeen(int num) {
        return num >= 13 && num <= 19;
    }
}
