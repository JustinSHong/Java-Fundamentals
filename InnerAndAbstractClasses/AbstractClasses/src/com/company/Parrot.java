package com.company;

public class Parrot extends Bird {
    // also inherits eat() and breath() from parent Bird class which inherits from Animal
    public Parrot(String name) {
        super(name);
    }

//    @Override
//    public void fly() {
//        System.out.println("Flitting from branch to branch");
//    }
}
