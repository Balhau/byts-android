package net.balhau.android.byts.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import net.balhau.android.byts.adaptors.BytsSyncAdapter;

/**
 * Background service for the toolkit application
 */

public class BYtsService extends Service {

    private static final Object serviceAdapterLock = new Object();
    private static BytsSyncAdapter bytsSyncAdapter;

    @Override
    public void onCreate() {
        //Double check null pattern
        if(bytsSyncAdapter==null){
            synchronized (serviceAdapterLock){
                if(bytsSyncAdapter==null){
                    bytsSyncAdapter=new BytsSyncAdapter(getApplicationContext(),true);
                }
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
