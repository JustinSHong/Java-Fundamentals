package com.company;

public class PerfectNumber {
    // write a method isPerfectNumber with one param, number
    // number less than 1 return false
    // if number is perfect return true otherwise return false
    // a number is perfect if it is positive and equal to the sum of its proper divisors (excluding the number itself)

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number ? true : false;
    }
}
