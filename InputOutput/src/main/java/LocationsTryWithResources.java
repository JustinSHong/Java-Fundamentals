import java.io.*;
import java.util.*;

// buffering stream - large chunks of data are read in to memory by buffered reader
// prevents excessive access to disk
// data is read only from disk when the buffer is empty
// buffer stream when writing to disk
// file writer puts data in to the buffered writer
// data is only written to disk when buffer is full
// prevents excessive writes to the disk

public class LocationsTryWithResources implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    // read and save locations
    static {
        locations.clear();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/locations_big.txt")))) {
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt(); // location id
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine(); // location description
                System.out.println("Imported loc: " + loc + " : " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // read and save directions
    // Buffered Reader - reads text from input stream and buffers characters in a chars array
    // tend to be faster and more efficient
    // seeking where to read from is resource intensive
    // default size is 8k files - contents of a file are buffered in a single read
    static {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/directions_big.txt"))) {
            String input;

            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                System.out.println(loc + " : " + direction + " : " + destination);

                Location location = locations.get(loc);
                location.addExit(direction, loc);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // try-with-resources - makes writing data to streams a lot cleaner
    // ensure that the FileWriter stream is closed whether or not an exception occurs
    // introduced in java 7
    // exceptions that occur when opening or writing to the stream are thrown up the call stack
    // exceptions that occur when closing are suppressed
    // root cause of error is most likely the exception that occurred while opening or writing to the stream
    // this is why try-with-resources suppresses the exceptions from closing
    public static void main(String[] args) throws IOException {
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("src/locations.txt"));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter("src/directions.txt"))
        ) {
            for (Location location : locations.values()) {
                // write locations
                locFile.write(location.getLocationID() + "," + location.getDescription() + ",\n");
                // write exits for each locations
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
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
    public Set<Map.Entry<Integer, Location>> entrySet() {
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
