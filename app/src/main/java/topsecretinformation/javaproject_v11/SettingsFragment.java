package topsecretinformation.javaproject_v11;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Marty McFly on 3/07/1985.
 */

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
    }

}
