


public class Request {
	
	public static enum Type { Landing, Takeoff };
	public static enum Status { Waiting, Fulfilled };
		
	private static int numLandingRequests = 0;
	private static int numTakeoffRequests = 0;
	
	public Type type;
	public Status status;
	public String timeEntered;
	public String timeFulfilled;
	public String totalTime;
	
	
	public Request(Type type, String time) {
		if (type == Type.Landing) {
			Request.numLandingRequests += 1;
		} else {
			Request.numTakeoffRequests += 1;
		}
		
		this.type = type;
		this.timeEntered = time;
	}
	

	public Request fulfill(String time) {
		this.timeFulfilled = time;
		this.status = Status.Fulfilled;
		// Calculate the total time.
		return this;
	}
	
	
	public static int totalLandingRequests() {
		return Request.numLandingRequests;
	}
	
	
	public static int totalTakeoffRequests() {
		return Request.numTakeoffRequests;
	}
}
