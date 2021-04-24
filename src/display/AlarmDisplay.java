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

	public void showAway();

	public void showStay();

	public boolean checkZones();

	public boolean enterPassword(int number);

	public void showSecurityBreached();

	public void showTimeAway(int time);

	public void showTimeStay(int time);

	public void showEnterPwdDisarm();

	public void readyOfButton();

	public void armingAwayOfButton();

	public void armingStayOfButton();

	public void armedStayOfButton();

	public void armedAwayOfButton();

	public void disarmAwayOfButton();

	public void disarmStayOfButton();

	public void warningOfButton();

	public void breachedOfButton();

	public void unarmedOfButton();

}
