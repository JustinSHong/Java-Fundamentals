package com.company;

public class AreaCalculator {
    // write a method named area with one double param, radius
    // return area of a circle
    // return -1.0 if radius is negative
    // write an overloaded method of area with 2 params, x and y
    // return the area of a rectangle
    // return -1.0 if either or both are negative

    public static double area(double radius) {
        if (radius < 0) {
            return -1.0;
        }

        return Math.PI * Math.pow(radius, 2);
    }

    public static double area(double x, double y) {
        if (x < 0 || y < 0) {
            return -1.0;
        }

        return x * y;
    }
}
