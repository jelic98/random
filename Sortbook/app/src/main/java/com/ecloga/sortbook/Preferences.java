package com.ecloga.sortbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        if(key.equals("group_1_name")) {
            return preferences.getString(key, "Health");
        }else if(key.equals("group_2_name")) {
            return preferences.getString(key, "Love");
        }else if(key.equals("group_3_name")) {
            return preferences.getString(key, "Work");
        }else if(key.equals("group_4_name")) {
            return preferences.getString(key, "School");
        }else if(key.equals("group_5_name")) {
            return preferences.getString(key, "Shopping");
        }else if(key.equals("group_6_name")) {
            return preferences.getString(key, "Other");

        }else if(key.equals("notifications")) {
            return preferences.getString(key, "true");
        }else if(key.equals("sound")) {
            return preferences.getString(key, "true");
        }else if(key.equals("vibration")) {
            return preferences.getString(key, "true");
        }else if(key.equals("light")) {
            return preferences.getString(key, "true");
        }else if(key.equals("alarms")) {
            return preferences.getString(key, "true");

        }else if(key.equals("first_run")) {
            return preferences.getString(key, "false");

        }else if(key.equals("total_tasks")) {
            return preferences.getString(key, "1");
        }else if(key.equals("done_tasks")) {
            return preferences.getString(key, "0");
        }else if(key.equals("undone_tasks")) {
            //tutorial tasks
            return preferences.getString(key, "");
        }else if(key.equals("favourite_tasks")) {
            return preferences.getString(key, "0");

        }else {
            return preferences.getString(key, "false");
        }
    }
}
