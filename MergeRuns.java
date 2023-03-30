import java.io.*;


public class MergeRuns {
    public static void main(String[] args) {
        DistributeRuns db;
        try {
            db = new DistributeRuns(Integer.parseInt(args[0]));
        } catch (Exception e) {
            e.printStackTrace();
            db = new DistributeRuns(2);
        }
        db.DR();
        
        try {
          //Declaring the writer and the necessary lines to be used 
            BufferedReader reader1 =  new BufferedReader(new FileReader("temp0.txt")); 
            BufferedReader reader2 = new BufferedReader(new FileReader("temp1.txt")); 
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            String[] linesArr = new String[2];
        
          //While the lines in each file are not null 
            while(true){
                if (linesArr[0]==null) {
                    linesArr[0] = reader1.readLine();
                }
                if (linesArr[1]==null) {
                    linesArr[1] = reader2.readLine();
                }
                if (linesArr[1] == null) {
                    if (linesArr[0] == null) {
                        break;
                    }
                    writer.write(linesArr[0]);
                    writer.write(" SCORE: 0");
                    linesArr[0] = null;
                } else if (linesArr[0] == null) {
                    writer.write(linesArr[1]);
                    writer.write(" SCORE: 1");
                    linesArr[1] = null;
                } else {
                    if(linesArr[0].compareTo(linesArr[1])<0){
                        writer.write(linesArr[0]);
                        writer.write(" SCORE: 0");
                        linesArr[0] = null;
                    }else if(linesArr[1].compareTo(linesArr[0])<0){
                        writer.write(linesArr[1]);
                        writer.write(" SCORE: 1");
                        linesArr[1] = null;
                    }
                }
                writer.newLine();
            }
            writer.flush();   
            reader1.close();
            reader2.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
