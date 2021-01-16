package com.company;

// keywords - reserved words that have a predefined meaning in the language (int, boolean, char)
// expressions - building blocks of programs, combination of variables, operators, and method calls
// expressions don't include data types and the semi-colon
// expression are like parts of a sentence

// statements are expressions with a data-type and the semi-colon -> complete sentences

public class Main {

    public static void main(String[] args) {
        int score = 100; // score = 100 is the expression
        if (score > 90) { // score > 90 is the expression
            System.out.println("you got the high score !"); // "you got the high score !" is the expression
            score = 0; // score = 0 is the expression
        }
    }
}
