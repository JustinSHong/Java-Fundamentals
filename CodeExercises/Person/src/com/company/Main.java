package com.company;

public class Main {

    public static void main(String[] args) {
	    Person john = new Person("John", "Wick", 35);
        System.out.println("John's first name is " + john.getFirstName());
        System.out.println("John's last name is " + john.getLastName());
        System.out.println("John's name is " + john.getFullName());
        System.out.println("John's age is " + john.getAge());
        System.out.println(john.isTeen());

        john.setAge(40);
        john.setFirstName("JOHN");
        john.setLastName("WICK");

        System.out.println("John's first name is " + john.getFirstName());
        System.out.println("John's last name is " + john.getLastName());
        System.out.println("John's name is " + john.getFullName());
        System.out.println("John's age is " + john.getAge());
    }
}
