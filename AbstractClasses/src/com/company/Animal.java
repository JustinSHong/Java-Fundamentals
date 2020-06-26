package com.company;

// abstract classes define behavior that is REQUIRED
    // subclasses that inherit this class must have these implemented
    // not the same as regular inheritance

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
    public abstract void breath();

    public String getName() {
        return name;
    }
}
