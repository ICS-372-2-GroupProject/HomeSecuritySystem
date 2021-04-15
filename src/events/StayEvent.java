package events;

/**
 * Represents the operation for pushing the Stay button.
 *
 */
public class StayEvent extends AlarmEvent {
    private static StayEvent instance;

    /**
     * Private for singleton
     * 
     */
    private StayEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static StayEvent instance() {
        if (instance == null) {
            instance = new StayEvent();
        }
        return instance;
    }
}