package com.company;

public class NumberPalindrome {
    // write a method called isPalindrome with a param called number
    // return true if number is a palindrome otherwise return false

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            number *= -1;
        }

        int current = number;
        int lastDigit = 0;
        int reversed = 0;
        while (current > 0) {
            lastDigit = current % 10;
            reversed *= 10;
            reversed += lastDigit;

            current /= 10;
        }
        System.out.println("number is " + number);
        System.out.println("reversed is " + reversed);

        return number == reversed;
    }
}
