package events;

/**
 * Represents the door close operation
 *
 */
public class TimeoutEvent extends AlarmEvent {
    private static TimeoutEvent instance;

    /**
     * Private for singleton
     * 
     */
    private TimeoutEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static TimeoutEvent instance() {
        if (instance == null) {
            instance = new TimeoutEvent();
        }
        return instance;
    }
}