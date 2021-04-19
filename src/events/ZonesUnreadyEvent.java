package events;

/**
 * Represents the circumstance of any zone being unready
 *
 */
public class ZonesUnreadyEvent extends AlarmEvent {
	private static ZonesUnreadyEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private ZonesUnreadyEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static ZonesUnreadyEvent instance() {
		if (instance == null) {
			instance = new ZonesUnreadyEvent();
		}
		return instance;
	}
}