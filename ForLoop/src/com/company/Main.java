package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("10000 at 2% interest = " + calculateInterest(10000d, 2.0));

        // for (init; termination; increment) {...}

        for (int i = 0; i < 5; i++) {
            System.out.println("i is " + i);
        }

        for (int i = 2; i < 9; i++) {
            System.out.println("10000 at " + i + "% interest = " + String.format("%.2f" ,calculateInterest(10000d, i)));
        }

        for (int i = 8; i >= 2; i--) {
            System.out.println("10000 at " + i + "% interest = " + String.format("%.2f" ,calculateInterest(10000d, i)));
        }

        int primeCount = 0;
        for (int i = 2; i < 51; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is a prime number!");
                primeCount++;
            }
            if (primeCount == 3) {
                System.out.println("found 3 prime numbers");
                System.out.println("i is " + i);
                break;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }
}
