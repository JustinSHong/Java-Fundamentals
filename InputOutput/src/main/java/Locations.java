import java.io.*;
import java.util.*;

// buffering stream - large chunks of data are read in to memory by buffered reader
    // prevents excessive access to disk
    // data is read only from disk when the buffer is empty
// buffer stream when writing to disk
    // file writer puts data in to the buffered writer
    // data is only written to disk when buffer is full
    // prevents excessive writes to the disk


// write this location data to a file rather than hard coding them
// executed when class is loaded - data available when invoking methods
    // can write a main method to write out locations to a file

// checked exceptions cannot be ignored (IOException)
    // must be handled in some way
        // catch and handle
        // specify exception will be thrown up the call stack
    // FileNotFoundException is a subclass of IOException

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

//    static {
//        Scanner scanner = null;
//        try {
//            // inputs to scanner must implement the Readable inteface
//            scanner = new Scanner(new FileReader("src/locations_big.txt"));
//            scanner.useDelimiter(",");
//
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ":" + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                scanner.close(); // also closes any object that it was using if it implements the Closable interface
//            }
//        }
//    }

    static {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/locations_big.txt")))) {
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
            e.printStackTrace(); // checked exceptions can't be suppressed in static initialization blocks
        }
    }

    // Buffered Reader - reads text from input stream and buffers characters in a chars array
        // tend to be faster and more efficient
            // seeking where to read from is resource intensive
        // default size is 8k files - contents of a file are buffered in a single read
    static {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/directions_big.txt"));
        ) {
            String input;
            while((input = bufferedReader.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, loc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // we are specifying that this method throws IOException
        // caller will know this - must catch or specify to throw
        // specifying means you are passing the responsibility of handling the exception to the caller
//    public static void main(String[] args) throws IOException {
//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt"); // open stream
//
//            // write locations to file
//            for (Location location : locations.values()) {
//                // write data to stream
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        } finally {
//            // always executed regardless of success or failure
//            // can execute any clean up that must happen
//            // need to close to avoid exceptions - resource leakage, locked files, data corruption, file locked
//
//            // defensive programming to ensure no crashes
//            if (locFile != null) {
//                System.out.println("Attempting to close locfile");
//                locFile.close(); // close() throws IOException
//            }
//        }
//    }

    // try-with-resources - makes writing data to streams a lot cleaner
        // ensure that the FileWriter stream is closed whether or not an exception occurs
        // introduced in java 7
        // exceptions that occur when opening or writing to the stream are thrown up the call stack
        // exceptions that occur when closing are suppressed

    // root cause of error is most likely the exception that occurred while opening or writing to the stream
        // this is why try-with-resources suppresses the exceptions from closing
    public static void main(String[] args) throws IOException {
        // declare one or more resources - any object that must be closed - that has a side effect
        try(FileWriter locFile = new FileWriter("src/locations_big.txt");
            FileWriter dirFile = new FileWriter("src/directions_big.txt")
        ) {
            for (Location location : locations.values()) {
                // write locations
                locFile.write(location.getLocationID() + "," + location.getDescription() + ",");
                // write exits for each locations
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
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
