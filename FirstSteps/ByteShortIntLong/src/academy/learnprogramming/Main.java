package academy.learnprogramming;

// Integer is Wrapper Class
// all 8 primitive data types have a Wrapper Class

// int range -2_147_483_648 to 2_147_483_648
// byte range -128 to 127
// short range -32768 to 32768
// long range -9223372036854775808 to 9223372036854775808

// 1 byte = 8 bits
// a byte was a width of 8
// short occupies 16 bits and has a width of 16
// int occupies 32 bits and has a width of 32
// long occupies 64 bits and has a width of 64

// every type occupies a different amount of memory
public class Main {

    public static void main(String[] args) {
	    int myValue = 1000;

	    int myMinIntValue = Integer.MIN_VALUE; // min value
	    int myMaxIntValue = Integer.MAX_VALUE; // max value
        System.out.println("Integer Minimum Value = " + myMinIntValue);
        System.out.println("Integer Maximum Value = " + myMaxIntValue);
        System.out.println("Busted Max Value = " + (myMaxIntValue + 1)); // overflow - can't fit in memory
        System.out.println("Busted Min Value = " + (myMinIntValue - 1)); // underflow

        // literal values that overflow/underflow trigger errors
        // int myMaxIntTest = 2_147_483_648;

        // use byte to store lot of number in that range to save memory
        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value = " + myMinByteValue);
        System.out.println("Byte Minimum Value = " + myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short Minimum Value = " + myMinShortValue);
        System.out.println("Short Maximum Value = " + myMaxShortValue);

        // long - use if number value is larger than an int
        long myLongValue = 100L;
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Short Minimum Value = " + myMinLongValue);
        System.out.println("Short Maximum Value = " + myMaxLongValue);

        // default type for whole numbers is int
        long bigLongLiteral = 2_147_483_647_232L;
        System.out.println(bigLongLiteral);

        // Java is smart enough to convert between types
        short bigShortLiteral = 32767;

        int myTotal = (myMinIntValue / 2);

        // use casting to tell Java a value will fit in a given type
        byte myNewByteValue = (byte) (myMinByteValue / 2);
        short myNewShortValue = (short) (myMinShortValue / 2);
    }
}
