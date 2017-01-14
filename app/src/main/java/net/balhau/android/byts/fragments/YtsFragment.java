package net.balhau.android.byts.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import net.balhau.android.byts.R;
import net.balhau.android.byts.adaptors.YtsMovieArrayAdapter;
import net.balhau.android.byts.adaptors.domain.yts.YtsEntry;
import net.balhau.android.byts.adaptors.domain.yts.YtsPageResponse;
import net.balhau.android.byts.adaptors.tasks.YtsMovieUpdateTask;
import net.balhau.android.byts.utils.Downloader;
import net.balhau.android.byts.utils.Executor;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Class for Yify torrent fragment view
 */
public class YtsFragment extends Fragment {

    private YtsMovieUpdateTask updateTask;
    public YtsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ytsView= inflater.inflate(R.layout.fragment_byts_yts, container, false);
        ListView listView = (ListView) ytsView.findViewById(R.id.ytsListView);
        YtsMovieArrayAdapter adapter = new YtsMovieArrayAdapter(getContext(),new ArrayList<YtsEntry>());
        listView.setAdapter(adapter);
        updateTask = new YtsMovieUpdateTask(adapter);
        updateTask.execute(1);
        return ytsView;
    }
}
