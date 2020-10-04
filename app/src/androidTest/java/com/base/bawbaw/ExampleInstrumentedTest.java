package com.base.bawbaw;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.base.bawbaw", appContext.getPackageName());
    }

    @Test
    public void testDes1(){
        onView(withId(R.id.EXPeditTextTextPersonName3)).perform(typeText("doc"));

    }

    @Test
    public void testDes2(){
        onView(withId(R.id.EXPeditTextTextPersonName4)).perform(typeText("vaccine"));
    }

    @Test
    public void testDes3(){
        onView(withId(R.id.EXPeditTextTextPersonName5)).perform(typeText("transport"));
    }

    @Test
    public void testDes4(){
        onView(withId(R.id.EXPeditTextTextPersonName6)).perform(typeText("X-ray"));
    }

    @Test
    public void testDes5(){
        onView(withId(R.id.EXPeditTextTextPersonName7)).perform(typeText("food"));
    }
}