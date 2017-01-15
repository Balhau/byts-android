package net.balhau.android.byts.adaptors.tasks;

import android.os.AsyncTask;
import android.util.Base64;

import net.balhau.android.byts.adaptors.domain.yts.YtsEntry;
import net.balhau.android.byts.adaptors.domain.yts.YtsEntryResource;
import net.balhau.android.byts.adaptors.domain.yts.YtsPageResponse;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;


/**
 * Created by balhau on 1/15/17.
 */

public class YtsSendTorrentToDownload extends AsyncTask<YtsEntry,Void,YtsEntry> {
    @Override
    protected YtsEntry doInBackground(YtsEntry... params) {
        URL url;
        HttpURLConnection httpConnection=null;
        try {
            String auth = Base64.encodeToString("pi:gamma007".getBytes(),Base64.DEFAULT);
            url = new URL("http://transmission.balhau.net/transmission/rpc");
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestProperty("Authorization","Basic "+auth);
            httpConnection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            httpConnection.setRequestMethod("POST");

            InputStream in = httpConnection.getInputStream();
            OutputStream out = httpConnection.getOutputStream();
            YtsEntry entry = params[0];
            String torrentLink = entry.getTorrentLinks().size()>1
                    ? entry.getTorrentLinks().get(1).getUrl()
                    : entry.getTorrentLinks().get(0).getUrl();

            String payload = String.format("{" +
                    "\"method\":\"torrent-add\"," +
                    "\"arguments\":" +
                        "{" +
                        "\"paused\":false," +
                        "\"filename\":\"%s\"}}",torrentLink);

            out.write(payload.getBytes());
            httpConnection.disconnect();
        }catch (Exception ex){
            httpConnection.disconnect();
            return null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(YtsEntry success) {
        super.onPostExecute(success);
    }
}
