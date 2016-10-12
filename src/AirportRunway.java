

public class AirportRunway {

	private static String s_IsFinished = "Plane #%d has finished with %s on runway #%d.";
	private static String s_IsCleared = "Plane #%d has been cleared for %s on runway #%d.";
	private static int nextRunwayId = 1;

	private final int timeSlotsToFulfill;
	private int activeSlotCount = 0;
	private final int runwayId;

	public Plane plane;


	public AirportRunway(int timeSlotsToFulfill) {
		this.timeSlotsToFulfill = timeSlotsToFulfill;
		this.runwayId = nextRunwayId;
		nextRunwayId++;
	}


	public void incrementTimeSlot() {
		if (hasPlane()) {
			this.activeSlotCount++;
		}
	}


	public boolean isPlaneComplete() {
		return (this.plane != null &&
				this.activeSlotCount == this.timeSlotsToFulfill);
	}


	public boolean hasPlane() {
		return (this.plane != null);
	}


	public void assignPlane(Plane p) {
		this.plane = p;
		this.activeSlotCount = 0;
		System.out.println(String.format(
				s_IsCleared, p.id,
				p.request.type.toString().toLowerCase(), runwayId));
	}


	public Plane releasePlane() {
		if (hasPlane() && isPlaneComplete()) {
			Plane p = this.plane;
			this.plane = null;
			System.out.println(String.format(
					s_IsFinished, p.id,
					p.request.type.toString().toLowerCase(), runwayId));
			return p;
		}
		return null;
	}


}
