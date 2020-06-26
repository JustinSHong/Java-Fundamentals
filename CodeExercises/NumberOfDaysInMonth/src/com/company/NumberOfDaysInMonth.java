package com.company;

public class NumberOfDaysInMonth {
    // Write a method isLeapYear with a parameter of type int named year
    // year needs to be greater than or equal to 1 and less than or equal to 9999
    // if year is not in range return false
    // otherwise calculate if year is a leap year and return true if it is
    // otherwise return false
    // a year is a leap year if it is divisible by 4 but not by 100 OR it is divisible by 400

    // write a method getDaysInMonth with 2 parameters month and year
    // if month is less than 1 or greater than 12 return -1
    // if year is less than 1 or greater than 9999 return -1
    // return number of days in a month
    // leap years have 29days in month 2

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }

        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        }

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        switch(month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 2:
                return 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return -1;
        }
    }
}
