package com.company;

import java.util.Scanner;

// Arrays - data structure hold multiple values of the same type

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        int myVariable = 50;
//        int[] myVariable;
//        myVariable = new int[10]; // assigning space to an array

        int[] myVariable2 = new int[10];
        myVariable2[5] = 50;

        System.out.println(myVariable2[5]);

        // initializing an array - can only do this while defining a variable
        int[] myIntArray = {1,2,3,4,5,6,7,8,9,10}; // array initializer block aka anonymous array
        System.out.println(myIntArray[0]);
        System.out.println(myIntArray[1]);
        System.out.println(myIntArray[2]);
        System.out.println(myIntArray[3]);
        System.out.println(myIntArray[4]);

        // initializing an array with a loop
        int[] myIntArray2 = new int[10];
        for (int i = 0; i < 10; i++) {
            myIntArray2[i] = i * 10;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Index " + i + " has value " + myIntArray2[i]);
        }

        // use length property of arrays
        for (int i = 0; i < myIntArray2.length; i++) {
            myIntArray2[i] = i * 10;
        }
        for (int i = 0; i < myIntArray2.length; i++) {
            System.out.println("Index " + i + " has value " + myIntArray2[i]);
        }

        int[] myIntegers = getIntegers(5);
        for (int i = 0; i < myIntegers.length; i++) {
            System.out.println("Index " + i + " has value " + myIntegers[i]);
        }

        System.out.println("The average is " + getAverage(myIntegers));
    }

    // obtain nums from user
    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt(); // accepts an int from console and store it in the array
        }

        return values;
    }

    public static double getAverage(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return (double) sum / (double) array.length;
    }
}
