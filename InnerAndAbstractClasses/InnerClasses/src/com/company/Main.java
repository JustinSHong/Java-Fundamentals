package com.company;

import java.util.Scanner;

// Nested Classes - 4 types
    // static - associate a class with its outer class (packaged in outer class)
        // couple a class with its parent
        // need to create an instance of the outer class before accessing members
        // use when it doesn't make sense to access this without the parent (parts of a whole)
            // ie. engine - gear block and gears
        // usually private classes - parent is the public interface
    // non-static/inner
    // local - class defined in a scope block (method)
        // not used often
        // ie. comparator to sort
        // useful for attaching same object to multiple objects --> add listeners to multiple buttons
    // anonymous - no class name
        // must be declared and instantiated at the same time since they have no name
        // use when a local class is needed only once
        // ie. touching event handlers to ui elements which might need different handlers

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        // static
        GearBox mcLaren = new GearBox(6);
//        GearBox.Gear first = mcLaren.new Gear(1, 12.3); // correct way to access inner class
//        GearBox.Gear second = new GearBox.Gear(2,2,2.22); Not correct
//        GearBox.Gear third = new mcLaren.Gear(3, 3.33);
//        System.out.println(first.driveSpeed(1000));


//        mcLaren.addGear(1, 5.3);
//        mcLaren.addGear(1, 10.6);
//        mcLaren.addGear(1, 15.9);
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(1);
//        mcLaren.operateClutch(true);
//        System.out.println(mcLaren.wheelSpeed(1000));
//        mcLaren.changeGear(2);
//        System.out.println(mcLaren.wheelSpeed(3000));
//        mcLaren.changeGear(3);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(6000));


        // LOCAL CLASS
//        class ClickListener implements Button.OnClickListener{
//            public ClickListener() {
//                System.out.println("I've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//        btnPrint.setOnClickListener(new ClickListener());


        // ANONYMOUS CLASS
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
