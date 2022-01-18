
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

// if there is too much data to store in memory we might want to use random access
    // too many locations to store at once
    // when a player moves to a new room, we should retrieve that room's data and store it

// file pointer - 0 based position, offset where the next read or write will start from
    // set to 100 - next read or write will start at byte position 100
        // reading int - next read occurs at position 100 to 103
    // read or write operations move the pointer forward depending on what was read or written

// offset - byte location in file
    // value with offset of 100 = value is located at byte 100 [file-pointer set to 100]

// record = set of related data
    // location id, description, exits = record
    // when a user moves locations how will we know which bytes to be read from file?
        // locations are ordered
        // locations aren't same length
        // we need an index to store locationid, offset and record length for each location [12 bytes]
            // get index location
            // read index data to read location data
            // index records are of the same length

// load index in to memory - accessing memory is faster than accessing files on disk
    // index will always be shorter than the actual data record
    // write index before data - offset won't be at 0
        // save offset of data - locations to the file [save near top of file]

// 1. first 4 bytes contain number of locations (bytes 0-3)
// 2. next 4 bytes contain the start offset of the locations section (4-7)
// 3. next section of the file will contain the index (1692 bytes long. start at byte 8 and end at byte 1699)
// 4. final section contains the location records (data). start at byte 1700

// write location data first then index data as a whole
    // avoid unneeded disk access, non-sequential access is even more expensive
    // build index in memory as we write locations
    // save position of file pointer to enable jumping back to the file when we write the index

// RandomAccessFile doesn't allow for reading/writing objects
    // don't need buffered stream - not sequential
    // can't be chained with other i/o classes
public class LocationsRandomAccess implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile randomAccessFile;

    // initialize locations + directions data

    // read index records and load them in to memory
    static {
        try {
            randomAccessFile = new RandomAccessFile("src/locations_rand.dat", "rwd");
            int numLocations = randomAccessFile.readInt();
            long locationStartPoint = randomAccessFile.readInt(); // locations offset

            while(randomAccessFile.getFilePointer() < locationStartPoint) {
                int locationId = randomAccessFile.readInt();
                int locationStart = randomAccessFile.readInt();
                int locationLength = randomAccessFile.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                System.out.println("saving index: " + record);
                index.put(locationId, record);
            }
        } catch (IOException e) {
            System.out.println("IOEXCEPTION " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // rwd - open file for read and write, writes occur sync
        try (RandomAccessFile randomAccess = new RandomAccessFile("src/locations_rand.dat", "rwd")) {
            randomAccess.writeInt(locations.size());
            // space for index = number of bytes per int * number of data points (id, offset, record size) * n locations
            int indexSize = locations.size() * 3 * Integer.BYTES;
            // starting point of location records - account for the first int write
            int locationStart = (int) (indexSize + randomAccess.getFilePointer() + Integer.BYTES);
            randomAccess.writeInt(locationStart);

            // write locations
            long indexStart = randomAccess.getFilePointer();

            int startPointer = locationStart;
            randomAccess.seek(startPointer); // move pointer to the 1st location offset

            // for each location, write location data and write index record
            for (Location location : locations.values()) {
                randomAccess.writeInt(location.getLocationID());
                randomAccess.writeUTF(location.getDescription());
                StringBuilder stringBuilder = new StringBuilder();
                // build exit string
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        stringBuilder.append(direction);
                        stringBuilder.append(",");
                        stringBuilder.append(location.getExits().get(direction));
                        stringBuilder.append(",");
                    }
                }
                randomAccess.writeUTF(stringBuilder.toString());

                // write index records to memory
                IndexRecord record = new IndexRecord(startPointer, (int) (randomAccess.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                // update start pointer to the next position
                startPointer = (int) randomAccess.getFilePointer();
            }

            // write index records to file
            randomAccess.seek(indexStart);
            for (Integer locationID : index.keySet()) {
                randomAccess.writeInt(locationID);
                randomAccess.writeInt(index.get(locationID).getStartByte()); // starting byte of record
                randomAccess.writeInt(index.get(locationID).getLength()); // size of record
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // allow exceptions bubble up
    public void close() throws IOException {
        randomAccessFile.close();
    }

    public Location getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        System.out.println("record : " + record);
        randomAccessFile.seek(record.getStartByte());

        int id = randomAccessFile.readInt();
        String description = randomAccessFile.readUTF();
        String exits = randomAccessFile.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, description, null);
        // add exits to location
        if (locationId != 0) {
            for (int i = 0; i < exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i +  1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
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
