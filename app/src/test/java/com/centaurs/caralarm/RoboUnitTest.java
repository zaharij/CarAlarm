package com.centaurs.caralarm;

import android.widget.TextView;

import com.centaurs.caralarm.controller.CarKeylessEntrySystemActivity;
import com.centaurs.caralarm.model.Actions;
import com.centaurs.caralarm.model.entities.CurrentStateSingleton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.centaurs.caralarm.model.constants.TransitionsConstants.ALARM_ARMED_ALL_LOCKED;
import static com.centaurs.caralarm.model.constants.TransitionsConstants.ALARM_DISARMED_ALL_LOCKED;
import static com.centaurs.caralarm.model.constants.TransitionsConstants.ALARM_DISARMED_ALL_UNLOCKED;
import static com.centaurs.caralarm.model.constants.TransitionsConstants.ALARM_DISARMED_DRIVER_UNLOCKED;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, manifest = "AndroidManifest.xml", sdk = 19)
public class RoboUnitTest {
    private CarKeylessEntrySystemActivity mCarKeylessEntrySystemActivity;
    private Actions mActions;

    @Mock
    CurrentStateSingleton mStateAlarmDisarmedAllUnlocked;
    @Mock
    CurrentStateSingleton mStateAlarmDisarmedAllLocked;
    @Mock
    CurrentStateSingleton mStateAlarmArmedAllLocked;
    @Mock
    CurrentStateSingleton mStateAlarmDisarmedDriverUnlocked;

    @Before
    public void create(){
        mActions = new Actions();
        mCarKeylessEntrySystemActivity = Robolectric.buildActivity(CarKeylessEntrySystemActivity.class).create().get();
        MockitoAnnotations.initMocks(this);
        Mockito.when(mStateAlarmDisarmedAllUnlocked.getStateObjectJsonString()).thenReturn(ALARM_DISARMED_ALL_UNLOCKED);
        Mockito.when(mStateAlarmDisarmedAllLocked.getStateObjectJsonString()).thenReturn(ALARM_DISARMED_ALL_LOCKED);
        Mockito.when(mStateAlarmArmedAllLocked.getStateObjectJsonString()).thenReturn(ALARM_ARMED_ALL_LOCKED);
        Mockito.when(mStateAlarmDisarmedDriverUnlocked.getStateObjectJsonString()).thenReturn(ALARM_DISARMED_DRIVER_UNLOCKED);
    }

    @Test
    public void testView() throws Exception {
        Assert.assertNotNull(mCarKeylessEntrySystemActivity);
        TextView textView = (TextView) mCarKeylessEntrySystemActivity.findViewById(R.id.state_text_view);
        Assert.assertTrue(textView.getText().toString().equals(mCarKeylessEntrySystemActivity
                .getResources().getString(R.string.alarm_disarmed_all_unlocked_str)));
    }

    @Test
    public void testLockAction() throws Exception{
        mActions.setCurrentStateSingleton(mStateAlarmDisarmedAllUnlocked);
        Assert.assertTrue(mActions.lock());

        mActions.setCurrentStateSingleton(mStateAlarmDisarmedAllLocked);
        Assert.assertTrue(mActions.lock());

        mActions.setCurrentStateSingleton(mStateAlarmArmedAllLocked);
        Assert.assertFalse(mActions.lock());

        mActions.setCurrentStateSingleton(mStateAlarmDisarmedDriverUnlocked);
        Assert.assertTrue(mActions.lock());
    }

    @Test
    public void testUnockAction() throws Exception{
        mActions.setCurrentStateSingleton(mStateAlarmDisarmedAllUnlocked);
        Assert.assertFalse(mActions.unlock());

        mActions.setCurrentStateSingleton(mStateAlarmDisarmedAllLocked);
        Assert.assertTrue(mActions.unlock());

        mActions.setCurrentStateSingleton(mStateAlarmArmedAllLocked);
        Assert.assertTrue(mActions.unlock());

        mActions.setCurrentStateSingleton(mStateAlarmDisarmedDriverUnlocked);
        Assert.assertFalse(mActions.unlock());
    }

    @Test
    public void testLockX2Action() throws Exception{
        mActions.setCurrentStateSingleton(mStateAlarmDisarmedAllUnlocked);
        Assert.assertTrue(mActions.lockX2());

        mActions.setCurrentStateSingleton(mStateAlarmDisarmedAllLocked);
        Assert.assertTrue(mActions.lockX2());

        mActions.setCurrentStateSingleton(mStateAlarmArmedAllLocked);
        Assert.assertFalse(mActions.lockX2());

        mActions.setCurrentStateSingleton(mStateAlarmDisarmedDriverUnlocked);
        Assert.assertTrue(mActions.lockX2());
    }

    @Test
    public void testUnockX2Action() throws Exception{
        mActions.setCurrentStateSingleton(mStateAlarmDisarmedAllUnlocked);
        Assert.assertFalse(mActions.unlockX2());

        mActions.setCurrentStateSingleton(mStateAlarmDisarmedAllLocked);
        Assert.assertTrue(mActions.unlockX2());

        mActions.setCurrentStateSingleton(mStateAlarmArmedAllLocked);
        Assert.assertTrue(mActions.unlockX2());

        mActions.setCurrentStateSingleton(mStateAlarmDisarmedDriverUnlocked);
        Assert.assertFalse(mActions.unlockX2());
    }
}