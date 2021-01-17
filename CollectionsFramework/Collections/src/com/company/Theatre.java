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

}
