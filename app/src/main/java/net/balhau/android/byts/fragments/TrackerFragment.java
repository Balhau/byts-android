package net.balhau.android.byts.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.balhau.android.byts.R;

import java.util.logging.Logger;

/**
 * Fragment for the tracker view
 */

public class TrackerFragment extends Fragment {

    private static final String TAG = "TrackerFragment";

    private boolean recording;

    public TrackerFragment(){
        this.recording=false;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View trackerView = inflater.inflate(R.layout.fragment_byts_tracker,container,false);
        final Button recordButton = (Button)trackerView.findViewById(R.id.recordTrackButton);

        setRecording(recordButton,recording);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                recording = !recording;
                setRecording(btn,recording);
            }
        });

        return trackerView;
    }

    private void setRecording(Button btn,boolean recording){
        if(recording){
            btn.setBackgroundColor(Color.RED);
            btn.setText("Stop Tracker");
            Log.i(TAG,"Start recording");
        }else{
            btn.setBackgroundColor(Color.GREEN);
            btn.setText("Start Tracker");
            Log.i(TAG,"Stop recording");
        }
    }
}
