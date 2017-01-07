package net.balhau.android.byts.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.balhau.android.byts.R;

/**
 * Class for Yify torrent fragment view
 */
public class YtsFragment extends Fragment {

    public YtsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_byts_main, container, false);
    }
}
