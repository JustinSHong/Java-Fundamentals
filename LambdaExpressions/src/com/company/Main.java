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

// lambdas are scoped like nested blocks
    // can see into the outer scope
    // lambdas are not classes, anonymous instance is not created


// JLS: The restriction to effectively final variables prohibits access to dynamically-changing local variables, whose capture would likely introduce concurrency problems.
// captured vars are never mutated
// local variables referenced from a lambda expression must be final or effectively final
// why do vars in outer scope have to be final in order to be used in anonymouse classes?
    // variable doesn't belong to the instance
    // var replaced by the value when instance is constructed
        // the class may not be used for a while
        // the class may be passed to another method
        // JRE can not know what the var's value is without it being final

// how have lambdas impact Java?
    // syntactic sugar - they don't add features that weren't already present
    // enable functional programming
        // focus on computing and returning results

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

	    // return is implicit
	    new Thread(() -> System.out.println("Printing from the runnable")).start();

	    // multi-line body
	    new Thread(() -> {
            System.out.println("one");
            System.out.println("two");
            System.out.println("three");
        }).start();

	    Employee john = new Employee("John Doe", 20);
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

        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        String sillyString = doStringStuff(
                uc,
                employees.get(0).getName(),
                employees.get(1).getName()
        );
        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
//        String s = anotherClass.doSomething();
        String s = anotherClass.doSomethingWithLambdaExp();
        System.out.println(s);

        // ENHANCED FOR LOOP
            // new local variable is made for each loop iteration -> var is effectively final
        for (Employee  employee: employees) {
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start(); // thread executes at different times
        }

        // using iterator.forEach(lambda)
            // accepts a lambda which maps to Consumer interface --> represents an operation that takes an input but returns nothing
            // under the hood --> iterator calls accept() which evaluates the lambda with the param
        System.out.println("===== USING ITERATOR.FOREACH() =====");
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
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

class AnotherClass {
    public String doSomething() {
        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class's name is " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");
    }

    public String doSomethingWithLambdaExp() {
        int i = 0;
        i++;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("Lamda expression's class is " + getClass().getSimpleName());
//            System.out.println("i in the lambda is " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The Another class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }

//    public void printValue() {
//        int number = 25;
//        Runnable r = () -> {
//          try {
//              Thread.sleep(5000);
//          } catch(InterruptedException e) {
//              e.printStackTrace();
//          }
//          System.out.println("The value is " + number);
//        };
//        new Thread(r).start();
//    }
}


