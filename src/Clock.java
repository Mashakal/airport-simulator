
public class Clock {

    private final int minutesPerSlot;
    private int hour;
    private int minute;

    public Clock(int startHour, int startMinute, int minutesPerSlot) {
        hour = startHour;
        minute = startMinute;
        this.minutesPerSlot = minutesPerSlot;
    }


    public void increment() {
        minute += minutesPerSlot;
        if (minute >= 60) {
            hour += 1;
            minute = minute % 60;
        }
    }

    @Override

    public String toString() {
        return hour + ":" + (minute < 10 ? "0" + minute : minute);
    }

}
