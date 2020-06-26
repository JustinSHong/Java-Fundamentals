package com.company;

// interfaces guarantee that a class has certain members -> can make methods more generic when parameters implement interfaces
    // guarantee methods are overwritten where needed so code doesn't fall back to super code

// what happens when you want to call a method that is not defined in the interface?
    // calling object must be casted to the write type

// must think about declaring an instance with the class as the type or an interface - depends on what you want to do with the interface
    // declare a variable that can hold objects of different types --> use a common interface
    // use methods in a class not part of the interface --> declare as class type

// best practice: keep your code as generic as possible --> use interfaces whenever you can

// PARAMETERS TO METHODS WITH AN INTERFACE TYPE ARE AUTO CAST FROM THE CLASS TYPE

import com.example.game.ISaveable;
import com.example.game.Monster;
import com.example.game.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Player justin = new Player("Justin", 10, 15);
        System.out.println(justin.toString());
        saveObject(justin);

        justin.setHitPoints(99);
        System.out.println(justin);
        justin.setWeapon("Stormbringer");
        saveObject(justin);
//        loadObject(justin);
        System.out.println(justin);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf);
        // interface ISaveable doesn't define getStrength
//        System.out.println(werewolf.getStrength());

        // casting
        System.out.println( "Strength = " + ((Monster) werewolf).getStrength());

        saveObject(werewolf);
    }

    // can save any object that implements this interface -> can be very generic
    // saveObject() can be called with any object using the ISaveable interface
    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
