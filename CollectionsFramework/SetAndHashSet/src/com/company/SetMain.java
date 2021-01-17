package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// set bulk operations - allow you to find symmetric differences or similarities
    // destructive operations - the modify the set that is called upo n
    // set1.addAll(set2) - returns the union of 2 sets
    // set1.retainsAll(set2) - returns the intersection of 2 sets
    // set1.removeAll(set2) - removes all elements in one set from another
    // set1.containsAll(set2) - is set1 a superset of set2?
        // does set1 contain all the elements of set2?
        // THE INTERSECTION OF 2 SETS MUST BE A SUBSET OF THE SETS INVOLVED

// convert an array to a List with Array.asList()

// differences in sets: asymmetric vs symmetric
    // asymmetric - remove elements that are shared between sets from the first set / removing els in the intersection
        // set1.removeAll(set2) is not the same as set2.removeAll(set1)
            // remove els that are in both sets from set 1
            // remove els that are in both sets from set 2
        // set1 and set2 can be different so removing els from each will result in different sets
        // RESULT IS THE ELEMENTS THAT ARE UNIQUE TO THE SET YOU ARE REMOVING SHARED ELS FROM
    // symmetric - elements that appear in one set or the other but not both
        // REMOVE INTERSECTION FROM THE UNION OF 2 SETS
            // ELEMENTS THAT ARE UNIQUE TO BOTH SETS ARE RETURNED

// ALL CLASSES THAT IMPLEMENT COLLECTIONS SHOULD
    // NO ARGS CONSTRUCTOR
    // CONSTRUCTOR THAT TAKES A COLLECTION AS AN ARG

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        // populate sets
        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares");
        System.out.println("There are " + cubes.size() + " cubes");

        // find union of squares and cubes sets - elements that are unique
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements");

        // find intersection of squares and cubes sets - shared elements
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements");

        System.out.println("====================");
        for (int num : intersection) {
            System.out.println("common value in both sets: " + num);
            System.out.println(num + " is the square of " + Math.sqrt(num) + " and the cube of " + Math.cbrt(num));
        }

        // total number of cubes and sets = union + intersection
        System.out.println((squares.size() + cubes.size()) + " = " + union.size() + " + " + intersection.size());

        System.out.println("====================");
        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for (String word : words) {
            System.out.println(word);
        }

        // asymmetric diff
        System.out.println("====================");
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};

        nature.addAll(Arrays.asList(natureWords));
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("asymmetric difference of nature - divine");
        Set<String> natureMinusDivine = new HashSet<>(nature);
        natureMinusDivine.removeAll(divine);
        printSet(natureMinusDivine);

        System.out.println("asymmetric difference of divine  - nature");
        Set<String> divineMinusNature = new HashSet<>(divine);
        divineMinusNature.removeAll(nature);
        printSet(divineMinusNature);


        // symmetric diff
        System.out.println("====================");
        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine); // find union
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine); // find intersection

        System.out.println("symmetric diff is union - intersection");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        System.out.println("intersection of nature and divine sets was removed");
        printSet(intersectionTest);

        // containsAll - check if a set is a super-set of another
        System.out.println("====================");
        if (nature.containsAll(divine)) {
            System.out.println("divine is a sub-set of nature");
        }

        if (nature.containsAll(intersectionTest)) {
            System.out.println("intersection is a sub-set of nature");
        }

        if (divine.containsAll(intersectionTest)) {
            System.out.println("intersection is a sub-set of divine");
        }
    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
