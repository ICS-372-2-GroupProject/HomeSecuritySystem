package events;

/**
 * Represents the operation for pushing the Away button.
 *
 */
public class AwayButtonEvent extends AlarmEvent {
    private static AwayButtonEvent instance;

    /**
     * Private for singleton
     * 
     */
    private AwayButtonEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static AwayButtonEvent instance() {
        if (instance == null) {
            instance = new AwayButtonEvent();
        }
        return instance;
    }
}