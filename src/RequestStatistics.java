import java.util.HashMap;

public class RequestStatistics {

    private HashMap<Request.Type, TypeStatistic> stats = new HashMap<>();


    public void tallyStart(Request.Type type) {
        if (!stats.containsKey(type)) {
            stats.put(type, new TypeStatistic());
        } else {
            stats.get(type).start();
        }
    }


    public void tallyCompletion(Request.Type type, int numSlotsTaken) {
        stats.get(type).complete(numSlotsTaken);
    }


    public int countStarted(Request.Type type) {
        return stats.get(type).numStarted;
    }


    public int countCompleted(Request.Type type) {
        return stats.get(type).numCompleted;
    }


    public double averageTime(Request.Type type) {
        return stats.get(type).averageTimeSlots;
    }


    private class TypeStatistic {

        int numStarted;
        int numCompleted;
        double averageTimeSlots;


        private TypeStatistic() {
            this.numStarted = 1;
            this.numCompleted = 0;
            this.averageTimeSlots = 0;
        }


        private void start() {
            numStarted++;
        }


        private void complete(int numSlotsTaken) {
            double sum = numSlotsTaken;
            sum += this.averageTimeSlots * this.numCompleted;
            this.numCompleted++;
            this.averageTimeSlots = sum / this.numCompleted;
        }

    }

}
