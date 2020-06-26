package com.company;

public class Main {

    public static void main(String[] args) {
	    double first = 20.00d;
	    double second = 80.00d;

	    double result = (first + second) * 100.00d;
        System.out.println("result is " + result);
	    double remainder = result % 40.00d;
        System.out.println("remainder is " + remainder);

	    boolean remainderIsZero = result == 0 ? true : false;
        System.out.println("remainderIsZero " + remainderIsZero);

        if (remainderIsZero) {
            System.out.println("Got some remainder");
        }
    }
}
