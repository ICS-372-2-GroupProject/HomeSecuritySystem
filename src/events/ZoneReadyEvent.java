package events;

/**
 * Represents the door close operation
 *
 */
public class ZoneReadyEvent extends AlarmEvent {
    private static ZoneReadyEvent instance;

    /**
     * Private for singleton
     * 
     */
    private ZoneReadyEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static ZoneReadyEvent instance() {
        if (instance == null) {
            instance = new ZoneReadyEvent();
        }
        return instance;
    }
}