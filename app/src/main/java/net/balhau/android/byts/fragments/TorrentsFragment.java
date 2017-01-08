package net.balhau.android.byts.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.balhau.android.byts.R;

/**
 * Class for torrents fragment view
 *
 */

public class TorrentsFragment extends Fragment {
    public TorrentsFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View torrentsView = inflater.inflate(R.layout.fragment_byts_torrent,container,false);
        return torrentsView;
    }
}
