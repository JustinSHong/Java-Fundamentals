package com.company;

public class MegaBytesConverter {

    // write a method called printMegaBytesAndKiloBytes that has 1 parameter of type int with the name kiloBytes
    // the method shouldn't return anything
    // the method should calculate megabytes and the remaining kilobytes
    // output should look like "XX KB = YY MB and ZZ KB"
    // XX represents the total amount of kiloBytes
    // YY represents the calculated megabytes
    // ZZ represents the remaining kilobytes

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
            return;
        }
        // calculate megabytes and remaining kilobytes
        int megabytes = kiloBytes / 1024;
        int remainingKilobytes = kiloBytes % 1024;

        String result = kiloBytes + " KB = "
                        + megabytes + " MB and "
                        + remainingKilobytes + " KB";

        System.out.println(result);
    }
}
