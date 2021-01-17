package com.company;

// access modifiers - public, private, protected

// access control provided at:
    // top level - make classes, interfaces public or packaged as private
        // can't package a class at top level as private
        // only classes, interfaces, and enums can exist at the top level --> everything else must be included in one of these

        // PUBLIC - visible to all classes everywhere - in same package or have imported package
        // PACKAGE-PRIVATE - object only available within its own package
            // visible to every class within the same package
            // default if not public

    // member level
        // PUBLIC - visible to all classes everywhere
        // PACKAGE-PRIVATE - visible to every class within the same package
        // PRIVATE - object visible only within the class it is declared / not visible anywhere else including in sub-classes
        // PROTECTED - visible anywhere in its own package, but also IN SUB-CLASSES
public class Main {

    public static void main(String[] args) {
        Account justinsAccount = new Account("Justin");
        justinsAccount.deposit(1000);
        justinsAccount.withdrawal(500);
        justinsAccount.withdrawal(-200);
        justinsAccount.deposit(-20);
        justinsAccount.calculateBalance();

        System.out.println("Balance on account is " + justinsAccount.getBalance());

        // not good - consumers should not be able to change internal state
            // balance and transactions list should only be modified using the public interface
//        justinsAccount.balance = 5000;
//        justinsAccount.transactions.add(4500);
        justinsAccount.calculateBalance();
        System.out.println("Balance on account is " + justinsAccount.getBalance());
    }
}
