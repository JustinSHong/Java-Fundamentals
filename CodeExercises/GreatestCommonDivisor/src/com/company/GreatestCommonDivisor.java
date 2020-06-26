package com.company;

public class GreatestCommonDivisor {
    // write a method named getGreatestCommonDivisor with 2 params, first and second
    // if one param is less than 10 return -1
    // return the gcd of the 2 numbers
    // gcd is the largest positive integer that can fully divide into each of the integers with no remainder

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }

        int gcd = 0;
        int max = first > second ? first : second;
        for (int i = 1; i < max; i++ ) {
            if (first % i == 0 && second % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }
}
