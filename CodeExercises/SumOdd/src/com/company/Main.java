package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(SumOddRange.isOdd(1));
        System.out.println(SumOddRange.isOdd(3));
        System.out.println(SumOddRange.isOdd(23));

        System.out.println(SumOddRange.sumOdd(13, 13));
        System.out.println(SumOddRange.sumOdd(100, -100));
        System.out.println(SumOddRange.sumOdd(100, 1000));
    }
}
