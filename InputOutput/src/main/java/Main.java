
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// several approaches to IO in Java
    // java.io
    // java.nio (introduced in java 7)

// input = read from source
// output = write to a destination (files on disk, network connections, pipes, keyboard, screen)

// File.class
    // make new directory to store file
    // present user with list of files to choose from

// IO basic concepts
    // byte vs character data - methods are same while classes will vary
        // character data
            // data is in readable format and files can be opened (xml, json)
        // binary data
            // not human readable (variable, classes)
    // sequential/serial vs random access files
        // sequential - stream of data that arrives or is sent from a program in a specific order + pieces of data are ordered
        // random access - jump within file to retrieve or overwrite data in a chosen file (ie. database with indexing)

public class Main {
//    private static LocationsSerializable locations = new LocationsSerializable();
    private static Locations locations = new Locations();
//    private static LocationsTryWithResources locations = new LocationsTryWithResources();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
