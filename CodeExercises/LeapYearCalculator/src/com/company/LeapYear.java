package com.company;

public class LeapYear {
    // write a method isLeapYear with a parameter named year
    // year should be greater than or equal to 1 and less than or equal to 9999
    // if year is valid calculate if the year is a leap year (return true if it is otherwise return false)

    // steps to determine if year is a leap year
    // year is evenly divisible by 4 -> evenly divisible by 100 -> evenly divisible by 400 -> is a leap year
    // year is not evenly divisible by 4 -> not a leap year
    // year is evenly divisible by 4 -> not evenly divisible by 100 -> is a leap year
    // year is evenly divisible by 4 -> evenly divisible by 100 -> not evenly divisible by 400 -> is not a leap year

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }

        boolean evenlyDivisibleBy4 = (year % 4 == 0);
        boolean evenlyDivisibleBy100 = (year % 100 == 0);
        boolean evenlyDivisibleBy400 = (year % 400 == 0);

        if (evenlyDivisibleBy4 && evenlyDivisibleBy100 && evenlyDivisibleBy400) {
            return true;
        } else if (evenlyDivisibleBy4 && !evenlyDivisibleBy100) {
            return true;
        } else if (evenlyDivisibleBy4 && !evenlyDivisibleBy100 && evenlyDivisibleBy400) {
            return true;
        } else if (evenlyDivisibleBy4 && !evenlyDivisibleBy100 && !evenlyDivisibleBy400) {
            return false;
        }

        return false;
    }
}
