import com.zero.androidtranningdemo.BuildConfig;
import com.zero.androidtranningdemo.MainActivity;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by allen on 2017/5/31.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    public void testSome() {
        Assert.assertNotNull(Robolectric.setupActivity(MainActivity.class));
    }
}
