package tv.limehd.adbumpdemo;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented lime_hd.html, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under lime_hd.html.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("tv.limehd.adbumpdemo", appContext.getPackageName());
    }
}