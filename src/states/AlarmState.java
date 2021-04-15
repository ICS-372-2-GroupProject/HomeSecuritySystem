package states;

import events.AwayButtonEvent;
import events.CancelButtonEvent;
import events.MovementEvent;
import events.PasswordEvent;
import events.StayButtonEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import events.ZoneUnreadyEvent;
import events.ZonesReadyEvent;

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
 * Super class for all states
 * 
 *
 */
public abstract class AlarmState {

    // Fields for potential use to reduce redundant states.
    protected static final int AWAY_PROCESS = 0;
    protected static final int STAY_PROCESS = 1;

    /**
     * Initializes the state
     */
    public abstract void enter();

    /**
     * Performs any necessary clean up while leaving the state
     */
    public abstract void leave();

    /**
     * Process Away button request
     *
     */
    public void handleEvent(AwayButtonEvent event) {

    }

    /**
     * Process Stay button request
     * 
     */
    public void handleEvent(StayButtonEvent event) {

    }

    /**
     * Process Cancel button request
     *
     */
    public void handleEvent(CancelButtonEvent event) {

    }

    /**
     * Process movement detected request
     *
     */
    public void handleEvent(MovementEvent event) {

    }

    /**
     * Process correct password request
     *
     */
    public void handleEvent(PasswordEvent event) {

    }

    /**
     * Process all zones ready request
     *
     */
    public void handleEvent(ZonesReadyEvent event) {

    }

    /**
     * Process any zone unready request
     *
     */
    public void handleEvent(ZoneUnreadyEvent event) {

    }

    /**
     * Process timer runs out request
     *
     */
    public void handleEvent(TimerRanOutEvent event) {

    }

    /**
     * Process timer ticks request
     *
     */
    public void handleEvent(TimerTickedEvent event) {

    }

}
