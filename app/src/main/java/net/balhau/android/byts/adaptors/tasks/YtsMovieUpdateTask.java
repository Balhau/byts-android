package net.balhau.android.byts.adaptors.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;

import net.balhau.android.byts.adaptors.YtsMovieArrayAdapter;
import net.balhau.android.byts.adaptors.domain.yts.YtsPageResponse;
import net.balhau.android.byts.utils.HttpUtil;

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
        String jsonData = HttpUtil.get(url);
        Gson gson = new Gson();
        YtsPageResponse response = gson.fromJson(jsonData,YtsPageResponse.class);
        return response;
    }

    @Override
    protected void onPostExecute(YtsPageResponse ytsPageResponse) {
        super.onPostExecute(ytsPageResponse);
        if(ytsPageResponse.getError()==false){
            adapter.addAll(ytsPageResponse.getMessage());
        }
    }
}
