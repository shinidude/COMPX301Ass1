public class MergeRuns {
    public static void main(String[] args) {
        try {
            DistributeRuns db = new DistributeRuns(Integer.parseInt(args[0]));
        } catch (Exception e) {
            e.printStackTrace();
            DistributeRuns db = new DistributeRuns(2);
        }

        
    }
}
