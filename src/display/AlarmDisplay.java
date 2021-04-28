package display;

public interface AlarmDisplay {

    /**
     * Displays the time remaining to enter password
     * 
     * @param time remaining time
     */
    public void showTimeLeft(int time);

    /**
     * Displays that the alarm cannot be armed until the zones are ready.
     */
    public void showNotReady();

    /**
     * Displays that the alarm can be armed.
     */
    public void showReady();

    /**
     * Displays that the alarm is armed as away.
     */
    public void showAway();

    /**
     * Displays that the alarm is armed as stay.
     */
    public void showStay();

    /**
     * Checks if zones are ready.
     */
    public boolean checkZones();

    /**
     * Displays if password is successful.
     * 
     * @param number digits entered through interface
     */
    public boolean enterPassword(int number);

    /**
     * Displays is alarm goes off.
     */
    public void showSecurityBreached();

    /**
     * Displays when away is arming.
     * 
     * @param time remaining time
     */
    public void showTimeAway(int time);

    /**
     * Displays when stay is arming.
     * 
     * @param time remaining time
     */
    public void showTimeStay(int time);

    /**
     * Displays prompt for password to cancel alarm.
     */
    public void showEnterPwdDisarm();

}
