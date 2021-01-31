package com.company;

// What is a stream?
    // A SEQUENCE OF ELEMENTS SUPPORTING SEQUENTIAL AND PARALLEL AGGREGATE OPERATIONS
    // practically speaking, a stream is a set of object references

// stream() - creates a stream from a collection
    // each reference in a stream corresponds to an object in the collection
    // object ordering is the same as in the collection
    // stream() must be invoked first when using a collection as a source

// stream characteristics
    // stream operations must be non-interfering -> don't mutate source
    // operations must be stateless -> operations can't depend on state outside the operation
        // each operation is independent of the other
        // each operation can not access state in another operation
    // operations are lazily-operations
        // INTERMEDIATE OPERATIONS ARE NOT PERFORMED UNTIL THERE'S A TERMINAL OPERATION
    // type specific stream interfaces exist
        // have helper methods that are useful to the type being used

// Q: Why are streams lazily evaluated?
    // it would be a waste of resources if nothing comes out of the stream pipe

// method reference (::)
    // lambda calls an existing method and maps it to the corresponding Functional interface
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

// flatMap(Function)
    // apply a mapping function to each element in the source stream
    // accepts a function that returns a stream
    // useful for creating streams with where sources are nested in multiple objects

// collect(Collector)
    // collects stream elements in to another data structure (ie. collect stream items in to a set)
    // terminal operation
    // useful for selectively reducing and sorting a large list
    // maps collector to the args required by collect(supplier, biconsumeracumulator, biconsumercombiner)

// collect(Supplier, Accumulator, Combiner)
    // used to collect items in to more specific data-structures not defined in Collector.class
    // can be used by many APIs to create many groupings

// reduce(Bifunction)
    // executes given reducer function to each stream element returning an optional result

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
    // streams can not be reused once a terminal op has occurred

// intermediate operations
    // operations that don't force the end of a stream

// stream pipeline = stream source + intermediate operations + terminal operations

//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
                .map(String::toUpperCase)
                // map is a Function, refer to the toUpperCase method in String class and pass a stream item to it
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


        System.out.println("===== USING FLAT MAP =====");
        EmployeeFunc jon = new EmployeeFunc("Jon Doe", 31);
        EmployeeFunc jane = new EmployeeFunc("Jane Deer", 32);
        EmployeeFunc jack = new EmployeeFunc("John Mill", 33);
        EmployeeFunc snow = new EmployeeFunc("Snow White", 33);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(jon);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                // accepts a Function that returns a stream
                // returned stream is a result of applying the mapping function to elements of the source stream
                // often used to flatten nested collections -> list all employees in departments (obj containing lists)
                .forEach(System.out::println);

        System.out.println("===== USING COLLECT(COLLECTOR) =====");
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        // Collectors.class - impl of Collector interface that implements reduction operations
            // accumulate to a List etc...
            // convert objects to Strings and join them
            // perform computations on stream els and return a value

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

        System.out.println("===== USING COLLECT(SUPPLIER, ACCUMULATOR, COMBINER) =====");
        List<String> sortedGNumbersInArrayList = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                // Supplier - creates a new ArrayList
                // Accumulator - how items will be added to the resulting arraylist
                    // runtime will add a single item to the list
                // Combiner - used to improve efficiency, used by runtime when needed

        System.out.println("===== USING GROUPINGBY(FUNCTION) =====");
        Map<Integer, List<EmployeeFunc>> groupedByAge = departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        System.out.println(groupedByAge.keySet());
        System.out.println(groupedByAge.get(33));

        System.out.println("===== USING REDUCE(BIFUNCTION) =====");
        // find the youngest employee
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        System.out.println("===== LAZILY EVALUATED OPERATIONS =====");
        // this will print nothing -> no terminal operation is present in this chain
        // if nothing comes out of the pipe, then there is no point in executing intermediate operations
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                });

        Long count = Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
        System.out.println("COUNT: " + count);
    }
}
