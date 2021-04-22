package states;

import events.PasswordEvent;
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
 * Represents the alarm warning state
 *
 */
public class WarningState extends AlarmState implements Notifiable {
	private static WarningState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private WarningState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static WarningState instance() {
		if (instance == null) {
			instance = new WarningState();
		}
		return instance;
	}

	/**
	 * Process movement warning request
	 */
	@Override
	public void handleEvent(PasswordEvent event) {
//		AlarmContext.instance().showTimeLeft(0);
		if (AlarmContext.instance().getZoneReadiness()) {
			AlarmContext.instance().changeState(ReadyState.instance());
		} else {

			AlarmContext.instance().changeState(UnarmedState.instance());
		}
	}

	/**
	 * Process clock tick event
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {
		AlarmContext.instance().showTimeLeft(timer.getTimeValue());

	}

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void handleEvent(TimerRanOutEvent event) {
		AlarmContext.instance().showTimeLeft(0);
		AlarmContext.instance().changeState(BreachedState.instance());

	}

	/**
	 * Initializes the state Adds itself as a listener to managers Updates the
	 * displays
	 * 
	 */
	@Override
	public void enter() {
		AlarmContext.instance().warningOfButton();
		timer = new Timer(this, 15);
		AlarmContext.instance().showTimeLeft(timer.getTimeValue());

	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
//		AlarmContext.instance().showTimeLeft(0);

	}

}