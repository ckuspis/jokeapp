package com.udacity.gradle.builditbigger;

import android.app.Instrumentation;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.fail;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    public final String TAG = "TESTING";
    @Test
    public void testAsyncResponse(){

        final CountDownLatch signal = new CountDownLatch(1);

        JokeResponseListener<String> testListener = new JokeResponseListener<String>() {

            @Override
            public void onSuccess(String object) {
                assertNotNull(object);
                assertFalse("Blank", TextUtils.isEmpty(object));
                Log.d(TAG, "onSuccess: " + object);
                signal.countDown();
            }

            @Override
            public void onFailure(Exception exception) {
                fail("failed to get joke from endpoint");
            }
        };

        AsyncJoke fetchjoke = new AsyncJoke(InstrumentationRegistry.getInstrumentation().getTargetContext(), testListener);
        fetchjoke.execute();

        try {
            signal.await();
        }
        catch (Exception e){
            fail("failed");
        }

    }
}