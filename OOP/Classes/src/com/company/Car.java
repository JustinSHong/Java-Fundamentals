package com.company;

// packages are a series of related folders and files
// this class is Car.java file in com/company package
// when classes are made they are added to a package

// keyword
// public - access modifier giving unrestricted access to others
// private - no other class can access
// protected - only classes in package can access it

// class fields (member variables) are accessible and visible from anywhere within the class
    // public, private, protected
    // private is default - obey encapsulation

// null - default state for a class and a string (a special class)

// fields are encapsulated to hide internal representation of an object is hidden from the outside world

// methods are attached to all objects of a class

public class Car {
    // state of Car objects
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    // use methods to update fields to maintain encapsulation - set and getters
    // why use getters and setters?
    // can sanitize/validate data in setters
    // make sure data in objects is valid and correct

    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("commodore")) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }
    }

    public String getModel() {
        return this.model;
    }

}
