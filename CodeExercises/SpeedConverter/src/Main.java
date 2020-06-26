public class Main {
    // use psvm shortcut
    // result of method is ignored warning -> you're not doing anything with the return value
    public static void main(String[] args) {

        long miles = SpeedConverter.toMilesPerHour(10.5);
        System.out.println("miles is " + miles);

        SpeedConverter.printConversion(10.5);
    }
}
