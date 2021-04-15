package display;

public interface AlarmDisplay {

	/**
	 * Displays the time remaining to enter password
	 * 
	 * @param time
	 *            remaining time
	 */
	public void showTimeLeft(int time);

	/**
	 * Indicate that the light is on
	 */
	void showAway();

}
