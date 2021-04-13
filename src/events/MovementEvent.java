package events;

/**
 * Represents the door close operation
 *
 */
public class MovementEvent extends AlarmEvent {
    private static MovementEvent instance;

    /**
     * Private for singleton
     * 
     */
    private MovementEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static MovementEvent instance() {
        if (instance == null) {
            instance = new MovementEvent();
        }
        return instance;
    }
}