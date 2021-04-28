package states;

import events.CancelButtonEvent;
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
 * Represents the Stay armed state. Modified from instructional code given by
 * Brahma Dathan.
 *
 */
public class StayArmedState extends AlarmState {
    private static StayArmedState instance;

    /**
     * Private constructor for the singleton pattern
     */
    private StayArmedState() {
    }

    /**
     * Returns the instance
     * 
     * @return this object
     */
    public static StayArmedState instance() {
        if (instance == null) {
            instance = new StayArmedState();
        }
        return instance;
    }

    /**
     * Process Cancel button request
     */
    @Override
    public void handleEvent(CancelButtonEvent event) {
        AlarmContext.instance().changeState(StayDisarmState.instance());
    }

    /**
     * Process zone unready warning request
     */
    @Override
    public void handleEvent(ZonesUnreadyEvent event) {
        AlarmContext.instance().changeState(BreachedState.instance());
    }

    /**
     * Initialize the state
     */
    @Override
    public void enter() {
        AlarmContext.instance().showStay();

    }

    @Override
    public void leave() {
    }

}