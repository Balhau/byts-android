package net.balhau.android.byts.utils;

import android.support.v4.app.Fragment;

import net.balhau.android.byts.R;
import net.balhau.android.byts.fragments.mainpanel.TorrentsFragment;
import net.balhau.android.byts.fragments.mainpanel.TrackerFragment;
import net.balhau.android.byts.fragments.mainpanel.YoutubeFragment;
import net.balhau.android.byts.fragments.mainpanel.YtsFragment;


/**
 * Utility class for building of fragments
 */
public enum FragsDictionary {

    YTS(new Generator<Fragment>() {
        @Override
        public Fragment generate() {
            return new YtsFragment();
        }
    },R.drawable.ic_yts),

    YOUTUBE(new Generator<Fragment>() {
        @Override
        public Fragment generate() {
            return new YoutubeFragment();
        }
    },R.drawable.ic_youtube),

    TORRENTS(new Generator<Fragment>() {
        @Override
        public Fragment generate() {
            return new TorrentsFragment();
        }
    },R.drawable.ic_torrents),

    TRACKER(new Generator<Fragment>() {
        @Override
        public Fragment generate() {
            return new TrackerFragment();
        }
    },R.drawable.ic_tracker);

    private Generator<Fragment> fragmentGenerator;
    private int iconid;

    private FragsDictionary(Generator<Fragment> fragmentGenerator, int iconid){
        this.fragmentGenerator = fragmentGenerator;
        this.iconid=iconid;
    }

    public int getIconId(){
        return this.iconid;
    }

    public Fragment generate(){
        return this.fragmentGenerator.generate();
    }

}
