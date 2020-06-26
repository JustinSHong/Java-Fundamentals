package com.company;

// extends - inherit from another class
// super - call super class's constructor
    // initialize parent class
    // add more features that are unique to the sub-class

// override method - method that replaces an inherited method

import org.w3c.dom.ls.LSOutput;

public class Dog extends Animal {
    // fields unique to instances of Dog and not Animal
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

//    public Dog(String name, int brain, int body, int size, int weight) {
//        // calls parent class's constructor
//        super(name, brain, body, size, weight);
//    }

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        // calls parent class's constructor
        super(name, 1, 1, size, weight);
        // initialize Dog specific fields
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog.chew() called");
    }

    // override
    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        super.move(5); // only calls the inherited move
    }

    public void run() {
        System.out.println("Dog.run() called");
        move(10); // will call either local move or inherited
    }

    public void moveLegs(int speed) {
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }
}
