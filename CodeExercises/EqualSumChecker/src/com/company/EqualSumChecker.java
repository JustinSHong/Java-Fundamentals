package com.company;

public class EqualSumChecker {
    // write a method hasEqualSum with 3 parameters of type int
    // return true if the sum of the first and second parameters equal the third
    // return false otherwise

    public static boolean hasEqualSum(int num1, int num2, int num3) {

        if (num1 + num2 == num3) {
            return true;
        }
        return false;
    }
}
