package states;

import events.AwayButtonEvent;
import events.StayButtonEvent;
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
 * Represents the alarm ready state. Modified from instructional code given by
 * Brahma Dathan.
 *
 */
public class ReadyState extends AlarmState {
    private static ReadyState instance;

    /**
     * Private constructor for the singleton pattern
     */
    private ReadyState() {
    }

    /**
     * Returns the instance
     * 
     * @return this object
     */
    public static ReadyState instance() {
        if (instance == null) {
            instance = new ReadyState();
        }
        return instance;
    }

    /**
     * Process the Away button request
     */
    @Override
    public void handleEvent(AwayButtonEvent event) {
        AlarmContext.instance().changeState(AwayArmingState.instance());
    }

    /**
     * Process the Stay button request
     */
    @Override
    public void handleEvent(StayButtonEvent event) {
        AlarmContext.instance().changeState(StayArmingState.instance());
    }

    /**
     * Process request when a zone is unready.
     */
    @Override
    public void handleEvent(ZonesUnreadyEvent event) {
        AlarmContext.instance().changeState(UnarmedState.instance());
    }

    /**
     * Initializes the state.
     */
    @Override
    public void enter() {
        AlarmContext.instance().showReady();
    }

    @Override
    public void leave() {
    }

}