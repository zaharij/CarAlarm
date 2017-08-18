package com.centaurs.caralarm.model.entities;

/**
 * State
 * A possible condition of the modeled system.
 */
public class State {
    private boolean isAlarmArmed;
    private boolean isAllLocked;
    private boolean isDriverLocked;

    public State(){
        this.isAlarmArmed = false;
        this.isAllLocked = false;
        this.isDriverLocked = false;
    }

    public State(boolean isAlarmArmed, boolean isAllLocked, boolean isDriverLocked) {
        this.isAlarmArmed = isAlarmArmed;
        this.isAllLocked = isAllLocked;
        this.isDriverLocked = isDriverLocked;
    }
}
