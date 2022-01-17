import java.io.*;
import java.util.*;

// write this location data to a file rather than hard coding them
// executed when class is loaded - data available when invoking methods
    // can write a main method to write out locations to a file

// checked exceptions cannot be ignored (IOException)
    // must be handled in some way
        // catch and handle
        // specify exception will be thrown up the call stack
    // FileNotFoundException is a subclass of IOException

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    // read and save locations
    static {
        locations.clear();
        Scanner scanner = null;
        try {
            // inputs to scanner must implement the Readable inteface
            scanner = new Scanner(new FileReader("src/locations_big.txt"));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ":" + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close(); // also closes any object that it was using if it implements the Closable interface
            }
        }
    }

    // read and save directions
    static {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("src/directions_big.txt"));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String direction = scanner.next();
                scanner.skip(scanner.delimiter());
                String dest = scanner.nextLine();
                int destination = Integer.parseInt(dest);

                System.out.println("Imported directions: " + loc + " : " + direction + " : " + destination);

                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // we are specifying that this method throws IOException
        // caller will know this - must catch or specify to throw
        // specifying means you are passing the responsibility of handling the exception to the caller
    public static void main(String[] args) throws IOException {
        FileWriter locFile = null;
        FileWriter dirFile = null;
        try {
            locFile = new FileWriter("locations.txt"); // open stream
            dirFile = new FileWriter("directions.txt");

            // write locations to file
            for (Location location : locations.values()) {
                // write data to stream
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");

                for (String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        } finally {
            // always executed regardless of success or failure
            // can execute any clean up that must happen
            // need to close to avoid exceptions - resource leakage, locked files, data corruption, file locked

            // defensive programming to ensure no crashes
            if (locFile != null) {
                System.out.println("Attempting to close locfile");
                locFile.close(); // close() throws IOException
                dirFile.close();
            }
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> map) {

    }
}
