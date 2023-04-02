import java.io.*;


public class MergeRuns {
    public static void main(String[] args) {
        // Create dbruns object to distribute runs from std input into 2 files
        DistributeRuns db = new DistributeRuns(2);
        db.DR();  // start distribution
        
        try {
          //Declaring the writer and readers, and the necessary lines to be used 
            BufferedReader reader1 =  new BufferedReader(new FileReader("temp0.txt")); 
            BufferedReader reader2 = new BufferedReader(new FileReader("temp1.txt")); 
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            String[] linesArr = new String[2];
        
          // Loop until broken by one of various conditions.
            while(true){
                // If a line from file 0 isnt there
                if (linesArr[0]==null) {
                    linesArr[0] = reader1.readLine(); // Read it in
                }
                if (linesArr[1]==null) {  // If a line from file 1
                    linesArr[1] = reader2.readLine(); // Read it in
                }
                if (linesArr[1] == null) {  // If line from file 1 is still null
                    if (linesArr[0] == null) { // Check if line from file 0 is still null
                        break;  // Break from loop as we have reached end of both files
                    }
                    writer.write(linesArr[0]); // Write line to std output
                    linesArr[0] = null; // Set line element to null
                } else if (linesArr[0] == null) {  // If file 1 line is not null but file 0 line is
                    writer.write(linesArr[1]);  // Write file 1 line to std output
                    linesArr[1] = null; // Set it's array element to null again
                } else {  // We aren't at eof for either file
                    if(linesArr[0].compareTo(linesArr[1])<0){ // If line from file 0 is smaller
                        // Write line to std output and set element in array to null again
                        writer.write(linesArr[0]);
                        linesArr[0] = null;
                    }else if(linesArr[1].compareTo(linesArr[0])<0){  // if line from file 1 is smaller
                        // write line to std output and set element in array to null again 
                        writer.write(linesArr[1]);
                        linesArr[1] = null;
                    }
                }
                // Set writer to new line
                writer.newLine();
            }
            // Flush the buffer and close the readers
            writer.flush();
            reader1.close();
            reader2.close();
        } catch (Exception e) {
            // print exception to output.
            e.printStackTrace();
        }
    }
}
