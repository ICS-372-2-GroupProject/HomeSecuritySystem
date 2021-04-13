package events;

/**
 * Represents the door close operation
 *
 */
public class ZoneUnreadyEvent extends AlarmEvent {
    private static ZoneUnreadyEvent instance;

    /**
     * Private for singleton
     * 
     */
    private ZoneUnreadyEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static ZoneUnreadyEvent instance() {
        if (instance == null) {
            instance = new ZoneUnreadyEvent();
        }
        return instance;
    }
}