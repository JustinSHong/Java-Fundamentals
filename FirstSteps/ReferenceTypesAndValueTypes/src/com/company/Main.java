 package com.company;

import java.util.Arrays;

// reference type - array, String
    // one object in memory with multiple references/addresses to it

// value type - primitive values

public class Main {

    public static void main(String[] args) {
	    int myIntValue = 10; // memory location 1
	    int anotherIntValue = myIntValue; // memory location 2, value is just copied over

        System.out.println("myIntValue " + myIntValue);
        System.out.println("anotherIntValue " + anotherIntValue);

        anotherIntValue++;

        System.out.println("myIntValue " + myIntValue);
        System.out.println("anotherIntValue " + anotherIntValue);

        int[] integers = new int[5]; // reference types are used by reference - hold an address to the object and not the object itself
        int[] anotherArray = integers; // another reference pointing to the same array

        System.out.println("integers " + Arrays.toString(integers)); // static method from Array class that prints the array as a string
        System.out.println("anotherArray " + Arrays.toString(anotherArray));

        anotherArray[0] = 100; // updates for all references
        System.out.println("after change integers " + Arrays.toString(integers));
        System.out.println("after change anotherArray " + Arrays.toString(anotherArray));

        anotherArray = new int[] {4,5,6,7};

        modifyArray(integers); // another reference as a param
        System.out.println("after modify integers " + Arrays.toString(integers));
        System.out.println("after modify anotherArray " + Arrays.toString(anotherArray));
    }

    // methods can not modify a reference
    // methods can only dereference a reference
    private static void modifyArray(int[] array) {
        array[0] = 2;
        array = new int[] {1, 2, 3, 4, 5}; // reference points to a new array
    }
}
