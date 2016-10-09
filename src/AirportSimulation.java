

public class AirportSimulation {

	public static void main(String[] args) {
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
