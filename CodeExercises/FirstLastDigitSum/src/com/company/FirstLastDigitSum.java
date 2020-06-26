package com.company;

public class FirstLastDigitSum {
    // write a method named sumFirstAndLastDigit with one param named number
    // find the first and last digit of the parameter number using a loop
    // return the sum of the first and the last digit
    // if number is less than 0 return -1

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int sum = 0;
        int current = number;
        int decimalPlace = 1;
        while (current > 0) {
            int digit = current % 10;
            // digit is in the one's place
            if (digit * decimalPlace < 10) {
                sum += digit;
            }
            // digit is between 1-9 (ie. 5) - it is its own first and last digit
            if (current / 10 < 1) {
                sum += digit;
            }

            current /= 10;
            decimalPlace *= 10;
        }
        return sum;
    }
}
