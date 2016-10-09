


public static class RequestHandler {
	
	public static enum Type { Landing, Takeoff };
	public static enum Status { Waiting, Fulfilled };
		
	private int numLandingRequests = 0;
	private int numTakeoffRequests = 0;
	
	
	public Request create(Type type, String time) {
		if (type == Type.Landing) {
			numLandingRequests += 1;
		} else {
			numTakeoffRequests += 1;
		}
		
		return new Request(type, time);
	}
	

	public Request satisfy(Request request, String time) {
		request.fulFill(time);
		return request;
	}
	
	
	class Request {
		
		
		public Type type;
		public Status status;
		public String timeEntered;
		public String timeFulfilled;
		
		
		public Request(Type type, String timeEntered) {
			this.type = type;
			this.status = Status.Waiting;
			this.timeEntered = timeEntered;
		}
		
		
		public void fulFill(String timeFulfilled) {
			this.status = Status.Fulfilled;
			this.timeFulfilled = timeFulfilled;
		}
		
	}
	
}
