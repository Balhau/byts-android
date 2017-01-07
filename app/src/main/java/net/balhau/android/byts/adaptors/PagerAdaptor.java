package net.balhau.android.byts.adaptors;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.balhau.android.byts.utils.FragsDictionary;

/**
 * Adaptor for the viewpager mechanism that depends on the {@link FragsDictionary} enumerated stuff
 *
 */

public class PagerAdaptor extends FragmentStatePagerAdapter {

    public PagerAdaptor(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragsDictionary.values()[position].generate();
    }

    @Override
    public int getCount() {
        return FragsDictionary.values().length;
    }
}
