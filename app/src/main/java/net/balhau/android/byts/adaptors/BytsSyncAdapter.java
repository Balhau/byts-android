package net.balhau.android.byts.adaptors;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

/**
 *
 * Thread for background service
 */

public class BytsSyncAdapter extends AbstractThreadedSyncAdapter {

    public BytsSyncAdapter(Context context, boolean autoInitialize){
        super(context,autoInitialize);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {

    }
}
