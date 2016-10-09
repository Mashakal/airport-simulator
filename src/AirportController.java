import java.util.LinkedList;

public class AirportController {
	
	private PlaneGenerator planeGenerator;
	private LinkedList<Plane> landingQueue;
	private LinkedList<Plane> takeoffQueue;
	
	
	public AirportController() {
		this.planeGenerator = new PlaneGenerator();
		this.landingQueue = new LinkedList<Plane>();
		this.takeoffQueue = new LinkedList<Plane>();
	}
	

	public void simulateTimeSlot(int numTakeoff, int numLanding) {
		
	}
	
}