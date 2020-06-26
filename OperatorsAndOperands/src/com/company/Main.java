package com.company;

// operator - special symbols that perform specific operations and return a value
// operand - describe any object manipulated by an operator, subject of an operation
// expression - combination of variables, literals, method return values, operators

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2; // 1 + 2 = 3
        System.out.println("1 + 2 = " + result);

        // result = result + 1
        result++;
        // result = result - 1
        result--;
        // result = result + 2
        result += 2;
        // result = result * 10
        result *= 10;
        // result = result / 3
        result /= 3;
        // result = result - 2
        result -= 2;

        boolean isAlien = false;
        if (!isAlien) { // isAlien == false
            System.out.println("it is not an alien");
        }

        // ! - logical complement, check for the opposite
        // == - equal to
        // != - not equal to
        // > < >= <=
        // && - logical and -> compares two operands evaluate to true
        // || - logical or

        int newValue = 50;
        // incompatible types
//        if (newValue = 50) { need to use == not =
//            System.out.println("This is an error");
//        }

        boolean isCar = false;
        if (isCar = true) { // isCar eventually evaluates to a boolean should say isCar == true
            System.out.println("this is not supposed to happen"); // this is executed
        }

        // TERNARY OPERATORS
        boolean wasCar = isCar ? true : false; // condition being tested ? [value if condition is true] : [value if condition is false]

    }
}
