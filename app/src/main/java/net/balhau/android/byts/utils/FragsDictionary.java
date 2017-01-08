package net.balhau.android.byts.utils;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;

import net.balhau.android.byts.R;
import net.balhau.android.byts.fragments.TorrentsFragment;
import net.balhau.android.byts.fragments.YoutubeFragment;
import net.balhau.android.byts.fragments.YtsFragment;


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
    },R.drawable.ic_torrents);

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
