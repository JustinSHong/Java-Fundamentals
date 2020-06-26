package com.company;

// inheritance - follows "is a" relationship ( a car is a vehicle)
// composition - follows a "has a" relationship (a computer has many parts)
    // many parts make up a whole
	// main object is managing and looking after other objects

public class Main {

    public static void main(String[] args) {
	    Dimensions dimensions = new Dimensions(20, 20, 5);
	    Case theCase = new Case("220B", "Dell", "240", dimensions);

	    Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));

	    Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

	    PC thePC = new PC(theCase, theMonitor, theMotherboard);
	    // accessing members of the base-classes

//        thePC.getMonitor().drawPixelAt(1500, 1200, "red");
//        thePC.getMotherboard().loadProgram("Windows 1.0");
//        thePC.getTheCase().pressPowerButton();

        thePC.powerUp();
    }
}
