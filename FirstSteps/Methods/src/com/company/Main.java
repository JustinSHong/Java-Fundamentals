package com.company;

// method - allow you to reuse some code and allows you to easily maintain it
// returning -1 signifies an error

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int levelCompleted = 5;
        int score = 800;
        int bonus = 100;

        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("high score is " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("high score is " + highScore);

        // Create a method called displayHighScorePosition
        // it should a players name as a parameter, and a 2nd parameter as a position in the high score table
        // You should display the players name along with a message like " managed to get into position " and the
        // position they got and a further message " on the high score table".
        //
        // Create a 2nd method called calculateHighScorePosition
        // it should be sent one argument only, the player score
        // it should return an in
        // the return data should be
        // 1 if the score is >=1000
        // 2 if the score is >=500 and < 1000
        // 3 if the score is >=100 and < 500
        // 4 in all other cases
        // call both methods and display the results of the following
        // a score of 1500, 900, 400 and 50

        highScore = 1500;
        int highScorePosition = calculateHighScorePosition(highScore);
        displayHighScorePosition("Justin", highScorePosition);

        highScore = 900;
        highScorePosition = calculateHighScorePosition(highScore);
        displayHighScorePosition("Mark", highScorePosition);

        highScore = 400;
        highScorePosition = calculateHighScorePosition(highScore);
        displayHighScorePosition("Bob", highScorePosition);

        highScore = 50;
        highScorePosition = calculateHighScorePosition(highScore);
        displayHighScorePosition("Lisa", highScorePosition);

        highScore = 1000;
        highScorePosition = calculateHighScorePosition(highScore);
        displayHighScorePosition("Julia", highScorePosition);

        highScore = 500;
        highScorePosition = calculateHighScorePosition(highScore);
        displayHighScorePosition("James", highScorePosition);
    }

    public static void displayHighScorePosition(String name, int position) {
        System.out.println(name + " managed to get into position " + position + " on the high score table ");
    }

    public static int calculateHighScorePosition(int score) {
//        if (score >= 1000) {
//            return 1;
//        } else if (score >= 500) {
//            return 2;
//        } else if (score >= 100) {
//            return 3;adsfadsfsadf
//        }
//        return 4;

        int position = 4; // default position
        if (score >= 1000) {
            position = 1;
        } else if (score >= 500) {
            position = 2;
        } else if(position >= 100) {
            position = 3;
        }
        return position;
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            System.out.println("your final score was " + finalScore);
            return finalScore;
        }

        return -1;
    }
}
