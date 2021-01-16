package com.company;

// real world objects have 2 characteristics - state and behavior
// ie computer state - os, hard drive size, monitor size
// ie booting up, drawing, printing something

// software objects store state in fields (variables)
// expose behavior as methods

// class = template or blueprint for creating objects

// benefits of classes?
// user defined data type that allows you to create abstractions of real-world objects

// new - keyword to create an object from a specified class

public class Main {

    public static void main(String[] args) {
	    Car porsche = new Car(); // Car object called porsche - initialized with new
        Car holden = new Car();

        // Java adds extra functionality to objects - user defined classes inherit from Java base Class
        porsche.setModel("Carrera");
        porsche.setModel("911");
        System.out.println("model is " + porsche.getModel());
    }
}
