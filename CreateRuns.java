import java.io.*;

class CreateRuns {
    public static void main(String[] args) {
        // Setting up standard input and output objects
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // Creating heap and array for run creation
        int runLength = Integer.parseInt(args[0]);
        MyMinHeap heap = new MyMinHeap(runLength);
        String[] tempArray = new String [runLength];
        int tTracker = 0; // tracks the next position to put lines in and how many are in there
        
        // Var to read data into
        String line="";
        String datum="";
        try {
            // Filling the heap
            // While reader not at EOF and heap is not full
            while ((line=reader.readLine())!=null && heap.getSize() < runLength) {
                heap.insert(line); // insert line into heap
            }
            
            // Organise heap before creating runs
            heap.reheap(1);
            // Read one line at a time, stop once EOF has been reached
            while ((line=reader.readLine())!=null) {
                // if heap plus ttracker are smaller than run length, insert into heap
                if (heap.getSize()+tTracker < runLength) {
                    // only insert if new line is larger than last line
                    if (datum.compareTo(line)<0){
                        heap.replace(line);
                    } else { // otherwise move into temp array
                        tempArray[tTracker] = line;
                        tTracker++; // increment tracking var
                    }
                // if tempArray is not equal to heap size
                } else if (tTracker != runLength) {
                    datum = heap.peek(); // get root value
                    writer.write(datum); // write to buffer
                } else { // temp array is heap size
                    writer.flush(); // flush buffer for new run
                    heap.load(tempArray); // load array into (now) empty heap
                    tempArray = new String[runLength]; // empty temp array
                    tTracker = 0; // reset tracking var
                }
            }
            // if eof was reached but heap wasn't emptied
            while (heap.getSize() > 0) {
                writer.write(heap.remove()); // get root node and write to buffer
            }
            // if temp array also had stuff in it, use to make a final run
            if (tTracker > 0) {
                heap.load(tempArray); // load array into heap
                while (heap.getSize() > 0) { // until heap is empty
                    writer.write(heap.remove()); // get root node and write to buffer
                }
            }
            writer.flush(); // flush buffer to standard output
        } catch (IOException e) {
            // Print error message
            System.err.println(e.getMessage());
        }
    }
}