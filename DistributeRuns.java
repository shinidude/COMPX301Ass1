import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DistributeRuns {

    int numFiles =0; 
    FileWriter[] filesArray;
    int fileTracker=0; 

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
            System.out.println(filesArray[i]);
        }
    }

    public void DR(){
        //Reads the file 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(filesArray[fileTracker]);

        String line = ""; 
        String prevLine="";
        List <String> runs  = new ArrayList<>();
        //While not of end of stream
        try {
            while((line=reader.readLine())!=null){
                runs.add(line);

                //Determine end of run 
                // if(line.compareTo(prevLine)<0){
                //     writer.flush();
                //     //Determine if need to change files
                //     if(fileTracker<(filesArray.length-1)){
                //         fileTracker++; //Moving to the next file 
                //     }
                //     else{
                //         fileTracker=0;
                //     }
                //     runs.clear();
                //     writer =  new BufferedWriter(filesArray[fileTracker]);
                // }else{
                //     for (String string : runs) {
                //         writer.write(string);
                //         writer.newLine();
                //         System.out.println(string);
                //     }
                //     prevLine = line;
                // }
            }
            int evenRuns = runs.size()/numFiles;

            for(int i = 0; i<filesArray.length; i++){
                writer = new BufferedWriter(filesArray[i]);
                for(int n = 0; n < evenRuns; n++){
                    writer.write(runs.get(n));
                    writer.newLine();
                }
                evenRuns = runs.size()/numFiles;
            }
        }catch(IOException e){
              e.printStackTrace();
        }
    }
}

