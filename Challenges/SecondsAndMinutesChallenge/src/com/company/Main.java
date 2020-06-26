package com.company;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
	    String duration1 = getDurationString(65L, 45L);
	    String duration2 = getDurationString(3945L);
        System.out.println("duration = " + duration1);
        System.out.println("duration = " + duration2);
    }

    public static String getDurationString(long minutes, long seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59) {
            System.out.println("Invalid input given");
            return INVALID_VALUE_MESSAGE;
        }
        // calculate hours, minutes, and seconds
        long hours = minutes / 60;
        long minutesRemaining = minutes % 60;

        String result = (hours < 10 ? "0" + hours : hours) + "h "
                        + (minutesRemaining < 10 ? "0" + minutesRemaining : minutesRemaining) + "m "
                        + (seconds < 10 ? "0" + seconds : seconds) + "s";
        return result;
    }

    public static String getDurationString(long seconds) {
        if (seconds < 0) {
            System.out.println("Invalid input given");
            return INVALID_VALUE_MESSAGE;
        }
        // calculate minutes and seconds
        long minutes = seconds / 60;
        long secondsRemaining = seconds % 60;

        return getDurationString(minutes, secondsRemaining);
    }
}
