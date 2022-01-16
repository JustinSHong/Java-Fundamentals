package com.company;

// exception.class vs runtimeException.class
    // exceptions will be subclasses of either of these classes
    // best to catch specific exceptions instead of generic types

// throwing an exception -> pass an exception to the calling code

// strategies for dealing with errors
    // LOOK BEFORE YOU LEAP - common in java (ie. null checks)
    // EASY TO ASK FOR FORGIVENESS THAN PERMISSION - responding with errors

// either strategy handles exceptions so think about use-case

// crashes occur when exceptions are not handled

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	    int x = 90;
//	    int y = 0;
//
//        System.out.println(divideLBLY(x, y));
//        System.out.println(divideEAFP(x, y));
//        System.out.println(divide(x, y)); // will crash

//        int a = getIntLBYL();
        int a = getIntEAFP();
        System.out.println("a is " + a);
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input = s.next();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    // can be better for maintainability - less lines, easy to scan
    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");

        try {
            return s.nextInt();
        } catch(InputMismatchException e) {
            return 0;
        }
    }

    // will crash if input contains non-integers
    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    // look before you leap - check for error condition before proceeding
    private static int divideLBLY(int x, int y) {
        if (y != 0) {
            return x / y;
        }
        return 0;
    }

    // deal with errors when they come up
    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    // will crash if y = 0
    private static int divide(int x, int y) {
        return x / y;
    }
}
