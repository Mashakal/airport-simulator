

public class AirportSimulation {

	public static void main(String[] args) {
		int MINUTES_PER_TIME_SLOT = 5;
		int MINUTES_TO_SIMULATE = 240;
		int POSSIBLE_REQUESTS_PER_TIME_SLOT = 3;

//		test_Request();
//		test_enum_printing();
		
		AirportController controller = new AirportController();

		int iterations = MINUTES_TO_SIMULATE / MINUTES_PER_TIME_SLOT;
		for (int i = 0; i < iterations; i++) {
			controller.simulateTimeSlot(POSSIBLE_REQUESTS_PER_TIME_SLOT, i);
		}
		
	}
	
	
	private static void test_Request() {
		Request takeoffRequest = new Request(5, Request.Type.Takeoff);
		Request landingRequest = new Request(4, Request.Type.Landing);

		System.out.println(Request.statistics.countStarted(Request.Type.Takeoff));
		System.out.println(Request.statistics.countCompleted(Request.Type.Takeoff));
		System.out.println(Request.statistics.countStarted(Request.Type.Landing));
		System.out.println(Request.statistics.countCompleted(Request.Type.Landing));
		
		takeoffRequest.fulfill(8);
		landingRequest.fulfill(9);
		
		takeoffRequest = new Request(7, Request.Type.Takeoff);
		landingRequest = new Request(6, Request.Type.Landing);

		takeoffRequest.fulfill(11);
		landingRequest.fulfill(10);
		
		System.out.println(Request.statistics.averageTime(Request.Type.Takeoff));
		System.out.println(Request.statistics.averageTime(Request.Type.Landing));
	}


	private static void test_enum_printing() {
		Request.Type type = Request.Type.Landing;
		System.out.println(type);
		System.out.println(type.toString());
		System.out.println(type.toString().toLowerCase());
	}
}
