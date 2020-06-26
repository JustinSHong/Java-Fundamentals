package com.company;

public class Main {
    // write a method, printDayOfTheWeek, that has one param of type int called day
    // use a switch statement to print the corresponding day as a String (Sunday, Monday, etc...)

    public static void main(String[] args) {
        printDayOfTheWeek(99);
        printDayOfTheWeek(0);
        printDayOfTheWeek(1);
        printDayOfTheWeek(2);
        printDayOfTheWeek(3);
        printDayOfTheWeek(4);
    }

    public static void printDayOfTheWeek(int day) {
        switch(day) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("This day does not exist");
                break;
        }
    }
}
