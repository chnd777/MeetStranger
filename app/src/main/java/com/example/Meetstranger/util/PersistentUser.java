package com.example.Meetstranger.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.Meetstranger.R;

public class PersistentUser extends Activity {

    //public static final String aaaaa = "aaaaa";
    private static final String ACCPETED_PACKAGE_LIST = "";
    private static final String ADS_COUNT = "ads_count";
    //public static final String CONTAINER = "MyPref";
    public static final String CURRENT_PACKAGE_NAME = "current_package";
    public static final String CURRENT_VERSION_NAME = "current_version";
    public static final String DEVICE_ID = "device_id";
    public static final String LAST_CALLER_ID = "last_caller_id";
    public static final String OPPONENT_DEVICE_ID = "opponent_device_id";
    private static final String PREFS_FILE_NAME = "AppPreferences";
    public static final String REGISTERED = "registered";
    public static final String REGISTERED_BEFORE = "registered_before";
    public static final String REPORT_COUNT = "report_count";
    public static final String SPEAKING_TIPS_COUNT = "speaking_tips_count";
    public static final String TIME = "time";
    public static final String TONGUE_TWISTERS_COUNT = "tongue_twisters_count";
    public static final String USER_AGE = "user_age";
    public static final String USER_COUNTRY_DEFAULT = "user_country_default";
    public static final String USER_COUNTRY_SELECTED = "user_country_selected";
    public static final String USER_GENDER = "user_gender";
    public static final String USER_NAME = "user_name";
    public static final String USER_NUMBER = "user_number";

    public static Context mContext;

    public static Context GetApplicationContext() {
        return mContext;
    }

    public static void SetApplicationContext(Context context) {
        mContext = context;
    }

    public static int getAdsCount(Context context) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getInt(ADS_COUNT, context.getResources().getInteger(R.integer.maxadscount));
    }

    public static String getCurrentPackage(Context context) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getString(CURRENT_PACKAGE_NAME, ACCPETED_PACKAGE_LIST);
    }

    public static String getCurrentVersion(Context context) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getString(CURRENT_VERSION_NAME, ACCPETED_PACKAGE_LIST);
    }

    public static String getDeviceId(Context context) {
        if(context==null)return "null";
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getString(DEVICE_ID, "null");
    }

    public static String getDeviceIdOpponent(Context context) {
        if(context==null)return "null";
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getString(OPPONENT_DEVICE_ID, "null");
    }

    public static String getLastCallerId(Context context) {
        if(context==null)return "null";
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getString(LAST_CALLER_ID, "null");
    }

    public static int getReportCount(Context context) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getInt(REPORT_COUNT, -100);
    }

    public static int getSpeakingTipsCount(Context context) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getInt(SPEAKING_TIPS_COUNT, -100);
    }

    public static String getTime(Context context) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getString(TIME, "null");
    }

    public static int getTongueTwistersCount(Context context) {
        return context.getSharedPreferences(PREFS_FILE_NAME, 0).getInt(TONGUE_TWISTERS_COUNT, -100);
    }

    public static String getUserAge(Context context){
        return context.getSharedPreferences(PREFS_FILE_NAME,0).getString(USER_AGE,"13");
    }

    public static String getUserCountryDefault(Context context){
        return context.getSharedPreferences(PREFS_FILE_NAME,0).getString(USER_COUNTRY_DEFAULT,"null");
    }

    public static String getUserCountrySelected(Context context){
        return context.getSharedPreferences(PREFS_FILE_NAME,0).getString(USER_COUNTRY_SELECTED,"null");
    }

    public static String getUserGender(Context context){
        return context.getSharedPreferences(PREFS_FILE_NAME,0).getString(USER_GENDER,"unknown");
    }

    public static String getUserName(Context context){
        return context.getSharedPreferences(PREFS_FILE_NAME,0).getString(USER_NAME,"null");
    }

    public static String getUserNumber(Context context){
        return context.getSharedPreferences(PREFS_FILE_NAME,0).getString(USER_NUMBER,"null");
    }

    public static boolean isRegistered(Context context) {
        return context.getApplicationContext().getSharedPreferences(PREFS_FILE_NAME, 0).getBoolean(REGISTERED, false);
    }

    public static boolean isRegisteredBefore(Context context) { // setRegisterBefore
        return context.getApplicationContext().getSharedPreferences(PREFS_FILE_NAME, 0).getBoolean(REGISTERED_BEFORE, false);
    }

    public static void setAdsCount(Context context, int i) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME, 0).edit();
        editor.putInt(ADS_COUNT, i);
        editor.apply();
    }

    public static void setCurrentPackage(Context context, String string2) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME, 0).edit();
        editor.putString(CURRENT_PACKAGE_NAME, string2);
        editor.apply();
    }

    public static void setCurrentVersion(Context context, String string2) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME, 0).edit();
        editor.putString(CURRENT_VERSION_NAME, string2);
        editor.apply();
    }

    public static void setDeviceId(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(DEVICE_ID,s);
        editor.apply();
    }

    public static void setDeviceIdOpponent(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(OPPONENT_DEVICE_ID,s);
        editor.apply();
    }

    public static void setLastCallerId(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(LAST_CALLER_ID,s);
        editor.apply();
    }

    public static void setReportCount(Context context,int i){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putInt(REPORT_COUNT,i);
        editor.apply();
    }

    public static void setRegister(Context context, boolean bl) {
        context.getApplicationContext().getSharedPreferences(PREFS_FILE_NAME, 0).edit().putBoolean(REGISTERED, bl).apply();
    }

    public static void setRegisterBefore(Context context, boolean bl) { // isRegisteredBefore
        context.getApplicationContext().getSharedPreferences(PREFS_FILE_NAME, 0).edit().putBoolean(REGISTERED_BEFORE, bl).apply();
    }

    public static void setSpeakingTipsCount(Context context,int i){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putInt(SPEAKING_TIPS_COUNT,i);
        editor.apply();
    }

    public static void setTime(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(TIME,s);
        editor.apply();
    }

    public static void setTongueTwistersCount(Context context,int i){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putInt(TONGUE_TWISTERS_COUNT,i);
        editor.apply();
    }

    public static void setUserAge(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(USER_AGE,s);
        editor.apply();
    }

    public static void setUserCountryDefault(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(USER_COUNTRY_DEFAULT,s);
        editor.apply();
    }

    public static void setUserCountrySelected(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(USER_COUNTRY_SELECTED,s);
        editor.apply();
    }

    public static void setUserGender(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(USER_GENDER,s);
        editor.apply();
    }

    public static void setUserName(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(USER_NAME,s);
        editor.apply();
    }

    public static void setUserNumber(Context context,String s){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_FILE_NAME,0).edit();
        editor.putString(USER_NUMBER,s);
        editor.apply();
    }

}
