package example.lazar.com.lazar;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Lazar on 28.01.2015.
 */

public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
