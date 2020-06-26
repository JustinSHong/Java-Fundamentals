package com.company;

// Create a class and demonstate proper encapsulation techniques
// the class will be called Printer
// It will simulate a real Computer Printer
// It should have fields for the toner Level, number of pages printed, and
// also whether its a duplex printer (capable of printing on both sides of the paper).
// Add methods to fill up the toner (up to a maximum of 100%), another method to
// simulate printing a page (which should increase the number of pages printed).
// Decide on the scope, whether to use constructors, and anything else you think is needed.


public class Main {

    public static void main(String[] args) {
//	    Printer thePrinter = new Printer();
//        System.out.println("Current toner level " + thePrinter.getInkLevel());
//        System.out.println("Current sheets printed " + thePrinter.getSheetsPrinted());
//        System.out.println("Current printing mode " + thePrinter.getPrinterMode());

        Printer thePrinter = new Printer(50d, true);
        System.out.println("Current toner level " + thePrinter.getInkLevel());
        System.out.println("Current sheets printed " + thePrinter.getSheetsPrinted());
        System.out.println("Current printing mode " + thePrinter.getPrinterMode());

        thePrinter.refillInk(80d);
        System.out.println("Current toner level " + thePrinter.getInkLevel());
        thePrinter.printSheet(80);
        thePrinter.changePrinterMode();
        System.out.println("Current printing mode " + thePrinter.getPrinterMode());
        thePrinter.printSheet(5);
        thePrinter.changePrinterMode();
        thePrinter.printSheet(5);

    }
}
