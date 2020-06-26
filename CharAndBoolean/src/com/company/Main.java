package com.company;

// chars have a width of 16, they occupy 16 bits or 2 bytes of memory
// why 2 bytes - store Unicode characters

// Unicode is an international encoding standard for use with different languages
// each char is given a unique number that is standard across platforms and programs

public class Main {

    public static void main(String[] args) {
	    char myChar = 'D'; // a character literal
        char myUnicodeChar = '\u0044'; // unicode char

        System.out.println(myChar);
        System.out.println(myUnicodeChar);

        char myCopyrightChar = '\u00A9';
        System.out.println(myCopyrightChar);

        boolean myTrueBool = true;
        boolean myFalseBool = false;

        boolean isCustomerOver21 = true;
    }
}
