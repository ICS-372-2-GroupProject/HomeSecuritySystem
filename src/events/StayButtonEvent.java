package events;

/**
 * Represents the operation for pushing the Stay button.
 *
 */
public class StayButtonEvent extends AlarmEvent {
    private static StayButtonEvent instance;

    /**
     * Private for singleton
     * 
     */
    private StayButtonEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static StayButtonEvent instance() {
        if (instance == null) {
            instance = new StayButtonEvent();
        }
        return instance;
    }
}