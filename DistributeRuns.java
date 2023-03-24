import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DistributeRuns {

    int numFiles = 0; 
    FileWriter[] filesArray;
    int fileTracker = 0; 

    public DistributeRuns(int x){
        // takes a positive integer greater than 1.
        if(x<2){
          numFiles=2;
        }
        numFiles= x; 
        filesArray = new FileWriter [numFiles];
        for(int i=0; i<filesArray.length; i++){
            try {
                filesArray[i] = new FileWriter("temp"+i+".txt");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // System.out.println(filesArray[i]);
        }
    }

    public void DR(){
        //Reads the file 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(filesArray[fileTracker]);

        String line = ""; 
        String prevLine="";
        List <String> run  = new ArrayList<String>();
        //While not of end of stream
        try {
            while((line=reader.readLine()) != null){
                if (line.equals("[##############################################]")) {
                    for (int i=0 ; i < run.size() ; i++) {
                        writer.write(run.get(i));
                        writer.newLine();
                        // System.out.println(run.get(i)); // For testing that runs are read properly
                    }
                    // System.out.println("[----------------------------------------------]");
                    // writer.write("[----------------------------------------------]");
                    // writer.newLine(); // this and the last line to see where each run ends in the files.
                    writer.flush();
                    run = new ArrayList<String>();
                    if (fileTracker < filesArray.length-1) {
                        fileTracker++;
                    } else {
                        fileTracker = 0;
                    }
                    writer = new BufferedWriter(filesArray[fileTracker]);
                } else {
                    run.add(line);
                    prevLine = line;
                }
            }
        }catch(IOException e){
              e.printStackTrace();
        }
    }
}

