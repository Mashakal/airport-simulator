

public class AirportRunway {
	
	public boolean isActive;
	public Plane plane;
	
	// Constructor.
	public AirportRunway() {
		this.isActive = false;
		
	}
	
	// Methods.
	public void assignPlane(Plane p) {
		this.plane = p;
	}
	
	public Plane releasePlane() {
		if (this.plane != null) {
			Plane p = this.plane;
			this.plane = null;
			return p;
		}
		return null;
	}
	
		
}
