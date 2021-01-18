package com.company;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

import java.util.HashSet;
import java.util.Objects;
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
    // addAll method

// only references to objects are being stored in the sets

// when using your own object as keys in a map or adding elements to a set
// WARNING: should override equals and hashCode methods
    // base object equals ----> only defines referential equality (too simple)
    // objects must be strictly equal
    // objects that are equal will also have the same hashcode
        // each hashcode goes to the same "bucket" in a hashSet or hashMap
    // when new objects are added
        // new objects are compared to existing ones in a bucket

// ===================================================================

// IF 2 OBJECTS COMPARE EQUAL THEN THEIR HASH CODES MUST BE EQUAL
    // objects with the same hash code go in to the same bucket
    // before being added, objects in a bucket are compared to each other using equals()

// IF 2 OBJECTS COMPARE EQUAL AND THEIR HASH CODES ARE NOT EQUAL
    // dupes occur
    // objects will be added to different buckets

// THE SAME OBJECT SHOULD GENERATE THE SAME HASH CODE


// ===================================================================

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
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    // using a value not in this enum will throw an error at compile time
    // automatically static
    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    // users can use this to generate a key in order to look up different heavenly bodies
    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
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

    public boolean addSatellite(HeavenlyBody moon) {
        return satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // obj can't be null -> NPE
        // check that obj is not a sub-class
//        if (obj == null || (obj.getClass() != this.getClass())) {
//            return false;
//        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
//            if (this.name.equals(((HeavenlyBody) obj).getName())) {
//                return this.bodyType == theObject.getBodyType();
//            }
        }

        // criteria for Heavenly Body equality
//        String objName = ((HeavenlyBody) obj).getName();
//        return this.name.equals(objName);

        return false;
    }

    @Override
    public final int hashCode() {
//        return this.name.hashCode() + this.bodyType.hashCode() + 57;
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

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
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}