package com.company;

import java.util.Scanner;

//-Write a method called readIntegers() with a parameter called count that represents how many integers the user needs to enter.
//    -The method needs to read from the console until all the numbers are entered, and then return an array containing the numbers entered.
//    -Write a method findMin() with the array as a parameter. The method needs to return the minimum value in the array.
//    -In the main() method read the count from the console and call the method readIntegers() with the count parameter.
//    -Then call the findMin() method passing the array returned from the call to the readIntegers() method.
//    -Finally, print the minimum element in the array.
//
//        Tips:
//        -Assume that the user will only enter numbers, never letters
//        -For simplicity, create a Scanner as a static field to help with data input
//        -Create a new console project with the name ÅeMinElementChallengeÅf

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    int[] numbers = readIntegers(5);
        System.out.println(findMin(numbers));
    }

    private static int[] readIntegers(int count) {
        int[] numbers = new int[count];

        System.out.println("Enter your numbers: \r");
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        return numbers;
    }

    private static int findMin(int[] numbers) {
        int smallestNum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallestNum) {
                smallestNum = numbers[i];
            }
        }

        return smallestNum;
    }

}
