 package com.company;

// Abstractions - define the required functionality without implementing it (what needs to be done not the how)
// abstract classes define methods but not their implementations
    // classes that inherit from abstract ones can have their own implementations
// can not be directly instantiated with 'new'

// INTERFACES VS ABSTRACT CLASSES
    // consider relationship (is a, has a)

        // abstract classes --> is a a / has a relationships

        // interfaces for a "can" relationship (bats can fly, dragonflies can fly)

        // interfaces give you FLEXIBILITY to create other classes --> CanFly for birds, bats, and dragonflies
            // don't have to pigeonhole yourself into having objects fit in to a base class
            // VARIABLES CAN ONLY BE public static final ---> constants that never change
            // no constructors
            // members are automatically public
            // all methods are abstract
    // abstract classes
        // define members that are common to all children
        // members can be inherited
        // members can be of any visibility
        // can have defined methods with an implementation

// USE ABSTRACT CLASSES
    // share code among closely related classes
    // expect classes the extend the abstract class to have many common methods, fields, or require different access modifiers
    // declare non-static or non-final fields --> getters and setters
    // base class provides default implementation of certain methods but others should be overridden

// INTERFACES
    // declaration of methods
    // define operations an object can form
    // form a contract between a class and the outside world --> enforced at build time
    // can extend other interfaces
    // MORE FLEXIBLE --> introduce points of variation --> can define different implementations for that interface

// USE INTERFACES
    // unrelated classes will implement your interface
    // specify behavior of a data type
    // separate different behavior

    // COLLECTIONS API
public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breath();
        dog.eat();

        Parrot parrot = new Parrot("Australian Ring-neck");
        parrot.breath(); // from Animal abstract class
        parrot.eat(); // from Animal abstract class
        parrot.fly(); // from Bird abstract class

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
        penguin.breath();
        penguin.eat();
    }

}
