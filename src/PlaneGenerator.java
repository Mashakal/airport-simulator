

public class PlaneGenerator {
	
	private int takeoffIndex = 0;
	private int landingIndex = 0;

	public PlaneGenerator() {
		
	}
	
	public Plane generatePlane() {
		if (isTrue()) {
			return new Plane();
		}
		return null;
	}
	
	private boolean isTrue() {
		double r = Math.random();
		if (r < 0.5) {
			return false;
		}
		return true;
	}
}


