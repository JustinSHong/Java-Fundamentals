package com.company;

public class PlayingCat {
    // write a method isCatPlaying with 2 parameters, summer and temperature
    // return false if temperature is not in range 25-45
    // return false if not in range 25-35, summer is false
    // return true if temperature is in range 25-35

    public static boolean isCatPlaying(boolean summer, int temperature) {
        if (summer && (temperature >= 25 && temperature <= 45)) {
            return true;
        } else if (!summer && (temperature >= 25 && temperature <= 35)) {
            return true;
        }

        return false;
    }
}
