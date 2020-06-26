package com.company;

public class EvenDigitSum {
    // write a method called getEvenDigitSum with a param called number
    // return the sum of the even digits within the number
    // return -1, if the number is negative

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }

        int sum = 0;
        int current = number;
        while (current > 0) {
            int digit = current % 10;

            if (digit % 2 == 0) {
                sum += digit;
            }

            current /= 10;
        }

        return sum;
    }
}
