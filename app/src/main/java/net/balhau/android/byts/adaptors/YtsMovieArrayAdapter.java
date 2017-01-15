package net.balhau.android.byts.adaptors;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.balhau.android.byts.R;
import net.balhau.android.byts.adaptors.domain.yts.YtsEntry;
import net.balhau.android.byts.fragments.details.YtsDetailFragment;


import java.util.ArrayList;

/**
 * Created by vitorfernandes on 1/14/17.
 */

public class YtsMovieArrayAdapter extends ArrayAdapter<YtsEntry> {

    private static final int YTS_NOTIFICATION_ID = 3005;
    private static final String YTS_GROUP_NOTIFICATION = "YTS_GROUP_NOTIFICATION";

    public YtsMovieArrayAdapter(Context ctx, ArrayList<YtsEntry> entries){
        super(ctx,0,entries);
    }

    public View getView(int position, View cView, ViewGroup parent){
        final YtsEntry entry = getItem(position);
        if(cView==null){
            cView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_byts_yts_detail,parent,false);
        }

        TextView titleTxt = (TextView) cView.findViewById(R.id.titleMovie);
        TextView imdbRatingTxt = (TextView) cView.findViewById(R.id.imdbRating);
        ImageView imageView = (ImageView) cView.findViewById(R.id.movieImage);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Next implement the async task to send the data into the server and in the end add the notification
                Resources r = getContext().getResources();
                Bitmap largeIcon = BitmapFactory.decodeResource(r,R.drawable.ic_yts);

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getContext())
                                .setColor(r.getColor(R.color.colorPrimary))
                                .setSmallIcon(R.drawable.ic_yts)
                                .setLargeIcon(largeIcon)
                                .setContentTitle(entry.getDescription())
                                .setContentText("Torrent "+entry.getDescription()+", added to download list")
                                .setGroup(YTS_GROUP_NOTIFICATION);

                NotificationManager mNotificationManager =
                        (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                // WEATHER_NOTIFICATION_ID allows you to update the notification later on.
                mNotificationManager.notify(YTS_GROUP_NOTIFICATION,(int)Math.abs(Math.random()*1000), mBuilder.build());
            }
        });

        Picasso.with(getContext())
                .load(entry.getImageURL())
                .into(imageView);

        titleTxt.setText(entry.getDescription());
        imdbRatingTxt.setText(entry.getImdb().getDescription());


        return cView;
    }
}
