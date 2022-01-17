import java.io.*;
import java.util.*;

// ========== DEALING WITH BYTE STREAMS ==========
    // byte streams can be used to write any java primitive types
    // special case to handle strings
    // use FileOutputStream and FileInputStream instead of FileWriter and FileReader
    // FileOutputStream - open file for writing
    // use DataOutputStream and DataInputStream to read/write primitive type values from stream
    // read 4 bytes at a time
    // allows us to not worry about shifting bytes
    // you need to know the format of the data being read/written
    // these classes throw EOFException when end of file is reached - expected event
    // should be treated separately to avoid confusion with other IOExceptions
public class LocationsByteStream implements Map<Integer, Location> {
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
                String destination = scanner.nextLine();

                System.out.println("Imported directions: " + loc + " : " + direction + " : " + destination);

                Location location = locations.get(loc);
                location.addExit(direction, loc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    static {
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("src/location.dat")))) {
            boolean eof = false;

            while (!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.read();
                    System.out.println("Read location " + locID + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for (int i = 0; i < numExits; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("IO EXCEPTION");
        }
    }

    public static void main(String[] args) throws IOException {
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/location.dat")))) {
            for (Location location: locations.values()) {
                locFile.writeInt(location.getLocationID()); // write integer
                locFile.writeUTF(location.getDescription()); // write string
                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1);

                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
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
