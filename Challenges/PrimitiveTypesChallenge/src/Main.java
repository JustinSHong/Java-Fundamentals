// create a byte var and set it to a valid byte number
// create a short var and set it to a valid short number
// create an int var and set it to any valid int number
// create a long var and set it to 50000 + 10( byteVar + shortVar + intVar )
public class Main {
    public static void main(String[] args) {
        byte byteVar = 100;
        short shortVar = 1000;
        int intVar = 10000;

        // no casting needed since int fits in a long
        long total = 50000L + 10L * (byteVar + shortVar + intVar);
        System.out.println("total = " + total);
    }
}
