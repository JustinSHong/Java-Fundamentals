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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Olympian", 8, 12);

	    if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

	    if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

//        // shallow copy - objects are still shared
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.getSeats());
        printList(seatCopy);

        System.out.println("REVERSED SEAT LIST");
        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);
//        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seat");
//        printList(theatre.seats);
//
        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        System.out.println("PRINT SEATS SORTED BY PRICE");
        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));

        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);

        System.out.println("first seat: " + priceSeats.get(0).getPrice());
        System.out.println("second seat: " + priceSeats.get(1).getPrice());
        System.out.println((priceSeats.get(0).compareTo(priceSeats.get(1))));
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat: list) {
            System.out.println(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("========================");
    }
}
