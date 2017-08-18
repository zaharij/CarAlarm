package com.centaurs.caralarm.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.centaurs.caralarm.R;
import com.centaurs.caralarm.model.Actions;
import com.centaurs.caralarm.model.entities.CurrentStateSingleton;

import static com.centaurs.caralarm.model.constants.TransitionsConstants.*;

public class CarKeylessEntrySystemActivity extends AppCompatActivity{
    private Button lockButton, unlockButton, lockX2Button, unlockX2Button;
    private ImageView alarmIndicatorImageView;
    private TextView stateTextView;
    private Actions mStateTransitions;
    private CurrentStateSingleton mCurrentStateSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_keyless_entry_system);

        mStateTransitions = new Actions();
        mCurrentStateSingleton = CurrentStateSingleton.getCurrentStateSingleton();

        lockButton = (Button) findViewById(R.id.lock_button);
        lockButton.setOnClickListener(mOnClickListenerButton);
        unlockButton = (Button) findViewById(R.id.unlock_button);
        unlockButton.setOnClickListener(mOnClickListenerButton);
        lockX2Button = (Button) findViewById(R.id.lock_x2_button);
        lockX2Button.setOnClickListener(mOnClickListenerButton);
        unlockX2Button = (Button) findViewById(R.id.unlock_x2_button);
        unlockX2Button.setOnClickListener(mOnClickListenerButton);

        alarmIndicatorImageView = (ImageView) findViewById(R.id.alarm_state_indicator_image_view);

        stateTextView = (TextView) findViewById(R.id.state_text_view);

        setResultInfoToView();
    }

    private View.OnClickListener mOnClickListenerButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.lock_button:
                    mStateTransitions.lock();
                    break;
                case R.id.unlock_button:
                    mStateTransitions.unlock();
                    break;
                case R.id.lock_x2_button:
                    mStateTransitions.lockX2();
                    break;
                case R.id.unlock_x2_button:
                    mStateTransitions.unlockX2();
                    break;
            }
            setResultInfoToView();
        }
    };

    private void setResultInfoToView(){
        if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_ALL_UNLOCKED)){
            alarmIndicatorImageView.setBackgroundColor(getResources().getColor(R.color.alarm_disarmed_indicator));
            stateTextView.setText(R.string.alarm_disarmed_all_unlocked_str);
        } else if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_ALL_LOCKED)){
            alarmIndicatorImageView.setBackgroundColor(getResources().getColor(R.color.alarm_disarmed_indicator));
            stateTextView.setText(R.string.alarm_disarmed_all_locked_str);
        } else if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_ARMED_ALL_LOCKED)){
            alarmIndicatorImageView.setBackgroundColor(getResources().getColor(R.color.alarm_armed_indicator));
            stateTextView.setText(R.string.alarm_armed_all_locked_str);
        } else if (mCurrentStateSingleton.getStateObjectJsonString().equals(ALARM_DISARMED_DRIVER_UNLOCKED)){
            alarmIndicatorImageView.setBackgroundColor(getResources().getColor(R.color.alarm_disarmed_indicator));
            stateTextView.setText(R.string.alarm_disarmed_driver_unlocked_str);
        }
    }
}
