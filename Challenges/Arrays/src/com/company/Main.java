package com.company;

// Create a program using arrays that sorts a list of integers in descending order.
// Descending order is highest value to lowest.
// In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
// ultimately have an array with 106,81,26, 15, 5 in it.
// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers

// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers

// you will have to figure out how to copy the array elements from the passed array into a new
// array and sort them and return the new sorted array.

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numArray = getIntegers(5);
        printArray(sortIntegers((numArray)));
        System.out.println("hello");
    }

    public static int[] getIntegers(int number) {
        int[] numbers = new int[number];
        System.out.println("Enter your numbers: ");
        for (int i = 0; i < number; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    public static void printArray(int[] numArray) {
        for (int i = 0; i < numArray.length; i++) {
            System.out.println("value at index " + i + " is " + numArray[i]);
        }
    }

    public static int[] sortIntegers(int[] numArray) {
//        int[] sorted = new int[numArray.length];
        boolean flag = true;
        int temp;

//        for (int i = 0; i < numArray.length; i++) {
//            sorted[i] = numArray[i];
//        }

        int[] sorted = Arrays.copyOf(numArray, numArray.length); // copies an existing arrays

        while (flag) {
            flag = false;

            for (int i = 0; i < sorted.length - 1; i++) {
                if (sorted[i] < sorted[i + 1]) {
                    temp = sorted[i + 1];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sorted;
    }
}
