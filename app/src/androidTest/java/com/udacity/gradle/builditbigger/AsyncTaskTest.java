package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.task.AsyncResponse;
import com.udacity.gradle.builditbigger.task.EndpointsAsyncTask;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Byron on 9/6/2016.
 */


@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest extends AndroidTestCase implements AsyncResponse {

    Context appContext = InstrumentationRegistry.getContext();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testVerifyEchoResponse() throws Throwable {

        final EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(this , mActivityRule.getActivity());
        //need to use runOnUiThread because of ProgressDialog initialization
        mActivityRule.runOnUiThread(new Runnable(){
            public void run() {
                endpointsAsyncTask.execute();
            }
        });
    }

    //Since I have a delegate, I override the interface delegate and check the response here
    @Override
    public void processFinish(String output) {
        assertNotNull(output);
    }
}
