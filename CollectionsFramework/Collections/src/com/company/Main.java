package com.company;

// Collections class - top level of the collections framework
    // exposes static methods that operate on collections or return objects
    // interfaces allow this class to be extended ---> define methods for fundamental operations for collection types

// goals
    // good interoperability for existing and new collections
        // Arrays ---> framework allows conversion to and from collections

// interfaces - abstract types representing collections (List)
// aggregate operations
// iterators
// concrete implementations
    // collections
    // algorithms

// Collections methods
    // binarySearch
    // sort - merge sort
    // shuffle - randomize
    // reverse
    // min - return smallest object according to sort order ---> compareTo
    // max - return largest object
    // swap - swap 2 elements in a collection
    // copy(destination, sourceList)
        // destination - generic type that's a superset of the source (collection, list, iterable)
        // source - must be a list
        // must have the same number of elements ---> not just the size

import java.sql.SQLOutput;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats); // shallow copy
//        printList(seatCopy);
//        theatre.getSeats();

        if (theatre.reserveSeat("H11")) {
            System.out.println("please pay");
        } else {
            System.out.println("seat is taken");
        }

        if (theatre.reserveSeat("B13")) {
            System.out.println("please pay for B13");
        } else {
            System.out.println("seat is taken");
        }

//        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
//        Collections.reverse(reverseSeats);
//        printList(reverseSeats);

//        Collections.reverse(seatCopy); // reverse order of objects
//        System.out.println("Printing seatcopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seat");
//        printList(theatre.seats);
//
//        Collections.shuffle(seatCopy); // shuffles the order of objects
//        System.out.println("Printing seatcopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seat");
//        printList(theatre.seats);
//
//        // find min amd max object according to their natural order (comparable)
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println("Min seat number is " + minSeat.getSeatNumber());
//        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
//
//        sortList(seatCopy);
//        System.out.println("Printing sorted seat copy");
//        printList(seatCopy);
//
//        // copy a list in to another
//        // destination must be of sufficient size
//        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size()); // still empty but has potential to hold many items
//        Collections.copy(newList, theatre.seats);


        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("==========");
    }

//    public static void sortList(List<? extends Theatre.Seat> list) {
//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(i).compareTo(list.get(j)) > 0) {
//                    Collections.swap(list, i, j);
//                }
//            }
//        }
//    }
}
