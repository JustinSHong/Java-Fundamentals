package com.company;

// static variable - associated with the class rather than a particular instance
    // only 1 copy in memory
    // all instances share this copy
    // use static methods to access

public class Main {

    public static int multiplier = 7;

    // main has to be static - need an entry point to be executed when the program runs
        // until program runs there are no instances to run
        // intellij invoke Java executable and passes the name of the class that contains the public static void main signature
            // ie. command line - java com.company._static.Main
        // static allows main() to be called without creating an object of the class where main is defined

    // normal class members don't exist until an instance is created
        // static methods can't access non-static members in its own class because they don't exist when static methods are called

    public static void main(String[] args) {
//	    StaticTest firstInstance = new StaticTest("1st instance");
//        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());
//
//        StaticTest secondInstance = new StaticTest("2nd instance");
//        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        int answer = multiply(6);
        System.out.println("The answer is " + answer);
    }

    public static int multiply(int number) {
        return number * multiplier;
    }
}
