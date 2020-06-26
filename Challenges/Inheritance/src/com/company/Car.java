package com.company;

public class Car extends Vehicle {
    private String name;
    private int wheels;
    private String steering;
    private int gears;
    private String engineType; // combustion or electric or hydrogen fuel cell
    private boolean isManual;
    private int currentGear;

    public Car(String name, int wheels, String steering, int gears, String engineType, boolean isManual) {
        super(name);
        this.wheels = wheels;
        this.steering = steering;
        this.gears = gears;
        this.engineType = engineType;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.changeCurrentGear(): Change current to " + this.currentGear);
    }

    public void changeVelocity(int speed, int direction) {
        move(direction, speed);
        System.out.println("Car.changeVelocity(): Velocity " + speed + " direction " + direction);
    }


}
