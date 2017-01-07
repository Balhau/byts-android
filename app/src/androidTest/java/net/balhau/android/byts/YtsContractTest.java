package net.balhau.android.byts;

import android.net.Uri;

import junit.framework.Assert;
import junit.framework.TestCase;

import net.balhau.android.byts.data.YtsContract;

import org.junit.Test;

/**
 *
 */

public class YtsContractTest extends TestCase {



    @Test
    public void testBuildContract(){
        Uri torrentUri = YtsContract.TorrentEntry.buildLocationUri(12);
        assertNotNull(torrentUri);
        Assert.assertTrue(true);
    }
}
