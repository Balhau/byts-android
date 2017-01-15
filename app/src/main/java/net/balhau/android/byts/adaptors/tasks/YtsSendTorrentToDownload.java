package net.balhau.android.byts.adaptors.tasks;

import android.os.AsyncTask;

import net.balhau.android.byts.adaptors.domain.yts.YtsPageResponse;

/**
 * Created by balhau on 1/15/17.
 */

public class YtsSendTorrentToDownload extends AsyncTask<YtsPageResponse,Void,YtsPageResponse> {
    @Override
    protected YtsPageResponse doInBackground(YtsPageResponse... params) {

        return null;
    }

    @Override
    protected void onPostExecute(YtsPageResponse success) {
        super.onPostExecute(success);
    }
}
