package com.company;

import java.util.Scanner;

public class Main {
    // nextLine()
    // Scanner - util class that parses primitive types and String

    // problem - what happens if I enter a negative number for birth year?
    // solution - validate user input (birth year should be greater than 0)

    // problem - what happens if I enter strings for birth year? -> program crashes
    // solution -  nextInt can't parse chars

    public static void main(String[] args) {
        // create an instance of Scanner
	    Scanner scanner = new Scanner(System.in); // accept user input with System.in

        System.out.println("Enter your year of birth: ");
        boolean hasNextInt = scanner.hasNextInt(); // checks if input given is an int

        if (hasNextInt) {
            int yearOfBirth = scanner.nextInt(); // convert string input to an int
            System.out.println("your birth year is " + yearOfBirth);

            // pressing Enter key -> regarded as input by Scanner - that's why entering name is skipped -> call nextLine()

            scanner.nextLine(); // prompt Scanner to read next line - bypass Enter key input

            System.out.println("Enter your name: ");
            String name = scanner.nextLine(); // reads a line of input - user types input here
            System.out.println("your name is " + name);


            int age = 2020 - yearOfBirth;

            if (age >= 0 && age <= 100) {
                System.out.println("you are " + age + " years old.");
            } else {
                System.out.println("invalid year of birth");
            }
        } else {
            System.out.println("unable to parse year of birth");
        }
        // need to close scanner after using it to free internal memory
        scanner.close();
    }
}
