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
            while ((line=reader.readLine()) != null && heap.getSize() < runLength) {
                if (!line.isEmpty()) {
                    heap.insert(line); // insert line into heap
                }
            }
            // Organise heap before creating runs
            heap.reheap(1);

            // While the heap isnt empty
            while (heap.getSize() > 0) {
                // While the heap isnt empty and reading until the EOF is reached
                while (heap.getSize() > 0 && (line = reader.readLine())!=null) {
                    if (!line.isEmpty()) { // if the line isnt empty
                        datum = heap.remove(); // get the topmost item from the heap
                        writer.write(datum); // write to buffer
                        writer.newLine(); // go to next line

                        // if new line from input is larger than just written line
                        if (line.compareTo(datum) > 0) {
                            heap.insert(line); // insert line into heap
                        } else {
                            tempArray[tTracker] = line; // otherwise put in side array
                            tTracker++; // increment array tracker
                        }
                    }
                }
                writer.flush(); // Empty buffer and push text to std output
                // System.out.println(":-----------------------------:"); // Testing the start of a new run
                heap.load(tempArray, tTracker); // load array into heap
                tempArray = new String[runLength]; // re-init array
                tTracker = 0; // re-init array tracker
            } 

        } catch (IOException e) {
            // Print error message
            System.err.println(e.getMessage());
        }
    }
}