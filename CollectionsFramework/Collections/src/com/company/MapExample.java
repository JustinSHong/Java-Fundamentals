package com.company;

import java.util.HashMap;
import java.util.Map;

// MAP
    // not part of the Collections framework
    // are generic - <type of key, type of value>
    // can not contain duplicate keys
    // keys can only have one value
    // order is not guaranteed
    // key and values can be any values
    // keys are mutable

// methods
    // put(key, value) - add an entry to the dictionary
    // get(key) - retrieve a key's corresponding value
    // keySet() - return a set of the given map's keys
    // remove(key) - remove a key value pair
    // remove(key, value) - remove a key value pair only if the given value matches the existing value in the map
        // returns true if values match and delete is successful
    // replace(key, value) - replace a key's corresponding value only if a value already exists
    // replace(key, oldValue, newValue)
        // checking that you are updating the exact entry

public class MapExample {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        // INSERT KEY VALUE PAIRS
        // put - can be used to tell if a value is being added for the first time (returns null)
        languages.put("Java", "compiled high level, oop, platform independent language");
        languages.put("Python", "interpreted, oop, with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("Basic", "Beginners all purposes symbolic instruction code");
        languages.put("Lisp", "Therein lies madness");
        // OBTAIN VALUE
        System.out.println(languages.get("Java"));
        System.out.println(languages.get("Python"));
        System.out.println(languages.get("Algol"));
        System.out.println(languages.get("Basic"));
        System.out.println(languages.get("Lisp"));
        // can override values since keys are unique
//        languages.put("Java", "override");
//        System.out.println(languages.get("Java"));

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }

        // DELETING ENTRIES
//        languages.remove("Lisp"); // delete outright

        // find key/value pair match before removing
        if (languages.remove("Algol", "an algorithmic language")) {
            System.out.println("Algol was removed from languages map");
        } else {
            System.out.println("Algol was not removed, key/value pair was not found");
        }

        // REPLACING/UPDATING AN ENTRY
        // replace a value for a key if mapped to a certain value already
        if (languages.replace("Lisp", "Therein lies madness", "a functional programming language")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }

        System.out.println("===================================");
        // keySet returns a set of keys
        for (String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

        System.out.println("===================================");
        // values returns set of values
        for (String value: languages.values()) {
            System.out.println(value);
        }
    }
}
