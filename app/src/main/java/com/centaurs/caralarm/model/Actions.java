package com.centaurs.caralarm.model;


import com.centaurs.caralarm.model.entities.CurrentStateSingleton;

import static com.centaurs.caralarm.model.constants.TransitionsConstants.*;

/**
 * Actions
 * The events that cause state transitions.
 */
public class Actions {
    private CurrentStateSingleton mCurrentStateSingleton;

    public Actions(){
        mCurrentStateSingleton = CurrentStateSingleton.getCurrentStateSingleton();
    }

    public void setCurrentStateSingleton(CurrentStateSingleton currentStateSingleton) {
        mCurrentStateSingleton = currentStateSingleton;
    }

    public boolean lock(){
        boolean resultOfAction = true;
        closeState(mCurrentStateSingleton.getStateObjectJsonString());
        if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_ALL_UNLOCKED)){
            startState(ALARM_DISARMED_ALL_LOCKED);
        } else if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_ALL_LOCKED)){
            startState(ALARM_ARMED_ALL_LOCKED);
        } else if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_DRIVER_UNLOCKED)){
            startState(ALARM_DISARMED_ALL_LOCKED);
        } else {
            resultOfAction = false;
        }
        return resultOfAction;
    }

    public boolean unlock(){
        boolean resultOfAction = true;
        closeState(mCurrentStateSingleton.getStateObjectJsonString());
        if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_ALL_LOCKED)){
            startState(ALARM_DISARMED_DRIVER_UNLOCKED);
        } else if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_ARMED_ALL_LOCKED)){
            startState(ALARM_DISARMED_DRIVER_UNLOCKED);
        } else {
            resultOfAction = false;
        }
        return resultOfAction;
    }

    public boolean lockX2(){
        boolean resultOfAction = true;
        closeState(mCurrentStateSingleton.getStateObjectJsonString());
        if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_ALL_UNLOCKED)){
            startState(ALARM_ARMED_ALL_LOCKED);
        } else if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_ALL_LOCKED)){
            startState(ALARM_ARMED_ALL_LOCKED);
        } else if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_DRIVER_UNLOCKED)){
            startState(ALARM_ARMED_ALL_LOCKED);
        } else {
            resultOfAction = false;
        }
        return resultOfAction;
    }

    public boolean unlockX2(){
        boolean resultOfAction = true;
        closeState(mCurrentStateSingleton.getStateObjectJsonString());
        if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_ALL_LOCKED)){
            startState(ALARM_DISARMED_ALL_UNLOCKED);
        } else if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_ARMED_ALL_LOCKED)){
            startState(ALARM_DISARMED_ALL_UNLOCKED);
        } else {
            resultOfAction = false;
        }
        return resultOfAction;
    }

    /**
     * startState(String state)
     * starts new state, you can do here all you need to start current state
     * @param state - new state (JSON)
     */
    private void startState(String state){
        if (state.equals(ALARM_DISARMED_ALL_UNLOCKED)){
            //do all you need to start current state;
        } else if (state.equals(ALARM_DISARMED_ALL_LOCKED)){
            //do all you need to start current state;
        } else if (state.equals(ALARM_ARMED_ALL_LOCKED)){
            //do all you need to start current state;
        } else if (state.equals(ALARM_DISARMED_DRIVER_UNLOCKED)){
            //do all you need to start current state;
        }
        mCurrentStateSingleton.setStateObjectJsonString(state);
    }

    /**
     * closeState(String state)
     * closes current state, you can do here all you need to close current state
     * @param state - current state (JSON)
     */
    private void closeState(String state){
        if (state.equals(ALARM_DISARMED_ALL_UNLOCKED)){
            //do all you need to close current state;
        } else if (state.equals(ALARM_DISARMED_ALL_LOCKED)){
            //do all you need to close current state;
        } else if (state.equals(ALARM_ARMED_ALL_LOCKED)){
            //do all you need to close current state;
        } else if (state.equals(ALARM_DISARMED_DRIVER_UNLOCKED)){
            //do all you need to close current state;
        }
    }
}
