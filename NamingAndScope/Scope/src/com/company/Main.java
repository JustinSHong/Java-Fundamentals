package com.company;

// scope - visibility of a class, member, or variable
// access modifiers are one way to restrict scope
// member with narrowest scope is used - what is the most local
    // Java looks inside to outside
        // error thrown when a member is not found

// variable can only shadow another with the same name if its declared in an enclosed {}

// visibility controlled by access modifiers
    // connected to scope

public class Main {

    public static void main(String[] args) {
        String var4 = "this is private to main";

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.userInner();

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        // no visibility from outside its class and the containing class - currently it has private
//        System.out.println("var3 is not accessible here " + innerClass.var3);

        System.out.println("scopeInstance var1 is " + scopeInstance.getVar1());
        System.out.println("privateVar in Main is " + var4); // in scope

        scopeInstance.timesTwo();

        System.out.println("**********");
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();
    }
}
