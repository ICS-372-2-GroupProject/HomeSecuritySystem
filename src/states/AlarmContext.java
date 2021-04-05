package states;

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
	private static AlarmContext instance;

	/**
	 * Make it a singleton
	 */
	private AlarmContext() {
		instance = this;
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

	// There were several more methods in MicrowaveContext that will probably be
	// needed in here.
	// Right now I'm just trying to get the GUI to display...

}