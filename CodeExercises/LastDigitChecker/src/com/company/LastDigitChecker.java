package com.company;

public class LastDigitChecker {
    // write a method named hasSameLastDigit with 3 parameters
    // each param should be in range 10-1000 inclusive
    // if not in range return false
    // return true if at least 2 of the numbers share the rightmost digit
    // otherwise return false

    // write a method named isValid with one param
    // return true if number is in range 10-1000

    public static boolean hasSameLastDigit(int x, int y, int z) {
        if (!isValid(x) || !isValid(y) || !isValid(z)) {
            return false;
        }

        int rightMostX = x % 10;
        int rightMostY = y % 10;
        int rightMostZ = z % 10;

        if (rightMostX == rightMostY || rightMostX == rightMostZ || rightMostY == rightMostZ) {
            return true;
        }

        return false;
    }

    public static boolean isValid(int n) {
        return (n >= 10 && n <= 1000) ? true : false;
    }
}
