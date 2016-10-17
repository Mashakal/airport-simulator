import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AirportController {

	private static final int NUM_RUNWAYS = 2;
	private static final int TIME_SLOTS_TO_FULFILL = 3;
	private static final double CHANCE_FOR_REQUEST = 0.13;

	private static HashMap<Request.Type, ControllerData> data = new HashMap<>();
	private static AirportRunway[] runways = new AirportRunway[NUM_RUNWAYS];
	
	private static final String planeStr = "Plane #%d has entered the %s queue.";
	private static final String timeStr = "\tThe time is: %d";


	public AirportController() {
		for (Request.Type type : Request.Type.values()) {
			// TODO:  Make the below line more maintainable.
			int first = (type == Request.Type.Landing) ? 1 : 2;
			data.put(type, new ControllerData(first));
		}

		for (int i = 0; i < NUM_RUNWAYS; i++) {
			runways[i] = new AirportRunway(TIME_SLOTS_TO_FULFILL);
		}
	}


	public void simulateTimeSlot(int iterations, int timeSlot) {
		System.out.println(String.format(timeStr, timeSlot));

		// Handle incoming requests.
		for (int i = 0; i < iterations; i++) {
			for (Request.Type type : Request.Type.values()) {
				if (isTrue()) {
					Plane p = new Plane(data.get(type).getNextId(), new Request(timeSlot, type));
					System.out.println(String.format(planeStr, p.id, type.toString().toLowerCase()));
					data.get(type).queue.addLast(p);
				}
			}
		}

		// Work the next requests.
		for (AirportRunway runway : runways) {
			runway.incrementTimeSlot();
			if (runway.isPlaneComplete()) {
				Plane p = runway.releasePlane();
				p.request.fulfill(timeSlot);
				clearNextPlane(runway);
			} else if (!runway.hasPlane()) {
				clearNextPlane(runway);
			}
		}

	}
	
	private boolean isTrue() {
		return (Math.random() <= CHANCE_FOR_REQUEST);
	}

	private static Plane getNextPlane() {
		Plane p;

		// Landing requests are to be fulfilled first.
		p = planeFromQueue(Request.Type.Landing);
		if (p != null) {
			return p;
		}

		p = planeFromQueue(Request.Type.Takeoff);
		if (p != null) {
			return p;
		}

		return null;
	}

	private static Plane planeFromQueue(Request.Type type) {
		try {
			return data.get(type).queue.removeFirst();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	private static void clearNextPlane(AirportRunway runway) {
		Plane p = getNextPlane();
		if (p != null) {
			runway.assignPlane(p);
		}
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
	}
}