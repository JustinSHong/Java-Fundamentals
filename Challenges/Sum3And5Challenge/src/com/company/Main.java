package com.company;

public class Main {
    // create a for loop using the range 1-1000 inclusive
    // sum all the numbers that are factors of 3 and 5
    // print numbers that are divisible by 3 and 5
    // break out of the loop when you find 5 of these numbers
    // print the sum of these numbers

    public static void main(String[] args) {
	    int count = 0;
	    int sum = 0;

	    for (int i = 1; i <= 1000; i++) {
	        if (count == 5) {
	            break;
            }

	        if (i % 3 == 0 && i % 5 == 0) {
                count++;
                sum += i;
                System.out.println(i + " is divisible by 3 and 5");
            }
        }

        System.out.println("the sum of the first 5 numbers that are divisible by 3 and 5 in the range 1-1000 is " + sum);
    }
}
