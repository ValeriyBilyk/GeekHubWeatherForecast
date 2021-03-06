package org.thegeekhub.vbilyk.geekhubweatherforecast.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import org.thegeekhub.vbilyk.geekhubweatherforecast.R;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        getActivity().setTitle(R.string.action_settings);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("city")) {
            Preference connectionPref = findPreference(key);
            int position = Integer.parseInt(sharedPreferences.getString(key, "0"));
            connectionPref.setSummary(getActivity().getResources().getStringArray(R.array.cities)[position]);
        }
    }
}
