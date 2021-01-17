package com.company;

// use switch statements to evaluate a value against certain values for equality
// switch statements are equivalent to if statements but less flexible

// omitting break causes unexpected results -> java will evaluate all cases!

// switch can be used with byte, short, char, int, String (after Java 7)

// remember to sanitize values when passing them to switch() -> ie. lowercase or uppercase all strings and chars
    // do this to avoid coding in edge cases

public class Main {

    public static void main(String[] args) {
//        int value = 3;
//        if (value == 1) {
//            System.out.println("Value was 1");
//        } else if (value == 2) {
//            System.out.println("Value was 2");
//        } else {
//            System.out.println("Was not 1 or 2");
//        }

	    int switchValue = 5;
        switch(switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("was 3 or 4 or 5");
                break;
            default:
                System.out.println("was not 1 or 2");
                break;
        }
        // Create a new switch statement using char instead of int
        // create a new char variable
        // create a switch statement testing for
        // A, B, C, D, or E
        // display a message if any of these are found and then break
        // Add a default which displays a message saying not found

        char myChar = 'A';
        switch (myChar) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
                System.out.println(myChar + " was found");
                break;
            default:
                System.out.println("not found");
                break;
        }

        String month = "January";
        switch(month.toLowerCase()) {
            case "January":
                System.out.println("January");
                break;
            case "February":
                System.out.println("February");
                break;
            case "March":
                System.out.println("March");
                break;
            default:
                System.out.println("not sure what month this is");
                break;
        }
    }
}
