import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DistributeRuns {

    // define property vars
    int numFiles = 0; 
    FileWriter[] filesArray;
    int fileTracker = 0; 

    public DistributeRuns(int x){
        // takes a positive integer greater than 1.
        if(x<2){
          numFiles=2;
        }
        numFiles= x; 
        // init array to hold files
        filesArray = new FileWriter [numFiles];
        for(int i=0; i<filesArray.length; i++){ // Loop for as long as the array is
            try {
                filesArray[i] = new FileWriter("temp"+i+".txt"); // Create temp file for distribution
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void DR(){
        // define and init std input reader and file writer
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(filesArray[fileTracker]);

        String line = ""; // Line being read
        List <String> run  = new ArrayList<String>();  // Array to hold run
        try {
            //While not end of stream
            while((line=reader.readLine()) != null){
                // If line read is end of run signal
                if (line.equals("[##############################################]")) {
                    for (int i=0 ; i < run.size() ; i++) { // loop for as long as array
                        writer.write(run.get(i)); // write line from run to std output
                        writer.newLine(); // Go to new line
                    }
                    // flush buffer and re-init run arraylist
                    writer.flush();
                    run = new ArrayList<String>();
                    if (fileTracker < filesArray.length-1) { // If file tracker is not at end of files array
                        fileTracker++; // Increment tracker
                    } else {
                        fileTracker = 0; // reset tracker
                    }
                    // re-init writer to new file
                    writer = new BufferedWriter(filesArray[fileTracker]);
                } else {
                    run.add(line);  // Add line to run
                }
            }
        }catch(IOException e){
              e.printStackTrace();
        }
    }
}

