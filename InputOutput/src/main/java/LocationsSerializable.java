import java.io.*;
import java.util.*;

// Object input/output stream - allows us to serialize an object and read/write as a unit
    // serialization - objects must be transformed in to a series of bytes before being stored/recreated
    // deserialization - convert byte representation of object in to a replica of the object
    // classes must implement Serializable interface
// declare private field called serial version uid = version number of class
// using different compilers can cause issues -> different defaults of serial version uid for classes
// sets using class details -> changing class implies this would change
// members of an object must also be serializable if you want to serialize an entire object

// DataInput interface impl by ObjectInput
// DataOutput interface impl by ObjectOutput
// these interfaces contain read/write specific type methods -> object streams can have a mix of primitive and object types

// what happens when 2 objects that we serialize point to the same object
    // 2 foo instances have the same bar object
    // we serialize these foo object to a file -> will there be 2 bar objects?
        // no only 1 bar instance is serialized
        // object instances are unique to a file but not across files

public class LocationsSerializable implements Map<Integer, Location> {
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
                Integer dest = Integer.parseInt(destination);

                System.out.println("Imported directions: " + loc + " : " + direction + " : " + destination);

                Location location = locations.get(loc);
                location.addExit(direction, dest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/location.dat")))) {
            locFile.flush();
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }

    // read objects and print out data
    static {
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/location.dat")))) {
            boolean eof = false;

            while (!eof) {
                try {
                    // deserialize object
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");
                    // save location object
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch(InvalidClassException e) {
            // serial uid version numbers don't matach
            System.out.println("InvalidClassException: " + e.getMessage());
        } catch(ClassNotFoundException e) {
            // runtime reads object from stream and can't find class in classpath
            System.out.println("CLASS NOT FOUND EXCEPTION " + e.getMessage());
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("IO EXCEPTION");
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
