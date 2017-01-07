package net.balhau.android.byts.adaptors;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Adaptor for the viewpager mechanism
 */

public class PagerAdaptor extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdaptor(FragmentManager fm, int numberOfTabs){
        super(fm);
        this.numberOfTabs=numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
