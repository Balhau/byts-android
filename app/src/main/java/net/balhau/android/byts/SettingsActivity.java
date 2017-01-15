package net.balhau.android.byts;

import android.preference.Preference;
import android.preference.PreferenceActivity;

/**
 * Created by balhau on 1/15/17.
 */

public class SettingsActivity extends PreferenceActivity
        implements Preference.OnPreferenceChangeListener {
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }
}
