package com.company;

// method overloading - technique to use the same method name with different implementations
// Java keeps track of parameters using their data types
// when overloading a method you need to use method signatures - method name and the parameters

// Java uses method signatures to keep track of overloaded methods
// calls to an overloaded method will run a specific implementation of that method

// examples: println has 10 method signatures!

// method overloading improves code readability and re-usability
// its easier to remember one name
// flexibility to call a similar method with different types of data
public class Main {

    public static void main(String[] args) {
        int score = calculateScore("Justin", 500);
        System.out.println("New score is " + score);
        calculateScore(200);
//        calculateScore(100, 100); cant do this because java expects the first argument to be a string
        calculateScore();

        calcFeetAndInchesToCentimeters(6, 0);
        calcFeetAndInchesToCentimeters(157);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }
    // overloaded method - has a different number of parameters
    public static int calculateScore(int score) {
        System.out.println("Unnamed player" + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name found, no player score");
        return 0;
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet < 0 || inches < 0 || inches > 12) {
            System.out.println("Invalid feet or inches");
            return -1;
        }

        double centimeterToInch = 2.54d;
        double inchToFoot = 12d;
        double centimeters = (feet * inchToFoot * centimeterToInch) + (inches * centimeterToInch);
        System.out.println("feet = " + feet + " inches = " + inches + " total centimeters = " + centimeters);

        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            return -1;
        }

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        double centimeters = calcFeetAndInchesToCentimeters(feet, remainingInches);
        System.out.println("feet = " + feet + " remainingInches = " + remainingInches + " cm = " + centimeters);

        return centimeters;
    }

}
