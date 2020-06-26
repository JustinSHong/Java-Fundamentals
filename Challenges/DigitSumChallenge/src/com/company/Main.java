package com.company;

public class Main {

//    Write a method with the name sumDigits that has one int parameter called number.
//    If parameter is >= 10 then the method should process the number and return sum of all digits, otherwise return -1 to indicate an invalid value.
//    The numbers from 0-9 have 1 digit so we donÅft want to process them, also we donÅft want to process negative numbers, so also return -1 for negative numbers.

//    For example calling the method sumDigits(125) should return 8 since 1 + 2 + 5 = 8.
//    Calling the method sumDigits(1) should return -1 as per requirements described above.
//    Add some code to the main method to test out the sumDigits method to determine that it is working correctly for valid and invalid values passed as arguments.

//    Hint:
//    Use n % 10 to extract the least-significant digit.
//    Use n = n / 10 to discard the least-significant digit.
//    The method needs to be static like other methods so far in the course.

    public static void main(String[] args) {
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(111));
        System.out.println(sumDigits(999));
        System.out.println(sumDigits(0));
    }

    public static  int sumDigits(int number) {
        if (number < 10) {
            System.out.println("Invalid value - number was 0-9 or a negative number");
            return -1;
        }

        int sum = 0;
        int current = number;
        while (current > 0) {
            System.out.println("current = " + current);
            int temp = current % 10;
            System.out.println("temp = " + temp);
            sum += temp;
            current /= 10;
        }
        System.out.println("the sum of the digits is " + sum);
        return sum;
    }
}
