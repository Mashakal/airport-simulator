
public class Clock {

    private static int minutesPerSlot;
    private int hour;
    private int minute;

    public Clock(int startHour, int startMinute, int minutesPerSlot) {
        hour = startHour;
        minute = startMinute;
        Clock.minutesPerSlot = minutesPerSlot;
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

    public static String durationFromSlots(int slots) {
        int totalMinutes = slots * minutesPerSlot;
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        return String.format("%d hours and %d minutes.", hours, minutes);
    }

    public static String durationFromSlots(double slots) {
        double totalMinutes = slots * minutesPerSlot;
        int hours = (int) totalMinutes / 60;
        double minutes = totalMinutes % 60;
        return String.format("%d hours %.2f minutes.", hours, minutes);
    }
}
