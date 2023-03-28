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
    }
}
