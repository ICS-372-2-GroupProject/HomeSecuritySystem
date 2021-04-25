package states;

import events.CancelButtonEvent;
import events.MovementEvent;
import events.ZonesUnreadyEvent;
import timer.Notifiable;

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
 * Represents the Away armed state
 *
 */
public class AwayArmedState extends AlarmState implements Notifiable {
	private static AwayArmedState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private AwayArmedState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static AwayArmedState instance() {
		if (instance == null) {
			instance = new AwayArmedState();
		}
		return instance;
	}

	/**
	 * Process movement warning request
	 */
	@Override
	public void handleEvent(ZonesUnreadyEvent event) {
		AlarmContext.instance().changeState(WarningState.instance());
	}

	/**
	 * Process movement warning request
	 */
	@Override
	public void handleEvent(MovementEvent event) {
		AlarmContext.instance().changeState(WarningState.instance());
	}

	/**
	 * Process cancel button request
	 */
	@Override
	public void handleEvent(CancelButtonEvent event) {
		AlarmContext.instance().changeState(AwayDisarmState.instance());
	}

	@Override
	public void enter() {
		AlarmContext.instance().showAway();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}