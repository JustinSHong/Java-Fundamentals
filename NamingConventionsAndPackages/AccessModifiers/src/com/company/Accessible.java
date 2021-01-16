package com.company;

// CHALLENGE:
// what is the visibility of?

// members of an interface are always public static final


// 1. Accessible interface
    // package-private
// 2. int variable SOME_CONSTANT
    // public
// 3. methodA
    // public
// 4. methodB and methodC
    // public

interface Accessible {
    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();
}
