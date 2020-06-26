package academy.learnprogramming;

// create a variable with the appropriate type to store the number of pounds to be converted to kg
// calculate the result ie. number of kilograms based on the contents of the variable
// store the result in a 2nd variable
// print the result
// Hint: 1 pound is equal to 0.45359237 of a kg

public class Main {

    public static void main(String[] args) {
        double conversionFactor = 0.45359237d;
        double pounds = 100d;
        double kg = pounds * conversionFactor;
        System.out.println("the value in kg is " + conversionFactor);
    }
}
