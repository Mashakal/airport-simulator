import java.util.LinkedList;

public class AirportController {
	
	private LinkedList<Plane> landingQueue;
	private LinkedList<Plane> takeoffQueue;
	
	private int nextTakeoffId = 2;
	private int nextLandingId = 3;
	
	private static final String planeStr = "Plane #%d has entered the %s queue.";
	private static final String timeStr = "The time is: %d";
	
	
	public AirportController() {
		this.landingQueue = new LinkedList<Plane>();
		this.takeoffQueue = new LinkedList<Plane>();
	}
	

	public void simulateTimeSlot(int numTakeoff, int numLanding, int timeSlot) {
		// Handle new requests.
		System.out.println(String.format(timeStr, timeSlot));
		Request.Type requestType = Request.Type.Takeoff;
		for (int i = 0; i < numTakeoff; i++) {
			if (isTrue()) {
				// A new takeoff request is to be made.
				Plane p = new Plane(nextTakeoffId, new Request(timeSlot, requestType));
				System.out.println(String.format(planeStr, nextTakeoffId, "takeoff"));
				nextTakeoffId += 2;
				takeoffQueue.add(p);
			}
		}
	}
	
	
	private boolean isTrue() {
		double r = Math.random();
		if (r < 0.5) {
			return false;
		}
		return true;
	}
}