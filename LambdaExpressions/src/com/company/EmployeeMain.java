package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

// interfaces in java.util.function don't dictate what the lambdas do,
    // describe arguments and return values only

// Consumer
    // accept() - allows accepting of an arg
    // andThen() - allows chaining

// Predicate<T>
    // lambda maps to the Predicate
    // represents a lambda that evaluates to a Boolean and takes one argument
    // has one method test(Object) which determines if Object fulfills Predicate (true) or fails (false)

// predicate arguments = lambdas that map to the Predicate interface
    // accept 1 param
    // returns a boolean
    // can help reduce the use of multiple if / else if statements to evaluate a condition

// predicates can be reused
// predicates can be chained (ie. nesting if / else if statements) with default methods
    // and()
    // or()
    // negate()
    // isEquals()
    // not()

    // predicate.test(argument)
    // predicate.[conjunction]test(predicate).test(argument)

// some functional interfaces are generic, others are not and expect a specific type

// Supplier interface
    // takes no args + returns a value
    // must supply the return type
    // can be passed to methods
    // use cases
        // supply objects for another object
        // provide i/o stream
        // instantiate objects and populate them with random objects

    // (supplier lambda).get(); --> return a result from some operation

// Function interface ---> apply a function to the given argument (function).apply(input)
    // takes 1 argument and returns 1 value
    // use apply(target) to apply the lambda to a given argument
    // convenient if you don't want to creat a class with a method
    // useful when you know some code will want to be applied in varying situations
        // replaces writing methods for every situation
        // callbacks - massage fetched data in a background thread in varying ways

            // ie resize fetched images - thread that started the background thread is responsible for providing means
            // to do the resizing

    // specific function interfaces are not generic --> Function<Target, Return>
        // LongToInt
        // IntToDouble

    // Functions can be chained with andThen()
        // [Function1].andThen([Function2]) ---> Function1 is called first, then Function2 is called with the result of Function1

// BiFunction interface <argType1, argType2, returnType>
    // chain with Function using andThen()
    // has no compose() method

// Unary operator interface
    // accepts a single argument and return a value of the same type as the arg
    // extend Function interface
    // argument and result have the same type

public class EmployeeMain {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 24);
        Employee tim1 = new Employee("Tim Doe1", 29);
        Employee justin = new Employee("Justin Doe1", 32);
        Employee alice = new Employee("Alic Doe", 33);

        List<Employee> employees = new ArrayList();
        employees.add(john);
        employees.add(tim1);
        employees.add(justin);
        employees.add(alice);

        System.out.println("===== USING ITERATOR.FOREACH() =====");
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        System.out.println("===== Employees over 30 yo =====");
        employees.forEach(employee -> {
            if (employee.getAge() > 30) {
                System.out.println(employee.getAge());
            }
        });

        System.out.println("===== Employees 30 or younger =====");
        employees.forEach(employee -> {
            if (employee.getAge() > 30 || employee.getAge() < 30) {
                System.out.println(employee.getName());
            }
        });

        System.out.println("===== USING PREDICATE FUNCTIONAL INTERFACE =====");

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees under 30", employee -> employee.getAge() < 30);
        printEmployeesByAge(employees, "Employees under 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate intPredicateGreaterThan15 = i -> i > 15;
        IntPredicate intPredicateLessThan100 = i -> i < 100;
        System.out.println(intPredicateGreaterThan15.test(10));

        int a = 20;
        System.out.println(intPredicateGreaterThan15.test( a + 5));

        // chained predicates - all predicates must be true to return true
        // parameter is at the same scope for all predicates
        System.out.println(intPredicateGreaterThan15.and(intPredicateLessThan100).test(50));

        System.out.println("===== Using Supplier =====");
        Random random = new Random();
//        for (int i = 0; i < 10; i ++) {
//            System.out.println(random.nextInt(1000));
//        }

        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last name is: " + lastName);
        });

        // want a lambda that takes in a string and returns a string
        System.out.println("===== Using Function interface =====");
        Function<Employee, String> getLastName = (employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(2));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = employee -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));
        Function<String, String> lastname = name -> name.substring(name.indexOf(' '));
        Function chainedFunctionReverse = firstName.compose(upperCase);
        System.out.println(chainedFunctionReverse.apply(employees.get(0)));

        System.out.println("==== BiInterface =====");
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello World!");
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println("Age text: " + ageText);
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) { // predicate
                System.out.println(employee.getName());
            }
        }
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }
}
