package net.balhau.android.byts.fragments.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.balhau.android.byts.R;

import org.w3c.dom.Text;

import java.net.URL;

/**
 * This will show detailed information regarding the YTS entry
 */

public class YtsDetailFragment extends Fragment{

    public static final String URL_IMAGE="img_url";
    public static final String TITLE = "title";
    public static final String IMDB_RATING="imdb_rating";

    private String imageUrl;
    private String title;
    private String imdbRating;

    public YtsDetailFragment(){
    }

    public static Bundle buildBundle(String imageURL,String title,String imdbRating){
        Bundle bundle = new Bundle();
        bundle.putString(URL_IMAGE,imageURL);
        bundle.putString(TITLE,title);
        bundle.putString(IMDB_RATING,imdbRating);
        return bundle;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ytsViewDetail = inflater.inflate(R.layout.fragment_byts_yts_detail, container, false);
        getBundle(savedInstanceState);
        buildView(ytsViewDetail);
        return ytsViewDetail;
    }

    private void getBundle(Bundle bundle){
        imageUrl=(String)bundle.get(URL_IMAGE);
        title=(String)bundle.get(TITLE);
        imdbRating=(String)bundle.get(IMDB_RATING);
    }

    private void buildView(View view) {
        TextView imdbRatingTxt = (TextView)view.findViewById(R.id.imdbRating);
        TextView titleTxt = (TextView)view.findViewById(R.id.titleMovie);

        imdbRatingTxt.setText(imdbRating);
        titleTxt.setText(title);
    }
}
