package states;

import display.AlarmDisplay;
import events.AwayEvent;

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
	 * @param display
	 *            The current display object
	 */
	public void setDisplay(AlarmDisplay display) {
		this.display = display;
	}

	/**
	 * Lets Unarmed state be the starting state adds the object as an observable
	 * for clock
	 */
	public void initialize() {
		instance.changeState(UnarmedState.instance());
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeState(AlarmState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void handleEvent(AwayEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * This invokes the right method of the display. This helps protect the
	 * states from changes to the way the system utilizes the state changes.
	 * 
	 * @param time
	 *            time left for cooking
	 */
	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

	/**
	 * @param time
	 *            time left for cooking
	 */
	public void showAway() {
		display.showAway();
	}

	// There were several more methods in MicrowaveContext that will probably be
	// needed in here.
	// Right now I'm just trying to get the GUI to display...

}