package com.company;

public class Main {
    // converting Strings to different data types

    public static void main(String[] args) {
	    String numberAsString = "2018";
        System.out.println("numberAsString = " + numberAsString);

        // use parsing methods
        int number = Integer.parseInt(numberAsString);
        System.out.println("number = " + number);

        numberAsString += 1; // 20181 - Java converts 1 to a string and concatenates it
        number += 1; // 2019 - incr by 1
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number = " + number);

        numberAsString = "2018.125";
        double number2 = Double.parseDouble(numberAsString);
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number2 = "  + number2);

        numberAsString += 1;
        number2 += 1.00;
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number2 = "  + number2);
    }
}
