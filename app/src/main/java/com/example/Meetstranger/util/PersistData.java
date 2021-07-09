package com.example.Meetstranger.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PersistData {
    public static final String KeyMusicList = "KeyMusicList";
    public static final String KeyRingtoneOption = "KeyRingtoneOption";
    private static final String PREFS_FILE_NAME = "AppPreferences";
    public static final int defaultOption = 0;
    public static final int noRingtoneOption = 2;
    public static final int selectedOption = 1;

    public static boolean getBooleanData(Context context, String string2) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getBoolean(string2, false);
    }

    public static boolean getBooleanDataForOperationMode(Context context, String string2) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getBoolean(string2, true);
    }

    public static float getFloatData(Context context, String string2) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getFloat(string2, 0.0f);
    }

    public static int getIntData(Context context, String string2) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getInt(string2, -1);
    }

    public static long getLongData(Context context, String string2) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getLong(string2, -1L);
    }

    public static String getStringData(Context context, String string2) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getString(string2, "");
    }

    public static void setBooleanData(Context context, String string2, boolean bl) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME, 0).edit();
        editor.putBoolean(string2, bl);
        editor.commit();
    }

    public static void setBooleanDataForOperationMode(Context context, String string2, boolean bl) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME, 0).edit();
        editor.putBoolean(string2, bl);
        editor.commit();
    }

    public static void setFloatData(Context context, String string2, float f) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME, 0).edit();
        editor.putFloat(string2, f);
        editor.commit();
    }

    public static void setIntData(Context context, String string2, int n) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME, 0).edit();
        editor.putInt(string2, n);
        editor.commit();
    }

    public static void setLongData(Context context, String string2, long l) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME, 0).edit();
        editor.putLong(string2, l);
        editor.commit();
    }

    public static void setStringData(Context context, String string2, String string3) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME, 0).edit();
        editor.putString(string2, string3);
        editor.commit();
    }
}

