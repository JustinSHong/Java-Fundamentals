package com.company;

public class Vehicle {
    private String name;
    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name) {
        this.name = name;
        this.currentDirection = 0;
        this.currentDirection = 0;
    }

    public String getName() {
        return this.name;
    }

    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Vehicle steer: Steering at " + this.currentDirection + " degrees" );
    }

    public void move(int direction, int velocity) {
        this.currentDirection = direction;
        this.currentVelocity = velocity;
        System.out.println("Vehicle.move(): Moving at " + currentVelocity + " in direction " + currentDirection);
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void stop() {
        this.currentVelocity = 0;
    }
}
