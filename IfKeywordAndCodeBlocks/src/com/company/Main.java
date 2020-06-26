package com.company;

public class Main {

    public static void main(String[] args) {
	    boolean gameOver = true;
	    int levelCompleted = 5;
	    int score = 800;
	    int bonus = 100;

	    // if conditional with braces
        // braces signify a code block and make readability clearer
        if (score == 5000) {
            System.out.println("your score was 5000");
        }
        // same as above
        if (score == 5000)
            System.out.println("your score was 5000");
        // we can't do this
        if (score == 5000)
            System.out.println("your score was 5000");
        System.out.println("this was executed"); // outside the if statement

        if (score < 5000 && score > 1000) {
            System.out.println("your score was less than 5000 and greater than 1000");
        } else if (score < 1000) {
            System.out.println("you score was less than 1000");
        } else {
            System.out.println("got here");
        }
        // variables in code blocks are removed from memory after the computer processes them
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("your final score was " + finalScore);
        }

        // int savedFinalScore = finalScore; // can't access finalScore because it is in an inner scope

        // CHALLENGE - print out a second score on the screen with the following
        // score set to 10000
        // levelCompleted set to 8
        // bonus set to 200
        // make sure the first printout above still displays as well

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("your final score was " + finalScore);
        }
    }
}
