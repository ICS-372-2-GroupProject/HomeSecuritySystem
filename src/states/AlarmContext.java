package states;

import display.AlarmDisplay;
import events.AwayButtonEvent;
import events.CancelButtonEvent;
import events.MovementEvent;
import events.PasswordEvent;
import events.StayButtonEvent;
import events.ZonesReadyEvent;
import events.ZonesUnreadyEvent;

/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

/**
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class AlarmContext {
	private AlarmDisplay display;
	private AlarmState currentState;
	private static AlarmContext instance;

	/**
	 * Make it a singleton
	 */
	private AlarmContext() {
		instance = this;
		currentState = UnarmedState.instance();
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static AlarmContext instance() {
		if (instance == null) {
			instance = new AlarmContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get its refrence.
	 * 
	 * @param display The current display object
	 */
	public void setDisplay(AlarmDisplay display) {
		this.display = display;
	}

	public boolean getZoneReadiness() {
		return display.checkZones();
	}

	public boolean enterPassword(int number) {
		return display.enterPassword(number);
	}

	/**
	 * Lets Unarmed state be the starting state adds the object as an observable for
	 * clock
	 */
	public void initialize() {
		instance.changeState(UnarmedState.instance());
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState the next state
	 */
	public void changeState(AlarmState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void handleEvent(AwayButtonEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(StayButtonEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PasswordEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(MovementEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(ZonesReadyEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(ZonesUnreadyEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(CancelButtonEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 * @param time time left for cooking
	 */
	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

	public void showTimeAway(int time) {
		display.showTimeAway(time);
	}

	public void showTimeStay(int time) {
		display.showTimeStay(time);
	}

	public void showNotReady() {
		display.showNotReady();
	}

	public void showReady() {
		display.showReady();
	}

	/**
	 * @param time time left for cooking
	 */
	public void showAway() {
		display.showAway();
	}

	public void showStay() {
		display.showStay();
	}

	public void showSecurityBreached() {
		display.showSecurityBreached();

	}

	public void showEnterPwdDisarm() {
		display.showEnterPwdDisarm();

	}

}