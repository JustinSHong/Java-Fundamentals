package com.company;

// stream = a sequence of computations, set of chained, computations
    //  A SEQUENCE OF ELEMENTS SUPPORTING SEQUENTIAL AND PARALLEL AGGREGATE OPERATIONS

// practically speaking, a stream is a set of object references
// stream() - creates a stream from a collection
    // each reference in a stream corresponds to an object in the collection
    // object ordering is the same as in the collection
    // stream() must be invoked first when using a collection as a source

// stream characteristics
    // stream operations must be non-interfering -> don't mutate source
    // operations must be stateless -> operations can't depend on state outside the operation
        // each operation is independent of the other

// method reference (::)
    // lambda calls an existing method
    // compiler must infer what args are

// map(Function)
    // maps each item in input stream to result returned by function arg
    // resulting stream will have the same number of items as the source stream

// filter(Predicate)
    // filter a stream with elements that fulfill a predicate

// sort()
    // sort stream elements according to their natural order

// distinct()
    // remove duplicate methods using equals()

// peek(Consumer)
    // evaluates consumer for each item in source
    // adds item to a new stream and returns the stream
    // mainly used for debugging

// Stream.concat()
    // combine streams
    // can't be an intermediate operation

// Stream.of()
    // create a stream from scratch
    // elements must be of same type

// chaining streams
    // each stream operations operates on the stream result from the last operation

// terminal operations
    // returns either void or non-stream result
    // marks end of chain

// intermediate operations
    // operations that don't force the end of a stream

// stream pipeline = stream source + intermediate operations + terminal operations

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N46",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71"
        );

        List<String> gNumbers = new ArrayList<>();
        System.out.println("===== USING LAMBDAS ONLY =====");
        // step 1 - collect all g numbers
        someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });
        // step 2 - sort all g numbers
        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
        // step 3 - print all g numbers
        gNumbers.forEach(s -> System.out.println(s));

        System.out.println("===== USING STREAMS =====");
        someBingoNumbers
                .stream()
                .map(String::toUpperCase) // map is a Function
                // .map(s -> s.toUpperCase())
                .filter(s -> s.startsWith("G")) // accepts a Predicate
                // compiler can't know s starts with G
                .sorted()
                // sorts based on natural ordering of stream items
                .forEach(System.out::println);
                // from Stream class, accepts a Consumer and evaluates the Consumer for each item

        System.out.println("===== STREAMS FROM SCRATCH =====");
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
//        System.out.println(concatStream.distinct().count());

        // print out items in a stream without terminating it
        System.out.println("==================================");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count()
        );
    }
}
