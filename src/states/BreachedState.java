package states;

import events.PasswordEvent;

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
 * Represents the alarm breached state
 *
 */
public class BreachedState extends AlarmState {
	private static BreachedState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private BreachedState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static BreachedState instance() {
		if (instance == null) {
			instance = new BreachedState();
		}
		return instance;
	}

	/**
	 * Process movement warning request
	 */
	@Override
	public void handleEvent(PasswordEvent event) {
		if (AlarmContext.instance().getZoneReadiness()) {
			AlarmContext.instance().changeState(ReadyState.instance());
		} else {

			AlarmContext.instance().changeState(UnarmedState.instance());
		}
	}

	@Override
	public void enter() {
//		AlarmContext.instance().breachedOfButton();
		AlarmContext.instance().showSecurityBreached();

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}