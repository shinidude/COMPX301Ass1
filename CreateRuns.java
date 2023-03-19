import java.io.*;

class CreateRuns {
    public static void main(String[] args) {
        // Setting up standard input and output objects
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        // Var to read data into
        String line="";
        try {
            // Read one line at a time, stop once EOF has been reached
            while ((line=reader.readLine())!=null) {
                // Do stuff
            }
        } catch (IOException e) {
            // Print error message
            System.err.println(e.getMessage());
        }
    }
}