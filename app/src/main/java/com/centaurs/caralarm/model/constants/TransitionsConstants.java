package com.centaurs.caralarm.model.constants;


import com.centaurs.caralarm.model.entities.State;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * TransitionsConstants
 * The possible changes in states.
 */
public class TransitionsConstants {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    public final static String ALARM_DISARMED_ALL_UNLOCKED = gson.toJson(new State(false, false, false));
    public final static String ALARM_DISARMED_ALL_LOCKED = gson.toJson(new State(false, true, true));
    public final static String ALARM_ARMED_ALL_LOCKED = gson.toJson(new State(true, true, true));
    public final static String ALARM_DISARMED_DRIVER_UNLOCKED = gson.toJson(new State(false, true, false));
}
