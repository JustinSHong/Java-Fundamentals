package com.company;

import java.util.function.Function;
import java.util.function.Supplier;

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
