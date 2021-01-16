package com.company;

// you can have as many static initialization blocks as you want
// called in the order they are declared in the class
// called before instance constructors

public class SIBTest {
    public static final String owner;

    static {
        owner = "time";
        System.out.println("SIBTest static initialization block called");
    }

    public SIBTest() {
        System.out.println("SIB constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
