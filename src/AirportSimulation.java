

public class AirportSimulation {
	
	private static int MINUTES_PER_TIME_SLOT = 5;
	private static int MINUTES_TO_SIMULATE = 120;

	public static void main(String[] args) {
		// test_Request();
		
		AirportController controller = new AirportController();
		
		int iterations = MINUTES_TO_SIMULATE / MINUTES_PER_TIME_SLOT;
		for (int i = 0; i < iterations; i++) {
			controller.simulateTimeSlot(3, 3, i);
		}
		
	}
	
	
	private static void test_Request() {
		Request takeoffRequest = new Request(5, Request.Type.Takeoff);
		Request landingRequest = new Request(4, Request.Type.Landing);
		
		System.out.println(Request.numRequestsCompleted(Request.Type.Landing));
		System.out.println(Request.numRequestsStarted(Request.Type.Landing));
		System.out.println(Request.numRequestsCompleted(Request.Type.Takeoff));
		System.out.println(Request.numRequestsStarted(Request.Type.Takeoff));
		
		takeoffRequest.fulfill(8);
		landingRequest.fulfill(9);
		
		takeoffRequest = new Request(7, Request.Type.Takeoff);
		landingRequest = new Request(6, Request.Type.Landing);
		
		takeoffRequest.fulfill(11);
		landingRequest.fulfill(10);
		
		System.out.println(Request.avgTakeoffRequestTime);
		System.out.println(Request.avgLandingRequestTime);
	}
	
}
