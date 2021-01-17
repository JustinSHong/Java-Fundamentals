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
    }
}
