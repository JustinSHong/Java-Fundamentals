package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaChallenges {
    public static void main(String[] args) {
        System.out.println("===== CHALLENGE 1 =====");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts ) {
                    System.out.println(part);
                }
            }
        };

        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts ) {
                System.out.println(part);
            }
        };

        System.out.println("===== CHALLENGE 2 =====");
        Function<String, String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };


        System.out.println("===== CHALLENGE 3 =====");
        System.out.println(everySecondChar.apply("1234567890"));

        System.out.println("===== CHALLENGE 4 =====");
        System.out.println(everySecondCharacter(everySecondChar, "1234567890"));

        System.out.println("===== CHALLENGE 5 =====");
        System.out.println(everySecondCharacter(everySecondChar, "0987654321"));

        System.out.println("===== CHALLENGE 6 =====");
        Supplier<String> iLoveJava = () -> new String("I love Java!");

        System.out.println("===== CHALLENGE 7 =====");
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        System.out.println("===== CHALLENGE 8 =====");
//      Given a specific interface, we can map a lambda to it if the interface is a functional interface and if the
//      method signature maps exactly to the arguments and the return types of the lambda

//      java.util.concurrent.Callable interface is a functional interface and therefore can be represented with a lambda
//      java.util.comparator is also a functional interface

        System.out.println("===== CHALLENGE 9 =====");
        List<String> topNames2015 = Arrays.asList(
                "Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack",
                "Charlie", "harry", "Jacob"
        );
        Function<String, String> upperCaseFirstChar = (name) -> Character.toString(name.charAt(0)).toUpperCase() + name.substring(1);
        List<String> res = upperCaseAndSort(topNames2015, upperCaseFirstChar);
        System.out.println(res);

        System.out.println("===== CHALLENGE =====");
        long count = topNames2015.stream().filter((name) -> name.startsWith("A")).count();
        System.out.println(count);
    }


    public static List<String> upperCaseAndSort(List<String> names, Function<String, String> toUpper) {
        return names.stream().map(name -> toUpper.apply(name)).sorted().collect(Collectors.toList());
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
