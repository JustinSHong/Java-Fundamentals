package com.company;

public class SharedDigit {
    // write a method named hasSharedDigit with 2 parameters
    // each param should be within the range 10-99 inclusive otherwise return false
    // return true if there is a digit that appears in both numbers
    // otherwise return false

    public static boolean hasSharedDigit(int x, int y) {
        if (x < 10 || x > 99 || y < 10 || y > 99) {
            return false;
        }

        int max = 0;
        int min = 0;

        if (x > y) {
            max = x;
            min = y;
        } else {
            max = y;
            min = x;
        }

        while (max > 0) {
            int maxDigit = max % 10;

            int minCurrent = min;
            while (minCurrent > 0) {
                int minDigit = minCurrent % 10;

                if (maxDigit == minDigit) {
                    return true;
                }

                minCurrent /= 10;
            }

            max /= 10;
        }
        return false;
    }
}
