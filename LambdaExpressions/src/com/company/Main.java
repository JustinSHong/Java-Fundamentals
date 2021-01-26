package com.company;

// introduced in Java 8
// provide easier way to work with interface with 1 method + anonymous classes that override 1 method

// lambda expression have 3 parts
    // argument list
    // arrow token
    // body

// how does the compiler know what to do with lambdas?
    // argument list is matched with particular method signature

// compiler must match the lambda to a method (ONE METHOD)
    // lambdas can only be used with interfaces that contain only 1 method
    // these interfaces are known as FUNCTIONAL INTERFACES
    // command + click to see the method the compiler thinks the lambda matches

// usage with Comparator interface
    // has 2 methods: compare and equals
    // lambdas are compatible with Comparator since equals() has a default impl
        // every instance implementing Comparator will have a default equals() inherited from Object

// lambdas can be defined and saved in a variable
    // can be re-used as needed

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // both methods involve a lot of boilerplate code
        // most of code is dedicated to object creation/instantiation rather than functionality
	    new Thread(new CodeToRun()).start();

	    new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the runnable");
            }
        });

	    new Thread(() -> System.out.println("Printing from the runnable")).start();

	    new Thread(() -> {
            System.out.println("one");
            System.out.println("two");
            System.out.println("three");
        }).start();

	    Employee john = new Employee("John Doe", 30);
	    Employee tim = new Employee("Tim Doe", 31);
	    Employee justin = new Employee("Justin Doe", 32);
	    Employee alice = new Employee("Alic Doe", 33);

	    List<Employee> employees = new ArrayList();
	    employees.add(john);
	    employees.add(tim);
	    employees.add(justin);
	    employees.add(alice);

	    // sort employees in ascending order - no lambdas
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });
//
//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//        }

        // sort employees in ascending order - use lambdas
        Collections.sort(employees, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));

        // types in argument list can be inferred
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },
//    employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff(
                uc,
                employees.get(0).getName(),
                employees.get(1).getName()
        );
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


