package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// methods that return "ordering that is consistent with equals"
    // returns 0 if the elements being compared are equal
// inconsistencies can cause problems when using other Collections (Sorted Sets and Sorted Maps)
    // more than one object can be returned

// Comparable - interface that defines a compareTo method that allows you to compare objects
// Comparator - interface that defines a compare method
    // objects don't have to implement Comparator
    // objects of type Comparator can be created with a compare method that can sort objects
    // YOU CAN DEFINE MULTIPLE COMPARATORS TO SORT IN DIFFERENT WAYS

// use Collection<T> - to use any type of collection --> most generic type
// collection types are interchangeable only 1 level down [direct children that implement the the interfaces ]
// collections become more specialized as you move down the hierarchy

    // can be passed to sort methods to control sort order
public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    // anonymous inner class implementing Comparator and providing an implementation of compare
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if (seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                // not consistent with equals - SEATS ARE NOT TOTALLY EQUAL
                // multiple seats may have the same price
                return 0;
            }
        }
    };

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {

                double price = 12.00; // default price for a seat

                if (row < 'D' && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00; // middle seats
                } else if (row > 'F' || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00; // back and edge seats
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);

        // fastest way to search a sorted list
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is not seat " + seatNumber);
            return false;
        }

//        for (Seat seat : seats) {
//            System.out.print(".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();
    }

    public String getTheatreName() {
        return theatreName;
    }

    public Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        // return -1 - object being compared is less than
        // return 0 - objects compared are equal
        // return 1 - object being compared is greater
        // seat is the object being compared
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareTo(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}
