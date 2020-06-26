package com.company;

public class NumberToWords {
    // write a method numberToWords with one param, number
    // print out the passed number using words for the digits
    // number less than 0 return "Invalid Value"

    // write a method called reverse that prints the reversed number (234 returns 432)
    // reverse accepts positive and negative numbers

    // write another method called getDigitCount that returns the count of the digits in the number
    // number less than 0 returns -1

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        int count = getDigitCount(number);
        String result = "";
        int current = reverse(number);
        while (count > 0) {
            int digit = current % 10;

            switch (digit) {
                case 0:
                    result += "Zero";
                    break;
                case 1:
                    result += "One";
                    break;
                case 2:
                    result += "Two";
                    break;
                case 3:
                    result += "Three";
                    break;
                case 4:
                    result += "Four";
                    break;
                case 5:
                    result += "Five";
                    break;
                case 6:
                    result += "Six";
                    break;
                case 7:
                    result += "Seven";
                    break;
                case 8:
                    result += "Eight";
                    break;
                case 9:
                    result += "Nine";
                    break;
                default:
                    System.out.println("Invalid Value");
            }

            current /= 10;
            count--;
            result += " ";
        }

        System.out.println(result);
    }

    public static int reverse(int number) {
        int reversed = 0;
        int current = number < 0 ? number * -1 : number;
        int decimalPlace = 1;
        int x = current;
        while (x > 0) {
            if (x < 10) {
                break;
            }
            decimalPlace *= 10;
            x /= 10;
        }

        while (current > 0) {
            int digit = current % 10;
            reversed += decimalPlace * digit;

            decimalPlace /= 10;
            current /= 10;
        }

        if (number < 0) {
            reversed *= -1;
        }

        return reversed;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }

        int count = number == 0 ? 1 : 0;
        int current = number;
        while (current > 0) {
            count++;
            current /= 10;
        }

        return count;
    }
}
