package net.balhau.android.byts;

import android.net.Uri;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import net.balhau.android.byts.data.YtsContract;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(AndroidJUnit4.class)
public class YtsContractTest {
    @Test
    public void testBuildContract(){
        Uri torrentUri = YtsContract.ProviderEntry.buildLocationUri(12);
        Assert.assertNotNull(torrentUri);
        Assert.assertTrue(true);
    }
}
