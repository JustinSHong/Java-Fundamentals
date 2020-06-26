package com.company;

import java.sql.SQLOutput;

public class Printer {
    private double tonerLevel;
    private int pagesPrinted; // internal to the printer itself
    private boolean isDuplexPrinter;

    public Printer() {
        this(100d, false);
    }

    public Printer(double tonerLevel, boolean isDuplexPrinter) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.isDuplexPrinter = isDuplexPrinter;
    }

    public double getInkLevel() {
        return this.tonerLevel;
    }

    public int getSheetsPrinted() {
        return this.pagesPrinted;
    }

    public boolean getPrinterMode() {
        return this.isDuplexPrinter;
    }

    public void changePrinterMode() {
        this.isDuplexPrinter = !this.isDuplexPrinter;
    }

    public void refillInk(double tonerLevel) {
        if (tonerLevel <= 0) {
            System.out.println("Oops aren't you forgetting the toner?");
            return;
        } else if (tonerLevel > 100) {
            System.out.println("You can't refill past 100%");
            this.tonerLevel = 100;
            return;
        } else {
            this.tonerLevel = tonerLevel;
        }
    }

    public void printSheet(int pagesPrinted) {
        if (pagesPrinted < 0) {
            System.out.println("Don't forget to print something");
            return;
        }

        if (!this.isDuplexPrinter) {
            this.pagesPrinted += pagesPrinted;
            System.out.println("Printing your page single-sided");
        } else {
            this.pagesPrinted += (pagesPrinted / 2) + (pagesPrinted % 2);
            System.out.println("Printing your page double-sided");
        }
        System.out.println("You have printed " + this.pagesPrinted);
        return;
    }
}
