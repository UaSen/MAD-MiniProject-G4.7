package com.base.bawbaw;

import com.base.bawbaw.exec.BmiExec;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private BmiExec bmiExec;

    @Before
    public void setup(){
        bmiExec = new BmiExec();
    }

    @Test
    public void bmi_isCorrect() {

        float textview1 = bmiExec.calculateBmi(45,30);
        assertEquals(500,textview1, 0.1);

    }
}