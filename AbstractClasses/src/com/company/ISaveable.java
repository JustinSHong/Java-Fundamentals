package com.company;

import java.util.ArrayList;
import java.util.List;

// interface just describes what needs to be in a class - up to the class how to use members
// interfaces by definition are abstract - you need to instantiate a class that implements an interface

public interface ISaveable {
//    ArrayList<String> write();
//    void read(ArrayList<String> savedValues);


    // use List public interface to provide an abstraction over any lists in Java
    List<String> write();
    void read(List<String> savedValues);
}
