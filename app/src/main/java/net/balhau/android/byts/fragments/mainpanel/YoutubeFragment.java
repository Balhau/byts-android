package net.balhau.android.byts.fragments.mainpanel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.balhau.android.byts.R;

/**
 * Class for youtube fragment view
 *
 */

public class YoutubeFragment extends Fragment {
    public YoutubeFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_byts_youtube,container,false);
    }
}
