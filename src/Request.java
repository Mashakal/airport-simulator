

public class Request {
	
	public static enum Status { Waiting, Fulfilled }
	public static enum Type { Landing, Takeoff }

    public static RequestStatistics statistics = new RequestStatistics();
	
	public Status status;
	public Type type;
	public int slotEntered;
	public int slotFulfilled;
	public int totalSlots;
	
	
	public Request(int timeSlot, Type type) {
		this.type = type;
		this.slotEntered = timeSlot;
		this.status = Status.Waiting;
        statistics.tallyStart(type);
	}
	

	public void fulfill(int timeSlot) {
		this.status = Status.Fulfilled;
		this.slotFulfilled = timeSlot;
		this.totalSlots = this.slotFulfilled - this.slotEntered;
		statistics.tallyCompletion(this.type, this.totalSlots);
	}
	

}
