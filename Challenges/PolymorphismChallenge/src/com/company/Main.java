package com.company;

// We are going to go back to the car analogy.
// Create a base class called Car
// It should have a few fields that would be appropriate for a generic car class.
// engine, cylinders, wheels, etc.
// Constructor should initialize cylinders (number of) and name, and set wheels to 4
// and engine to true. Cylinders and names would be passed parameters.
//
// Create appropriate getters
// Create some methods like startEngine, accelerate, and brake
//
// show a message for each in the base class
// Now create 3 sub classes for your favorite vehicles.
// Override the appropriate methods to demonstrate polymorphism in use.
// put all classes in the one java file (this one).

public class Main {

    public static void main(String[] args) {
	    Ferrari theFerrari = new Ferrari();
	    Porsche thePorsche = new Porsche();
	    Bugatti theBugatti = new Bugatti();

	    theFerrari.startEngine();
	    thePorsche.startEngine();
	    theBugatti.startEngine();

	    theFerrari.brake();
	    thePorsche.brake();
	    theBugatti.brake();
    }
}

class Car {
    private int engine;
    private int cylinders;
    private int wheels;
    private int doors;
    private String name;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders < 0 ? 0 : cylinders;
        this.engine = 1;
        this.name = name;
        this.doors = 4;
        this.wheels = 4;
    }

    public int getEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public void startEngine() {
        System.out.println("Car engine started");
    }

    public void accelerate() {
        System.out.println("CAR IS ACCELERATING");
    }

    public void brake() {
        System.out.println("CAR IS BRAKING");
    }
}

class Ferrari extends Car {
    public Ferrari() {
        super(8, "Ferrari");
    }

    @Override
    public void startEngine() {
        System.out.println(getClass().getSimpleName() + " STARTS ENGINE");
    }
}

class Porsche extends Car {
    public Porsche() {
        super(6, "Porsche");
    }

    @Override
    public void startEngine() {
        System.out.println(getClass().getSimpleName() + " STARTS ENGINE");
    }
}

class Bugatti extends Car {
    public Bugatti() {
        super(12, "Bugatti");
    }

    @Override
    public void startEngine() {
        System.out.println(getClass().getSimpleName() + " STARTS ENGINE");
    }
}

