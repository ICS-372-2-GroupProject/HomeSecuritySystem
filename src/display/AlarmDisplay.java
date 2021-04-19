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

	public void showNotReady();

	public void showReady();

	void showAway();

	public boolean checkZones();

	public boolean enterPassword(int number);

}
