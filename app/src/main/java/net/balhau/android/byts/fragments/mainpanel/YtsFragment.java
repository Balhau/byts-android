package net.balhau.android.byts.fragments.mainpanel;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import net.balhau.android.byts.R;
import net.balhau.android.byts.adaptors.YtsMovieArrayAdapter;
import net.balhau.android.byts.adaptors.domain.yts.YtsEntry;
import net.balhau.android.byts.adaptors.domain.yts.YtsPageResponse;
import net.balhau.android.byts.adaptors.listeners.OnScrollInfiniteListener;
import net.balhau.android.byts.adaptors.tasks.YtsMovieUpdateTask;
import net.balhau.android.byts.utils.Generator;

import java.util.ArrayList;

/**
 * Class for Yify torrent fragment view
 */
public class YtsFragment extends Fragment{

    private YtsMovieUpdateTask updateTask;

    public YtsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ytsView= inflater.inflate(R.layout.fragment_byts_yts, container, false);
        ListView listView = (ListView) ytsView.findViewById(R.id.ytsListView);
        final YtsMovieArrayAdapter adapter = new YtsMovieArrayAdapter(getContext(),new ArrayList<YtsEntry>());
        listView.setAdapter(adapter);

        updateTask = new YtsMovieUpdateTask(adapter);
        updateTask.execute(1);

        listView.setOnScrollListener(
                new OnScrollInfiniteListener(new Generator<AsyncTask<Integer,Void,YtsPageResponse>>() {
                    @Override
                    public AsyncTask generate() {
                        return new YtsMovieUpdateTask(adapter);
                    }
                })
        );

        return ytsView;
    }
}
