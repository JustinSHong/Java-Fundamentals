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
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.description = description;
//        this.exits = exits; // exits can still be modified from the outside via reference

        // prevent NPE
        if (exits != null) {
            this.exits = new HashMap<String, Integer>(exits); // exits can no longer be accessed from the outside
        } else {
            this.exits = new HashMap<String, Integer>();
        }

        this.exits.put("Q", 0); // quit the game
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits); // return a copy of exits
    }
}
