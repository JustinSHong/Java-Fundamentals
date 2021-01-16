package com.company;

// while/do while - useful when you don't know how many iterations you need so you loop until a condition is met

public class Main {

    public static void main(String[] args) {
	    int count = 0;
	    while (count != 5) {
            System.out.println("count is " + count);
            count++;
        }

        count = 0;

	    // same as
        while (true) {
            if (count == 5) {
                break;
            }
            System.out.println("count is " + count);
            count++;
        }

	    // same as
        for (int i = 0; i < 5; i++) {
            System.out.println("count is " + i);
        }

        count = 0;

        // same as
        // do statement is run once
        do {
            System.out.println("count is " + count);
            count++;
        } while (count != 5);

        System.out.println("is 5 an even number? " + isEvenNumber(5));
        System.out.println("is 88 an even number? " + isEvenNumber(88));

        int startingNum = 0;
        int evenNumberCount = 0;

        while(startingNum <= 20) {
            startingNum++;
            if (!isEvenNumber(startingNum)) {
                continue;
            }
            evenNumberCount++;
            if (evenNumberCount > 5) {
                break;
            }
            System.out.println("Even number: " + startingNum);
        }
        System.out.println("number of even numbers found is " + evenNumberCount);
    }

    public static boolean isEvenNumber(int n) {
        if (n % 2 == 0) {
            return true;
        }

        return false;
    }
}
