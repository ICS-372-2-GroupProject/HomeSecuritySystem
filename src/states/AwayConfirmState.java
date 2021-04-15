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
 * Represents the Away confirm state
 *
 */
public class AwayConfirmState extends AlarmState {
    private static AwayConfirmState instance;

    /**
     * Private constructor for the singleton pattern
     */
    private AwayConfirmState() {
    }

    /**
     * returns the instance
     * 
     * @return this object
     */
    public static AwayConfirmState instance() {
        if (instance == null) {
            instance = new AwayConfirmState();
        }
        return instance;
    }

    @Override
    public void enter() {
        // TODO Auto-generated method stub

    }

    @Override
    public void leave() {
        // TODO Auto-generated method stub

    }

}