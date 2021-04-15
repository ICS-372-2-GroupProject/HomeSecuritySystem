package events;

/**
 * Represents the operation for entering the correct password
 *
 */
public class PasswordEvent extends AlarmEvent {
    private static PasswordEvent instance;

    /**
     * Private for singleton
     * 
     */
    private PasswordEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static PasswordEvent instance() {
        if (instance == null) {
            instance = new PasswordEvent();
        }
        return instance;
    }
}