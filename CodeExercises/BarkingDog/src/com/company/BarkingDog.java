package com.company;

public class BarkingDog {
    // write a method called shouldWakeUp that has 2 parameters: isBarking and hourOfDay
    // hourOfDay has a valid range of 0-23
    // return true if dog is barking before 8 or after 22 hours
    // return false otherwise
    // return false if hourOfDay is less than 0 or greater than 23

    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23 || !isBarking) {
            return false;
        }

        if (isBarking && (hourOfDay < 8 || hourOfDay > 22)) {
            return true;
        }
        // all other cases of dog is barking between 8-22 hours
        return false;
    }
}
