package events;

/**
 * Represents the operation for pushing the Cancel button.
 *
 */
public class CancelButtonEvent extends AlarmEvent {
    private static CancelButtonEvent instance;

    /**
     * Private for singleton
     * 
     */
    private CancelButtonEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static CancelButtonEvent instance() {
        if (instance == null) {
            instance = new CancelButtonEvent();
        }
        return instance;
    }
}