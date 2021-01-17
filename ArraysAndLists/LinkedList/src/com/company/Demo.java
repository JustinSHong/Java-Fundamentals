package com.company;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// ListIterator has no current element -
// cursor position always lies between the element that would be returned by previous() and element that would be returned by next()
// why? - to prevent infinite loops

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);

        visit(placesToVisit);

//        placesToVisit.add("Sydney");
//        placesToVisit.add("Melbourne");
//        placesToVisit.add("Brisbane");
//        placesToVisit.add("Perth");
//        placesToVisit.add("Canberra");
//        placesToVisit.add("Adelaide");
//        placesToVisit.add("Darwin");

//        printList(placesToVisit);
//
//        placesToVisit.add(1, "Alice Springs");
//
//        printList(placesToVisit); // Sydney --> Alice Springs --> Melbourne
//
//        placesToVisit.remove(4);
//
//        printList(placesToVisit); // remove Perth, cleaned up by garbage collector
    }

    // iterator - method of going through all entries in an iterable
    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator(); // like a for loop

        // while linked list element is pointing to another value...
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next()); // i.next() - like i++, changes iterator value and returns the current value
        }
        System.out.println("=========================");
    }

    // normally you want to avoid methods that cause side effects
        // changing the actual entries and returning a value
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator(); // does not point to the first record

        while (stringListIterator.hasNext()) {
            // initially points to the first record
            int comparison = stringListIterator.next().compareTo(newCity); // 0 - values match

            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // new city should appear before this one
                // Brisbane --> Adelaide

                stringListIterator.previous(); // go back to the previous entry - listIterator only can do this
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move on to next city
            }
        }

        // new item must go at end
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    // go to next city
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    // go to previous city
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }

}
