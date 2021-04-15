package events;

/**
 * Represents the circumstance of all zones being ready
 *
 */
public class ZonesReadyEvent extends AlarmEvent {
    private static ZonesReadyEvent instance;

    /**
     * Private for singleton
     * 
     */
    private ZonesReadyEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static ZonesReadyEvent instance() {
        if (instance == null) {
            instance = new ZonesReadyEvent();
        }
        return instance;
    }
}