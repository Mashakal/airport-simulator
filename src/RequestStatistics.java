import java.util.HashMap;

public class RequestStatistics {
    HashMap<Request.Type, TypeStatistic> stats = new HashMap<>();

    public static void newRequest(Request.Type type) {
        if (!stats.containsKey(type)) {
            stats.put(type, new TypeStatistic());
        }
    }

    class TypeStatistic {

        int numStarted = 0;
        int numCompleted = 0;
        int averageTimeSlots;

        public void start() {
            numStarted += 1;
        }

        public void complete() {
            numCompleted += 1;
        }

    }
}
