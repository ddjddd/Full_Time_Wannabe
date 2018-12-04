package pyneer.full_time_wannabe.utility;

import android.content.Context;
import android.content.SharedPreferences;

import pyneer.full_time_wannabe.app.App;


public class SharedPreferencesUtil {
    public static SharedPreferences pref;

    public static void putString(String key, String value) {
        validate();
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static void putInt(String key, int value) {
        validate();;
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt(key, value);
        edit.commit();
    }


    public static Boolean getBoolean(String key, boolean value) {
        validate();
        return pref.getBoolean(key, value);
    }


    public static void putBoolean(String key, boolean value) {
        validate();;
        SharedPreferences.Editor edit = pref.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static String getString(String key) {
        validate();
        return pref.getString(key, null);
    }

    public static int getInt(String key) {
        validate();
        return pref.getInt(key, 0);
    }

    private static void validate() {
        if(pref == null) {
            pref = App.getAppInstance().getSharedPreferences("teamplay", Context.MODE_PRIVATE);
        }
    }
}
