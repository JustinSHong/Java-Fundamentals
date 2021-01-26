package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// call stack
    // list of method calls that occurred up to a point
    // each thread of execution has its own call stack
    // thread is shown as first line of stack trace

// Throwable constructor() fills in the stack-trace for an exception

// when an exception is thrown:
    // JRE sees what handles it -> go up the call stack
    // exception propagates up the call stack until a method handles an exception
    // propagation happens until main() is reached
        // stack trace is printed
        // JRE terminates

// only catch() an exception if your code can do something sensible with it
    // do not cause additional exceptions in catch() blocks
    // keep catch() blocks simple
    // use multiple catch() blocks to handle different exceptions clearly
        // when an exception occurs, each catch() is checked in order to see if a catch() handles the exception

// throwing exceptions -> keeps stack trace simple

// checked vs unchecked
    // checked exceptions = subclasses of Exception
        // exceptions that are outside the control of the program (ie. file does not exist)
        // clients can easily recover
    // unchecked exceptions = subclasses of RuntimeException
        // exceptions that reflect an error in the program logic (ie. divide by 0)
        // client can't do anything about it (null pointers)

public class Example {
    public static void main(String[] args) {
        try {
            int result = divideWithMultipleCatchBlocks();
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, shutting down");
        }
    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
        } catch (NoSuchElementException e) {
            throw new ArithmeticException("no suitable input");
        }
        System.out.println("x is " + "x" + ", y is " + y);

        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("attempt to divide by zero");
        }
    }

    private static int divideWithMultipleCatchBlocks() {
        int x, y;
        try {
            x = getInt();
            y = getInt();

            System.out.println("x is " + "x" + ", y is " + y);

            return x / y;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("no suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("attempt to divide by zero");
        }
    }


    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while (true) {
            try {
                return s.nextInt();
            } catch(InputMismatchException e) {
                // go round again. read past eol in the input
                s.nextLine();
                System.out.println("Please enter a number with digits 0-9");
            }
        }
    }


}
