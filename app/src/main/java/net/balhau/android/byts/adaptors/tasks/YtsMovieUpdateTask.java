package net.balhau.android.byts.adaptors.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.google.gson.Gson;

import net.balhau.android.byts.adaptors.YtsMovieArrayAdapter;
import net.balhau.android.byts.adaptors.domain.yts.YtsEntry;
import net.balhau.android.byts.adaptors.domain.yts.YtsPageResponse;
import net.balhau.android.byts.utils.Downloader;
import net.balhau.android.byts.utils.Executor;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by vitorfernandes on 1/14/17.
 */

public class YtsMovieUpdateTask extends AsyncTask<Integer,Void,YtsPageResponse>{
    private static final String YTS_ENDPOINT = "http://webpt.balhau.net/ws/yts/torrents/%s";
    private YtsMovieArrayAdapter adapter;

    public YtsMovieUpdateTask(YtsMovieArrayAdapter adapter){
        this.adapter=adapter;
    }

    @Override
    protected YtsPageResponse doInBackground(Integer... page) {
        String url = String.format(YTS_ENDPOINT,page);
        String jsonData = Downloader.get(url);
        Gson gson = new Gson();
        YtsPageResponse response = gson.fromJson(jsonData,YtsPageResponse.class);
        return response;
    }

    @Override
    protected void onPostExecute(YtsPageResponse ytsPageResponse) {
        super.onPostExecute(ytsPageResponse);
        if(ytsPageResponse.getError()==false){
            adapter.clear();
            adapter.addAll(ytsPageResponse.getMessage());
        }
    }
}
