package com.company;

//-Write a method called reverse() with an int array as a parameter.
//-The method should not return any value. In other words, the method is allowed to modify the array parameter.
//-In main() test the reverse() method and print the array both reversed and non-reversed.
//-To reverse the array, you have to swap the elements, so that the first element is swapped with the last element and so on.
//-For example, if the array is {1, 2, 3, 4, 5}, then the reversed array is {5, 4, 3, 2, 1}.

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] numbers = {1, 2, 3, 4, 5};
	    int[] numbers1 = {1, 2, 3, 4, 5, 6};

        System.out.println("original array: " + Arrays.toString(numbers));
        System.out.println("original array: " + Arrays.toString(numbers1));
        reverse(numbers);
        reverse(numbers1);
    }

    public static void reverse(int[] numbers) {
        int[] copy = numbers;
        for (int i = 0; i < copy.length / 2; i++) {
            int temp = copy[copy.length - i - 1];
            copy[copy.length - i - 1] = copy[i];
            copy[i] = temp;
        }
        System.out.println("reversed array: " + Arrays.toString(copy));
    }
}
