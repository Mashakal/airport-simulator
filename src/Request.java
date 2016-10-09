
public class Request {
	
	public static enum Status { Waiting, Fulfilled };
	public static enum Type { Landing, Takeoff };
	
	public static int numLandingRequestsStarted = 0;
	public static int numTakeoffRequestsStarted = 0;
	public static int numLandingRequestsFulfilled = 0;
	public static int numTakeoffRequestsFulfilled = 0;
	public static double avgLandingRequestTime = 0;
	public static double avgTakeoffRequestTime = 0;

	public Status status;
	public Type type;
	public int slotEntered;
	public int slotFulfilled;
	public int totalSlots;
	
	
	public Request(int timeSlot, Type type) {
		if (Type.Landing == type) {
			numLandingRequestsStarted += 1;
		} else {
			numTakeoffRequestsStarted += 1;
		}
		this.type = type;
		this.slotEntered = timeSlot;
	}
	

	public void fulfill(int timeSlot) {
		this.status = Status.Fulfilled;
		this.slotFulfilled = timeSlot;
		this.totalSlots = this.slotFulfilled - this.slotEntered;
		Request.addToAverage(this.type, this.totalSlots);
	}
	
	private static void addToAverage(Type type, int totalSlots) {
		double sum = totalSlots;
		
		if (Type.Landing == type) {
			sum += avgLandingRequestTime * numLandingRequestsFulfilled;
			numLandingRequestsFulfilled += 1;
			avgLandingRequestTime = sum / numLandingRequestsFulfilled;
		} else {
			sum += avgTakeoffRequestTime * numTakeoffRequestsFulfilled;
			numTakeoffRequestsFulfilled += 1;
			avgTakeoffRequestTime = sum / numTakeoffRequestsFulfilled;
		}
	}
	
	
	public static int numRequestsCompleted(Type type) {
		if (Type.Landing == type) {
			return numLandingRequestsFulfilled;
		}
		return numTakeoffRequestsFulfilled;
	}
	
	
	public static int numRequestsStarted(Type type) {
		if (Type.Landing == type) {
			return numLandingRequestsStarted;
		}
		return numTakeoffRequestsStarted;
	}
	
	
}
