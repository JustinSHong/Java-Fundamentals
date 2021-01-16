package com.company;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.HashSet;
import java.util.Set;

// Sets
// no ordering "chaotic"
// can not have dupes
// accepts a single type
// common methods: add, remove, clear, size, isEmpty, contains
// NO WAY TO GET AN ITEM IN A SET -> MUST ITERATE
// HashSet ---> best performing interface ----> uses hashes to store the items ----> uses HashMap ---> values are dummy objects

// set operations are fast
    // union
    // intersection

// union of 2 or more sets - results in a set containing all elements of the sets ---> each elements will be unique

// only references to objects are being stored in the sets

// WARNING: should override equals and hashCode methods
    // base object equals ----> only defines referential equality (too simple)
    // objects must be strictly equal
    // objects that are equal will also have the same hashcode
        // each hashcode goes to the same "bucket" in a hashSet or hashMap
    // when new objects are added
        // new objects are compared to existing ones in a bucket

// IF 2 OBJECTS COMPARE EQUAL THEN THEIR HASH CODES MUST BE EQUAL

// BE CAREFUL WHEN COMPARING SUBCLASSES
    // childClass.equals(parentClass) ----> true because child extends parent
    // parentClass.equals(childClass) ----> false because parent doesn't extend child
    // THIS VIOLATES THE SYMMETRIC CONSTRAINT OF THE EQUALS METHOD
// mark equals() as final to avoid this method from being overridden in sub-classes

// NEED TO THINK ABOUT OVERRIDING EQUALS() AND HASHCODE()
    // should you allow classes to be sub-classed? if so, how do you treat comparisons between the subclass and the base?
    // subclass would only add methods that don't alter way equality works
        // allow subclassing and mark methods as final
    // subclasses are different objects
        // comparison between sub class and base class should return false,

public abstract class HeavenlyBody {
    private final Key key;
    private final Set<HeavenlyBody> satellites;
    private final double orbitalPeriod;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<HeavenlyBody>(satellites);
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    // we want to override not overload the equals
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true; // object equal to itself
        }

        // name and body type must match
        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;

            return this.key.equals(theObject.getKey());
        }

        // object must be a HeavenlyBody
        return false;
    }

    // REQUIREMENTS
        // objects that compare equal must have the same hash code
        // same object must always generate the same hashcode

    // return 0 strategy ---> every object in 1 bucket ---> performance degrades ---> must compare to all objects

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    // generate a key to look up values in the map object
    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    // REPRESENTS THE KEY IN OUR SOLAR SYSTEM MAP
    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return this.bodyType == key.getBodyType();
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
