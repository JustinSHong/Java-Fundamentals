package com.company;

// Q: how do we use primitive data types as object?
// A: use wrapper classes for each of the primitive types

// autoboxing -

// unboxing -

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    String[] strArray = new String[10];
	    int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("item");

        // can't do this - type argument cannot be of primitive type
        // need a class reference to save to ArrayList
//        ArrayList<int> intArrayList = new ArrayList<int>();

        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54)); // messy and verbose - use autoboxing

        Integer integer = new Integer(54); // Integer is a class
        Double doubleVal = new Double(12.25);

        ArrayList<Integer> intArrayList = new ArrayList<Integer>(); // valid

        for (int i = 0; i < 10; i++) {
            intArrayList.add(Integer.valueOf(i)); // wrap a primitive type with the right wrapper - autoboxing
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " --> " + intArrayList.get(i).intValue()); // convert class to an int value primitive - unboxing
        }

        // AUTOBOXING SHORTCUT
        Integer myIntValue = 56; // at compile time, this is executed: Integer.valueOf(56)

        // UNBOXING SHORTCUT
        int myInt = myIntValue; // at compile time, this is executed: myIntValue.intValue()

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
//            myDoubleValues.add(Double.valueOf(dbl));
            myDoubleValues.add(dbl);
        }

        for (int i = 0; i < myDoubleValues.size(); i++) {
//            double value = myDoubleValues.get(i).doubleValue();
            double value = myDoubleValues.get(i);
            System.out.println(i + " --> " + value);
        }
    }
}


// example wrapper class
class IntClass {
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}
