package net.balhau.android.byts.fragments.settings;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import net.balhau.android.byts.R;

/**
 * Created by balhau on 1/15/17.
 */

public class SettingsFragment extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstance){
        addPreferencesFromResource(R.xml.preferences);
    }
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        return true;
    }
}
