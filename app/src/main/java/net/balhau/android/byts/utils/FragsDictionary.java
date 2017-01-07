package net.balhau.android.byts.utils;

import android.support.v4.app.Fragment;

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
    }),

    YOUTUBE(new Generator<Fragment>() {
        @Override
        public Fragment generate() {
            return new YoutubeFragment();
        }
    }),

    TORRENTS(new Generator<Fragment>() {
        @Override
        public Fragment generate() {
            return new TorrentsFragment();
        }
    });

    private Generator<Fragment> fragmentGenerator;

    private FragsDictionary(Generator<Fragment> fragmentGenerator){
        this.fragmentGenerator = fragmentGenerator;
    }

    public Fragment generate(){
        return this.fragmentGenerator.generate();
    }

}
