package com.company;

import java.util.HashMap;
import java.util.Map;

// IMMUTABLE CLASSES
    // want instances of your classes to be immutable
    // increase encapsulation and reduce errors

// protect objects from external modification -> don't share references

// use private final to describe class members
// prevent outside code from modifying inner objects -> clone them in to new objects
// don't provide setter methods
// don't allow subclasses to override methods (declare class as final)

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;

        if (exits != null) {
            this.exits = new HashMap<>(exits);
        } else {
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    // returns a new hash map with the existing key-value pairs from this.exits
    // nothing outside of this class can change the exits
    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
