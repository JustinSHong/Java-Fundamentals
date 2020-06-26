// floating point numbers have fractional parts 3.453
// float - single precision (32 bits, width 32)
// double - double precision (64 bits, width 64) - larger range and more precise

// precision - format and amount of space occupied by the type.
// it is not recommended to use float
// dont directly cast use f / d notation

// doubles are faster to process - processors deal with these fasters
// Java libraries are written to process and return doubles

// For precise calculations, float and double are not great due to how floating point numbers are stored
// Java has a class BigDecimal that addresses this issue

public class Main {
    public static void main(String[] args) {
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float minimum value = " + myMinFloatValue);
        System.out.println("Float maximum value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double minimum value = " + myMinDoubleValue);
        System.out.println("Double maximum value = " + myMaxDoubleValue);

//        float myFloatValue = (float) 5.25; // must be cast
        int myIntValue = 5 / 3;
        float myFloatValue2 = 5f / 7f;
        double myDoubleValue = 5d / 7d; // default
        System.out.println("MyIntValue = " + myIntValue);
        System.out.println("MyFloatValue = " + myFloatValue2);
        System.out.println("MyDoubleValue = " + myDoubleValue);
    }
}
