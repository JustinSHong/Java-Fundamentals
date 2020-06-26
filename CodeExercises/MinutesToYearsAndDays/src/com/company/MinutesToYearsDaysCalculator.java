package com.company;

public class MinutesToYearsDaysCalculator {
    // write a method printYearsAndDays with parameter of type long named minutes
    // calculate years and days from the minutes parameter
    // if minutes is less than 0, return "Invalid Value"
    // calculate years and days
    // print string in the format "XX min = YY y and ZZ d"
    // XX - original number of minutes
    // YY - number of years
    // ZZ - number of days

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int days = (int) (minutes / 60 / 24);
        int years = (int) (days / 365);
        int remainingDays = days % 365;

        String result = minutes + " min = " + years + " y and " + remainingDays + " d";

        System.out.println(result);
    }
}
