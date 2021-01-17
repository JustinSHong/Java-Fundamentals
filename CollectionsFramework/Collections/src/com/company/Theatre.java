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
    // compareTo returns:
        // 0 - objects are equal
        // negative num - object is less than the object being compared to
        // positive num - object is greater than object being compared to
  // objects that implement Comparable can be sorted
// Comparator - interface that defines a compare method
    // objects don't have to implement Comparator
    // objects of type Comparator can be created with a compare method that can sort objects
    // YOU CAN DEFINE MULTIPLE COMPARATORS TO SORT IN DIFFERENT WAYS
    // method #1 - create comparator object in an existing class
    // method #2 - create a new class that implements the Comparator interface

// use Collection<T> - to use any type of collection --> most generic type
// collection types are interchangeable only 1 level down [direct children that implement the interfaces ]
// collections become more specialized as you move down the hierarchy

// "ordering being consistent to equals"
    // a method that is consistent with this will only return 0 if elements being compared are actually equal
        // compareTo is consistent
        // compare is not consistent

    // can be passed to sort methods to control sort order
public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    // anonymous inner class implementing Comparator with an implementaiton of compare()
    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0; // not the same seat! Multiple seats can have the same price
                }
            }
        };
    }

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if ((row < 'D') && seatNum >= 4 && seatNum <= 9) {
                    price = 14.00; // premium seats
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00; // seats on edges
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);

        // use binarySearch to find the seat - much faster than iterating through all seats (brute force)
        // Seat.compareTo will be used to compare seats to each other
        // if comparator == null, then the natural ordering imposed by comparable will be used
            // the compareTo method that was overriden will be used
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    public Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.price = price;
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public double getPrice() {
            return price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber +  " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
            }

            return false;
        }
    }
}
