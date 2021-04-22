package states;

import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

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
 * Represents the Stay arming state
 *
 */
public class StayArmingState extends AlarmState implements Notifiable {
	private static StayArmingState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private StayArmingState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static StayArmingState instance() {
		if (instance == null) {
			instance = new StayArmingState();
		}
		return instance;
	}

	/**
	 * Initializes the state Adds itself as a listener to managers Updates the
	 * displays
	 * 
	 */
	@Override
	public void enter() {
		AlarmContext.instance().armingStayOfButton();
		timer = new Timer(this, 10);
		AlarmContext.instance().showTimeStay(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		AlarmContext.instance().showTimeStay(0);
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		AlarmContext.instance().showTimeStay(timer.getTimeValue());

	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		AlarmContext.instance().showTimeStay(0);
		if (AlarmContext.instance().getZoneReadiness()) {
			AlarmContext.instance().changeState(StayArmedState.instance());
		} else {
			AlarmContext.instance().changeState(UnarmedState.instance());
		}
	}

}