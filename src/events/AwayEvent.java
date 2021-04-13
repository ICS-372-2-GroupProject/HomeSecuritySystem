package events;

/**
 * Represents the door close operation
 *
 */
public class AwayEvent extends AlarmEvent {
    private static AwayEvent instance;

    /**
     * Private for singleton
     * 
     */
    private AwayEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static AwayEvent instance() {
        if (instance == null) {
            instance = new AwayEvent();
        }
        return instance;
    }
}