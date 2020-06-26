package com.company;

public class DecimalComparator {
    // write a method areEqualByThreeDecimalPlaces with 2 parameters
    // return true if params are the same up to 3 decimal places
    // return false otherwise

    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        boolean sameUpToThreeDecimalPlace = (int) (num1 * 1000) == (int) (num2 * 1000);

        if (sameUpToThreeDecimalPlace) {
            return true;
        }
        return false;
    }
}
