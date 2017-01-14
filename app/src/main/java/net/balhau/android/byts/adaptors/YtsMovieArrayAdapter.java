package net.balhau.android.byts.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.balhau.android.byts.R;
import net.balhau.android.byts.adaptors.domain.yts.YtsEntry;


import java.util.ArrayList;

/**
 * Created by vitorfernandes on 1/14/17.
 */

public class YtsMovieArrayAdapter extends ArrayAdapter<YtsEntry> {


    public YtsMovieArrayAdapter(Context ctx, ArrayList<YtsEntry> entries){
        super(ctx,0,entries);
    }

    public View getView(int position, View cView, ViewGroup parent){
        YtsEntry entry = getItem(position);
        if(cView==null){
            cView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_byts_yts_detail,parent,false);
        }

        TextView titleTxt = (TextView) cView.findViewById(R.id.titleMovie);
        TextView imdbRatingTxt = (TextView) cView.findViewById(R.id.imdbRating);
        ImageView imageView = (ImageView) cView.findViewById(R.id.movieImage);

        Picasso.with(getContext())
                .load(entry.getImageURL())
                .centerCrop()
                .into(imageView);

        titleTxt.setText(entry.getDescription());
        imdbRatingTxt.setText(entry.getImdb().getDescription());


        return cView;
    }
}
