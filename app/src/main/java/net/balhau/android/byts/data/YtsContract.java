package net.balhau.android.byts.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.format.Time;

/**
 * Contract for yts data
 * Created by balhau on 12/31/16.
 */

public class YtsContract {
    // The "Content authority" is a name for the entire content provider, similar to the
    // relationship between a domain name and its website.  A convenient string to use for the
    // content authority is the package name for the app, which is guaranteed to be unique on the
    // device.
    public static final String CONTENT_AUTHORITY = "net.balhau.android.byts";

    // Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Possible paths (appended to base content URI for possible URI's)
    // For instance, content://net.balhau.android.sunshine.app/weather/ is a valid path for
    // looking at weather data. content://com.example.android.byts/givemeroot/ will fail,
    // as the ContentProvider hasn't been given any information on what to do with "givemeroot".
    // At least, let's hope not.  Don't be that dev, reader.  Don't be that dev.
    public static final String PATH_TORRENTS = "yft";
    //public static final String PATH_LOCATION = "location";

    // To make it easy to query for the exact date, we normalize all dates that go into
    // the database to the start of the the Julian day at UTC.
    public static long normalizeDate(long startDate) {
        // normalize the start date to the beginning of the (UTC) day
        Time time = new Time();
        time.set(startDate);
        int julianDay = Time.getJulianDay(startDate, time.gmtoff);
        return time.setJulianDay(julianDay);
    }

    /*
     * The table is in desnormalized form. This way we don't need to create joins against several tables
     * to retrieve all the data for a specific provider. All the fields needed are represented in column and
     * all the providers will use different columns as needed.
     * Inner class that defines the table contents of the provider
     */

    public static final class ProviderEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TORRENTS).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TORRENTS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TORRENTS;

        // Table name
        public static final String TABLE_NAME = "provider";

        //Provider type

        public static final String COLUMN_PROVIDER_TYPE = "provider_type";
        //Torrent description
        public static final String COLUMN_LOCATION_SETTING = "description";

        //Torrent links encoded as json array
        public static final String COLUMN_CITY_NAME = "torrent_links";

        //Rotten tomatoes critics json object encoded information
        public static final String COLUMN_ROTTEN_TOMATOES_CRITICS = "rotten_tomatoes_critics";

        //Rotten tomatoes audience json object encoded information
        public static final String COLUMN_ROTTEN_TOMATOES_AUDIENCE = "rotten_tomatoes_audience";


        //Torrent likes
        public static final String COLUMN_TORRENT_LIKES = "torrent_likes";


        public static Uri buildLocationUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /*
            Student: This is the buildWeatherLocation function you filled in.

        public static Uri buildWeatherLocation(String locationSetting) {
            return CONTENT_URI.buildUpon().appendPath(locationSetting).build();
        }

        public static Uri buildWeatherLocationWithStartDate(
                String locationSetting, long startDate) {
            long normalizedDate = normalizeDate(startDate);
            return CONTENT_URI.buildUpon().appendPath(locationSetting)
                    .appendQueryParameter(COLUMN_DATE, Long.toString(normalizedDate)).build();
        }

        public static Uri buildWeatherLocationWithDate(String locationSetting, long date) {
            return CONTENT_URI.buildUpon().appendPath(locationSetting)
                    .appendPath(Long.toString(normalizeDate(date))).build();
        }

        public static String getLocationSettingFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static long getDateFromUri(Uri uri) {
            return Long.parseLong(uri.getPathSegments().get(2));
        }

        public static long getStartDateFromUri(Uri uri) {
            String dateString = uri.getQueryParameter(COLUMN_DATE);
            if (null != dateString && dateString.length() > 0)
                return Long.parseLong(dateString);
            else
                return 0;
        }
        */
    }
}
