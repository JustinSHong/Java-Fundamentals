package com.company;

public class SumOddRange {
    // write a method called isOdd that returns a boolean
    // if n is less than 0 return false
    // if number is odd return true, otherwise return false

    // write another method called sumOdd that has 2 params, start and end
    // use a for loop to sum all odd numbers in between the range start-end
    // use isOdd to check if each number is odd
    // the parameter end need to be greater than or equal to start
    // start and end must be greater than 0
    // if these conditions are not true return -1;

    public static boolean isOdd(int number) {
        if (number < 0) {
            return false;
        }

        return number % 2 == 1 ? true : false;
    }

    public static int sumOdd(int start, int end) {
        if (end < start || end < 0 || start < 0) {
            return -1;
        }

        int sum = 0;

        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
