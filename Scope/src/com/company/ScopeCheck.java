package com.company;

public class ScopeCheck {
    public int publicVar = 0;
    private int var1 = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + " : var1 = " + var1);
    }

    public int getVar1() {
        return var1;
    }

    public void timesTwo() {
        int var2 = 2; // in scope of this method only
        for (int i = 0; i < 10; i++) {
            // i is limited to this scope
            System.out.println(i + " times two is " + i * var2);
        }
    }

    // a contained class's members are visible to the containing class (ScopeCheck has access to InnerClass members)
        // var3 is still scoped to InnerClass
    public void userInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("var3 from outer class: " + innerClass.var3);
    }

    public class InnerClass {
        private int var3 = 3; // in scope of InnerClass only

        public InnerClass() {
            // var1 is in scope of InnerClass
            // var1 is also visible
            System.out.println("InnerClass created, var1 is " + var1 + "and var3 is " + var3);
        }

        public void timesTwo() {
            System.out.println("varOne is still available here " + var1);
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times two is " + i * var3);
            }
        }
    }
}
