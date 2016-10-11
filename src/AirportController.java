import java.util.HashMap;
import java.util.LinkedList;

public class AirportController {
	
	private static HashMap<Request.Type, ControllerData> data = new HashMap<>();
	
	private static final String planeStr = "Plane #%d has entered the %s queue.";
	private static final String timeStr = "The time is: %d";


	public AirportController() {
		for (Request.Type type : Request.Type.values()) {
			// TODO:  Make the below line more maintainable.
			int first = (type == Request.Type.Landing) ? 1 : 2;
			data.put(type, new ControllerData(first));
		}
	}


	public void simulateTimeSlot(int iterations, int timeSlot) {
		System.out.println(String.format(timeStr, timeSlot));
		for (int i = 0; i < iterations; i++) {
			for (Request.Type type : Request.Type.values()) {
				if (isTrue()) {
					Plane p = new Plane(data.get(type).getNextId(), new Request(timeSlot, type));
					System.out.println(String.format(planeStr, p.id, type.toString().toLowerCase()));
					data.get(type).push(p);
				}
			}
		}
	}
	
	
	private boolean isTrue() {
		return (Math.random() < 0.5);
	}


	private class ControllerData {
		private LinkedList<Plane> queue;
		private int nextId;


		private ControllerData(int firstId) {
			queue = new LinkedList<>();
			nextId = firstId;
		}


		private int getNextId() {
			int id = nextId;
			nextId += 2;
			return id;
		}


		private void push(Plane p) {
			queue.add(p);
		}


		private Plane pop() {
			return queue.removeFirst();
		}
	}
}