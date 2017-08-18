package com.centaurs.caralarm.model.entities;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * CurrentStateSingleton
 * Current state (Singleton)
 */
public class CurrentStateSingleton {
    private static CurrentStateSingleton sCurrentStateSingleton;

    private GsonBuilder builder;
    private Gson gson;
    private String stateObjectJsonString;

    private CurrentStateSingleton(){
        builder = new GsonBuilder();
        gson = builder.create();
        stateObjectJsonString = gson.toJson(new State());
    }

    public static CurrentStateSingleton getCurrentStateSingleton(){
        if (sCurrentStateSingleton == null){
            sCurrentStateSingleton = new CurrentStateSingleton();
        }
        return sCurrentStateSingleton;
    }

    public String getStateObjectJsonString() {
        return stateObjectJsonString;
    }

    public void setStateObjectJsonString(String stateObjectJsonString) {
        this.stateObjectJsonString = stateObjectJsonString;
    }
}
