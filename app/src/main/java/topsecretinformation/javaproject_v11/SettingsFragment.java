package topsecretinformation.javaproject_v11;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Marty on 3/18/1975.
 */

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
    }

    @Override
    public void onResume() {
        super.onResume();

        .getPreferenceManager()
                .getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onPause() {
        super.onPause();

        .getPreferenceManager()
                .getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onSharedPreferenceChanget(SharedPreference sharedPreference, )
        if
}
