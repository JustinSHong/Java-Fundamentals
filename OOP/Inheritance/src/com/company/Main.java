package com.company;

// Compile Time Polymorphism - devs often call overloading with this term.
// compiler decides which method is going to be called based on the method name, return type, and argument list
    // can happen in a single class
    // can happen in subclasses - inherit one version of the method from the parent

// method overriding - define a method in a sub class that already exists in the parent with the same signature (name and args)
    // child class receives derived methods -> inherited methods
    // Runtime Polymorphism/ Dynamic Method Dispatch - method to be called is decided at runtime by JVM
    // only instance methods can be overridden

// static methods - used for operations that don't require data from an instance (this)
    // can't use this
    // methods that don't use instance vars should be declared as static (main)

// instance methods - belong to an instance of a class (new)
    // can directly access instance methods and fields
    // can access static methods and static variables directly

// static variables
    // every instance of that class shares the same static variable
    // changes to that variable mean all instances will see that change
    // not used often
    // Scanner can be declared as a static variable

// classes are the blueprints to build an instance (an object of the custom class) that has a reference to the object in memory which can be passed around

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1,5,5);
        Dog dog = new Dog("Yorkie", 8, 20 , 2, 4, 1, 20, "silky");

        dog.eat(); // inherited method from Animal
        dog.walk();
//        dog.run();
    }
}
