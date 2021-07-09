package com.example.Meetstranger;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.firebase.geofire.GeoFire;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.example.Meetstranger.profile.ProfileActivity;
import com.example.Meetstranger.util.PersistentUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivityFemale extends AppCompatActivity implements SensorEventListener {

    private String deviceId = "";

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();

        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Users").child(deviceId);
        current_user_db.child("status").setValue("offline");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Searching");
        GeoFire geoFire = new GeoFire(ref);
        geoFire.removeLocation(deviceId);

        isSearching = false;
        if(mp.isPlaying())
        {
            playRingtone();
            progressbar.setVisibility(View.GONE);
            text.setVisibility(View.GONE);
            call.setText("Talk To Random Person");
            share_btn.setVisibility(View.VISIBLE);
            more.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Users").child(deviceId);
        current_user_db.child("status").setValue("online");
        isSearching=false;
        if(mp.isPlaying())
            playRingtone();
        //sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //updateUI(currentUser);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //sensorManager.unregisterListener(this);
    }

    private static final int REQUEST_MIC = 991;
    private static final int REQUEST_CAMERA = 992;
    private static final int REQUEST_CALL = 993;
    private static final int REQUEST_STORAGE = 994;
    private static final int WAKELOCK = 995;
    private static final String TAG = "ConnectActivity";
    private static final int CONNECTION_REQUEST = 1;
    private static final int REMOVE_FAVORITE_INDEX = 0;
    private static boolean commandLineRun = false;

    private SharedPreferences sharedPref;
    private String keyprefResolution;
    private String keyprefFps;
    private String keyprefVideoBitrateType;
    private String keyprefVideoBitrateValue;
    private String keyprefAudioBitrateType;
    private String keyprefAudioBitrateValue;
    private String keyprefRoomServerUrl;
    private String keyprefRoom;
    private String keyprefRoomList;

    private ArrayList<String> roomList;
    private ArrayAdapter<String> adapter;
    private String requestId;
    private String Userid;

    boolean isCallConnected = false;
    boolean isSearching = false;
    boolean isPermissionGranted=false;

    private SensorManager sensorManager;
    private Sensor sensor;
    private PowerManager powerManager;
    private PowerManager.WakeLock wakeLock;
    private int field = 0x00000020;
    WindowManager.LayoutParams params;

    Context context = this;
    MediaPlayer mp;

    private boolean isCalling;

    private ProgressBar progressbar;
    private TextView text;
    private Button call;
    private Button share_btn;
    private Button more;

    // facebook ads
    private AdView adView;
    private AdListener adListener;
    private int adscount = 0;
    private int maxadscount = 0;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        deviceId = PersistentUser.getDeviceId(this.getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_female);

        // facebook ads
        adscount = PersistentUser.getAdsCount(this.getApplicationContext());
        maxadscount = getResources().getInteger(R.integer.maxadscount);

        adView = new AdView(this, getResources().getString(R.string.fb_banner_ad2), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
            }

            @Override
            public void onAdLoaded(Ad ad) {
            }

            @Override
            public void onAdClicked(Ad ad) {
                adscount++;
                PersistentUser.setAdsCount(MainActivityFemale.this,adscount);
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        if(adscount<=maxadscount){
            adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());
        }
        //

        progressbar = findViewById(R.id.progressbar);
        text = findViewById(R.id.text);
        call = findViewById(R.id.call);
        share_btn = findViewById(R.id.share_btn);
        more = findViewById(R.id.more);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        keyprefResolution = getString(R.string.pref_resolution_key);
        keyprefFps = getString(R.string.pref_fps_key);
        keyprefVideoBitrateType = getString(R.string.pref_maxvideobitrate_key);
        keyprefVideoBitrateValue = getString(R.string.pref_maxvideobitratevalue_key);
        keyprefAudioBitrateType = getString(R.string.pref_startaudiobitrate_key);
        keyprefAudioBitrateValue = getString(R.string.pref_startaudiobitratevalue_key);
        keyprefRoomServerUrl = getString(R.string.pref_room_server_url_key);
        keyprefRoom = getString(R.string.pref_room_key);
        keyprefRoomList = getString(R.string.pref_room_list_key);

        // block activity
        int reprotCnt = PersistentUser.getReportCount(this.getApplicationContext());
        if(reprotCnt>20){
            Toast.makeText(getApplicationContext(),"More than 20 users reported you so we will block you\nYou can appeal us if you want to unblock again",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
            startActivity(intent);
            finish();
        }
        //

        findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isInternetAvailable()){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.internet_connection),Toast.LENGTH_SHORT).show();
                }else{
                    getPremissions();
                }
            }
        });

        final int[] reportcnt = {0};
        findViewById(R.id.share_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.share));
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                */
                String reportString = PersistentUser.getLastCallerId(MainActivityFemale.this);
                if(reportString.equals("null")){
                    Toast.makeText(getApplicationContext(),"We dont find any record of your last call",Toast.LENGTH_SHORT).show();
                }else if(!isInternetAvailable()){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.internet_connection),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Report Submitted and thank you for making this app safe and clean",Toast.LENGTH_SHORT).show();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("reports").child(reportString);
                    ref.child(deviceId).setValue("true");
                }
            }
        });

        //
        findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                if(!isInternetAvailable()){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.internet_connection),Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivityFemale.this,MoreActivity.class);
                    startActivity(intent);
                }
                //
            }
        });

        // audioringing
        mp = MediaPlayer.create(context, R.raw.randomtalkringtone);

        sensorWorking();
        onlypermission();

    }

    // On Pressing back button
    @Override
    public void onBackPressed() {
        if (!isSearching) {
            new AlertDialog.Builder(this)
                    .setTitle("Do you want to close this app?")
                    .setMessage("Thanks for using our service")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            MainActivityFemale.super.onBackPressed();
                        }
                    }).create().show();
        }else {
            connectCall();
            playRingtone();
        }
    }

    // Playing ringtone after clicking call button and executing getPermissions function
    public void playRingtone()
    {
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(context, R.raw.randomtalkringtone);
            }else {
                mp = MediaPlayer.create(context, R.raw.randomtalkringtone);
                mp.setLooping(true);
                mp.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    int PERMISSION_ALL = 1;
    private boolean getPremissions() {
        String[] PERMISSIONS = {
                android.Manifest.permission.RECORD_AUDIO,
                android.Manifest.permission.CAMERA,
        };

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
            return false;
        }else{
            connectCall();
            playRingtone();
        }

        return true;
    }

    public boolean onlypermission()
    {
        String[] PERMISSIONS = {
                //Manifest.permission.CALL_PHONE,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CAMERA,
                // TOD:MOGANSTAR: to uncomment later : Manifest.permission.READ_PHONE_STATE
        };

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
            return false;
        }
        return true;
    }
    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_MIC) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivityFemale.this,"Premission Granted",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityFemale.this,"Premission Failed",Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivityFemale.this,"Premission call Granted",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityFemale.this,"Premission call Failed",Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == WAKELOCK) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivityFemale.this,"Premission call Granted",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityFemale.this,"Premission call Failed",Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == PERMISSION_ALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivityFemale.this,"Premission Granted",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityFemale.this,"Premission Failed",Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Connecting call after clicking call button and executing getPermissions()
    public void connectCall()
    {
        if(!isSearching)
        {
            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Searching").child(deviceId);
            current_user_db.child("status").setValue("online");
            isSearching = true;
            findNearUser();
            progressbar.setVisibility(View.VISIBLE);
            text.setVisibility(View.VISIBLE);
            call.setText("Stop Calling");
            share_btn.setVisibility(View.GONE);
            more.setVisibility(View.GONE);
        }
        else
        {
            isSearching = false;
            progressbar.setVisibility(View.GONE);
            text.setVisibility(View.GONE);
            call.setText("Talk To Random Person");
            share_btn.setVisibility(View.VISIBLE);
            more.setVisibility(View.VISIBLE);
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Searching");
            GeoFire geoFire = new GeoFire(ref);
            geoFire.removeLocation(deviceId);
        }
    }

    // Finding nearest User method after executing connectCall method()
    boolean isfinal = false;
    private void findNearUser() {
        DatabaseReference userHistoryDatabase = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Searching");
        Query q = userHistoryDatabase.orderByKey().limitToLast(2);
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    boolean islast = false;
                    for (DataSnapshot history : dataSnapshot.getChildren()) {
                        Log.e(TAG,history.getKey()+" KEY FOUND");
                        if (!history.getKey().equals(deviceId)) {
                            if(!isCallConnected) {
                                callAudio(history,deviceId);
                            }
                        }else {
                            islast=true;
                        }

                        if(islast==true)
                        {
                            Log.e(TAG," First Call FOUND");
                            // DatabaseReference userHistoryDatabase = FirebaseDatabase.getInstance().getReference().child("Searching").child(user_id);
                            DatabaseReference userHistoryDatabase = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Users").child(deviceId).child("history");
                            Query q=userHistoryDatabase.orderByKey().limitToLast(1);
                            final boolean iscorrect = false;
                            q.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    Log.e(TAG,"Add data  :"+dataSnapshot.toString());
                                    if(dataSnapshot.exists())
                                    {
                                        for (DataSnapshot history : dataSnapshot.getChildren()) {
                                            Log.e(TAG,"data Fetch :"+history.getKey());
                                        }
                                    }
                                    if(isfinal && isSearching)
                                    {

                                        //  isCallConnected=true;
                                        requestId = dataSnapshot.getKey();
                                        DatabaseReference otheruser = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("OnCall").child(dataSnapshot.getKey().toString()).child("user1");
                                        otheruser.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                Log.e(TAG,"data change"+dataSnapshot.toString());
                                                Userid = dataSnapshot.getValue().toString();
                                                Log.e(TAG,"User ID :"+Userid);
                                                if(!isCallConnected)
                                                {
                                                    isSearching=false;
                                                    playRingtone();
                                                    connectToRoom(requestId, false, false, false, 0,false);
                                                    isCallConnected=true;
                                                }

                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {

                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                                   Log.e(TAG,"data Fetch :"+s);
//                                   if(dataSnapshot.exists())
//                                   {
//                                       for (DataSnapshot history : dataSnapshot.getChildren()) {
//                                           Log.e(TAG,"data Fetch :"+history.getKey());
//                                       }
//                                   }
                                }

                                @Override
                                public void onChildRemoved(DataSnapshot dataSnapshot) {
                                    Log.e(TAG,"Remove:"+dataSnapshot.toString());
                                    isfinal = true;
                                    if(dataSnapshot.exists())
                                    {
                                        for (DataSnapshot history : dataSnapshot.getChildren()) {
                                            Log.e(TAG,"data Fetch :"+history.getKey());
                                        }
                                    }
                                }

                                @Override
                                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//                                   Log.e(TAG,"data Fetch :"+s);
//                                   if(dataSnapshot.exists())
//                                   {
//                                       for (DataSnapshot history : dataSnapshot.getChildren()) {
//                                           Log.e(TAG,"data Fetch :"+history.getKey());
//                                       }
//                                   }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //

    // callAudio method
    private void callAudio(DataSnapshot history,String user_id)
    {
        Userid = history.getKey();
        DatabaseReference onCall = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("OnCall");

        DatabaseReference user1 = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Users").child(history.getKey()).child("history");
        DatabaseReference currentuser = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Users").child(user_id).child("history");
        DatabaseReference historyRef = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("history");

        requestId = historyRef.push().getKey();
        user1.child(requestId).setValue(true);
        currentuser.child(requestId).setValue(true);
        onCall.child(requestId).setValue(true);

        HashMap map = new HashMap();
        map.put("user1", history.getKey());
        map.put("user2", user_id);

        onCall.child(requestId).updateChildren(map);
        historyRef.child(requestId).updateChildren(map);

        DatabaseReference u1 = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Searching").child(history.getKey());
        u1.removeValue();
        DatabaseReference u2 = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Searching").child(deviceId);
        u2.removeValue();

        isCallConnected=true;

        connectToRoom(requestId, false, false, false, 0,false);
    }
    private Long getCurrentTimestamp() {
        Long timestamp = System.currentTimeMillis()/1000;
        return timestamp;
    }
    //

    // connectToRoom method
    private void connectToRoom(String roomId, boolean commandLineRun, boolean loopback,
                               boolean useValuesFromIntent, int runTimeMs, boolean videocall) {

        PersistentUser.setDeviceIdOpponent(this.getApplicationContext(),"null");

        MainActivityFemale.commandLineRun = commandLineRun;

        // roomId is random for loopback.
        if (loopback) {
            roomId = Integer.toString((new Random()).nextInt(100000000));
        }

        String roomUrl = sharedPref.getString(
                keyprefRoomServerUrl, getString(R.string.pref_room_server_url_default));

        // Video call enabled flag.
        boolean videoCallEnabled = sharedPrefGetBoolean(R.string.pref_videocall_key,
                CallActivity.EXTRA_VIDEO_CALL, R.string.pref_videocall_default, useValuesFromIntent);
//        boolean videoCallEnabled = videocall;
        // Use screencapture option.
        boolean useScreencapture = sharedPrefGetBoolean(R.string.pref_screencapture_key,
                CallActivity.EXTRA_SCREENCAPTURE, R.string.pref_screencapture_default, useValuesFromIntent);

        // Use Camera2 option.
        boolean useCamera2 = sharedPrefGetBoolean(R.string.pref_camera2_key, CallActivity.EXTRA_CAMERA2,
                R.string.pref_camera2_default, useValuesFromIntent);
//        boolean useCamera2=false;

        // Get default codecs.
        String videoCodec = sharedPrefGetString(R.string.pref_videocodec_key,
                CallActivity.EXTRA_VIDEOCODEC, R.string.pref_videocodec_default, useValuesFromIntent);
        String audioCodec = sharedPrefGetString(R.string.pref_audiocodec_key,
                CallActivity.EXTRA_AUDIOCODEC, R.string.pref_audiocodec_default, useValuesFromIntent);

        // Check HW codec flag.
        boolean hwCodec = sharedPrefGetBoolean(R.string.pref_hwcodec_key,
                CallActivity.EXTRA_HWCODEC_ENABLED, R.string.pref_hwcodec_default, useValuesFromIntent);

        // Check Capture to texture.
        boolean captureToTexture = sharedPrefGetBoolean(R.string.pref_capturetotexture_key,
                CallActivity.EXTRA_CAPTURETOTEXTURE_ENABLED, R.string.pref_capturetotexture_default,
                useValuesFromIntent);

        // Check FlexFEC.
        boolean flexfecEnabled = sharedPrefGetBoolean(R.string.pref_flexfec_key,
                CallActivity.EXTRA_FLEXFEC_ENABLED, R.string.pref_flexfec_default, useValuesFromIntent);

        // Check Disable Audio Processing flag.
        boolean noAudioProcessing = sharedPrefGetBoolean(R.string.pref_noaudioprocessing_key,
                CallActivity.EXTRA_NOAUDIOPROCESSING_ENABLED, R.string.pref_noaudioprocessing_default,
                useValuesFromIntent);

        // Check Disable Audio Processing flag.
        boolean aecDump = sharedPrefGetBoolean(R.string.pref_aecdump_key,
                CallActivity.EXTRA_AECDUMP_ENABLED, R.string.pref_aecdump_default, useValuesFromIntent);

        // Check OpenSL ES enabled flag.
        boolean useOpenSLES = sharedPrefGetBoolean(R.string.pref_opensles_key,
                CallActivity.EXTRA_OPENSLES_ENABLED, R.string.pref_opensles_default, useValuesFromIntent);

        // Check Disable built-in AEC flag.
        boolean disableBuiltInAEC = sharedPrefGetBoolean(R.string.pref_disable_built_in_aec_key,
                CallActivity.EXTRA_DISABLE_BUILT_IN_AEC, R.string.pref_disable_built_in_aec_default,
                useValuesFromIntent);

        // Check Disable built-in AGC flag.
        boolean disableBuiltInAGC = sharedPrefGetBoolean(R.string.pref_disable_built_in_agc_key,
                CallActivity.EXTRA_DISABLE_BUILT_IN_AGC, R.string.pref_disable_built_in_agc_default,
                useValuesFromIntent);

        // Check Disable built-in NS flag.
        boolean disableBuiltInNS = sharedPrefGetBoolean(R.string.pref_disable_built_in_ns_key,
                CallActivity.EXTRA_DISABLE_BUILT_IN_NS, R.string.pref_disable_built_in_ns_default,
                useValuesFromIntent);

        // Check Enable level control.
        boolean enableLevelControl = sharedPrefGetBoolean(R.string.pref_enable_level_control_key,
                CallActivity.EXTRA_ENABLE_LEVEL_CONTROL, R.string.pref_enable_level_control_key,
                useValuesFromIntent);

        // Check Disable gain control
        boolean disableWebRtcAGCAndHPF = sharedPrefGetBoolean(
                R.string.pref_disable_webrtc_agc_and_hpf_key, CallActivity.EXTRA_DISABLE_WEBRTC_AGC_AND_HPF,
                R.string.pref_disable_webrtc_agc_and_hpf_key, useValuesFromIntent);

        // Get video resolution from settings.
        int videoWidth = 0;
        int videoHeight = 0;
        if (useValuesFromIntent) {
            videoWidth = getIntent().getIntExtra(CallActivity.EXTRA_VIDEO_WIDTH, 0);
            videoHeight = getIntent().getIntExtra(CallActivity.EXTRA_VIDEO_HEIGHT, 0);
        }
        if (videoWidth == 0 && videoHeight == 0) {
            String resolution = sharedPref.getString(keyprefResolution, getString(R.string.pref_resolution_default));
            String[] dimensions = resolution.split("[ x]+");
            if (dimensions.length == 2) {
                try {
                    videoWidth = Integer.parseInt(dimensions[0]);
                    videoHeight = Integer.parseInt(dimensions[1]);
                } catch (NumberFormatException e) {
                    videoWidth = 0;
                    videoHeight = 0;
                    Log.e(TAG, "Wrong video resolution setting: " + resolution);
                }
            }
        }

        // Get camera fps from settings.
        int cameraFps = 0;
        if (useValuesFromIntent) {
            cameraFps = getIntent().getIntExtra(CallActivity.EXTRA_VIDEO_FPS, 0);
        }
        if (cameraFps == 0) {
            String fps = sharedPref.getString(keyprefFps, getString(R.string.pref_fps_default));
            String[] fpsValues = fps.split("[ x]+");
            if (fpsValues.length == 2) {
                try {
                    cameraFps = Integer.parseInt(fpsValues[0]);
                } catch (NumberFormatException e) {
                    cameraFps = 0;
                    Log.e(TAG, "Wrong camera fps setting: " + fps);
                }
            }
        }

        // Check capture quality slider flag.
        boolean captureQualitySlider = sharedPrefGetBoolean(R.string.pref_capturequalityslider_key,
                CallActivity.EXTRA_VIDEO_CAPTUREQUALITYSLIDER_ENABLED,
                R.string.pref_capturequalityslider_default, useValuesFromIntent);

        // Get video and audio start bitrate.
        // Video start bitrate.
        int videoStartBitrate = 0;
        if (useValuesFromIntent) {
            videoStartBitrate = getIntent().getIntExtra(CallActivity.EXTRA_VIDEO_BITRATE, 0);
        }
        if (videoStartBitrate == 0) {
            String bitrateTypeDefault = getString(R.string.pref_maxvideobitrate_default);
            String bitrateType = sharedPref.getString(keyprefVideoBitrateType, bitrateTypeDefault);
            if (!bitrateType.equals(bitrateTypeDefault)) {
                String bitrateValue = sharedPref.getString(
                        keyprefVideoBitrateValue, getString(R.string.pref_maxvideobitratevalue_default));
                videoStartBitrate = Integer.parseInt(bitrateValue);
            }
        }
        // Audio start bitrate.
        int audioStartBitrate = 0;
        if (useValuesFromIntent) {
            audioStartBitrate = getIntent().getIntExtra(CallActivity.EXTRA_AUDIO_BITRATE, 0);
        }
        if (audioStartBitrate == 0) {
            String bitrateTypeDefault = getString(R.string.pref_startaudiobitrate_default);
            String bitrateType = sharedPref.getString(keyprefAudioBitrateType, bitrateTypeDefault);
            if (!bitrateType.equals(bitrateTypeDefault)) {
                String bitrateValue = sharedPref.getString(
                        keyprefAudioBitrateValue, getString(R.string.pref_startaudiobitratevalue_default));
                audioStartBitrate = Integer.parseInt(bitrateValue);
            }
        }

        // Check statistics display option.
        boolean displayHud = sharedPrefGetBoolean(R.string.pref_displayhud_key,
                CallActivity.EXTRA_DISPLAY_HUD, R.string.pref_displayhud_default, useValuesFromIntent);

        boolean tracing = sharedPrefGetBoolean(R.string.pref_tracing_key, CallActivity.EXTRA_TRACING,
                R.string.pref_tracing_default, useValuesFromIntent);

        // Get datachannel options
        boolean dataChannelEnabled = sharedPrefGetBoolean(R.string.pref_enable_datachannel_key,
                CallActivity.EXTRA_DATA_CHANNEL_ENABLED, R.string.pref_enable_datachannel_default,
                useValuesFromIntent);
        boolean ordered = sharedPrefGetBoolean(R.string.pref_ordered_key, CallActivity.EXTRA_ORDERED,
                R.string.pref_ordered_default, useValuesFromIntent);
        boolean negotiated = sharedPrefGetBoolean(R.string.pref_negotiated_key,
                CallActivity.EXTRA_NEGOTIATED, R.string.pref_negotiated_default, useValuesFromIntent);
        int maxRetrMs = sharedPrefGetInteger(R.string.pref_max_retransmit_time_ms_key,
                CallActivity.EXTRA_MAX_RETRANSMITS_MS, R.string.pref_max_retransmit_time_ms_default,
                useValuesFromIntent);
        int maxRetr =
                sharedPrefGetInteger(R.string.pref_max_retransmits_key, CallActivity.EXTRA_MAX_RETRANSMITS,
                        R.string.pref_max_retransmits_default, useValuesFromIntent);
        int id = sharedPrefGetInteger(R.string.pref_data_id_key, CallActivity.EXTRA_ID,
                R.string.pref_data_id_default, useValuesFromIntent);
        String protocol = sharedPrefGetString(R.string.pref_data_protocol_key,
                CallActivity.EXTRA_PROTOCOL, R.string.pref_data_protocol_default, useValuesFromIntent);

        // Start AppRTCMobile activity.
        Log.d(TAG, "Connecting to room " + roomId + " at URL " + roomUrl);
        if (validateUrl(roomUrl)) {
            Uri uri = Uri.parse(roomUrl);
            Intent intent = new Intent(this, CallActivity.class);
            intent.setData(uri);
            intent.putExtra(CallActivity.EXTRA_ROOMID, roomId);
            intent.putExtra(CallActivity.EXTRA_LOOPBACK, loopback);
            intent.putExtra(CallActivity.EXTRA_VIDEO_CALL, videoCallEnabled);
            intent.putExtra(CallActivity.EXTRA_SCREENCAPTURE, useScreencapture);
            intent.putExtra(CallActivity.EXTRA_CAMERA2, useCamera2);
            intent.putExtra(CallActivity.EXTRA_VIDEO_WIDTH, videoWidth);
            intent.putExtra(CallActivity.EXTRA_VIDEO_HEIGHT, videoHeight);
            intent.putExtra(CallActivity.EXTRA_VIDEO_FPS, cameraFps);
            intent.putExtra(CallActivity.EXTRA_VIDEO_CAPTUREQUALITYSLIDER_ENABLED, captureQualitySlider);
            intent.putExtra(CallActivity.EXTRA_VIDEO_BITRATE, videoStartBitrate);
            intent.putExtra(CallActivity.EXTRA_VIDEOCODEC, videoCodec);
            intent.putExtra(CallActivity.EXTRA_HWCODEC_ENABLED, hwCodec);
            intent.putExtra(CallActivity.EXTRA_CAPTURETOTEXTURE_ENABLED, captureToTexture);
            intent.putExtra(CallActivity.EXTRA_FLEXFEC_ENABLED, flexfecEnabled);
            intent.putExtra(CallActivity.EXTRA_NOAUDIOPROCESSING_ENABLED, noAudioProcessing);
            intent.putExtra(CallActivity.EXTRA_AECDUMP_ENABLED, aecDump);
            intent.putExtra(CallActivity.EXTRA_OPENSLES_ENABLED, useOpenSLES);
            intent.putExtra(CallActivity.EXTRA_DISABLE_BUILT_IN_AEC, disableBuiltInAEC);
            intent.putExtra(CallActivity.EXTRA_DISABLE_BUILT_IN_AGC, disableBuiltInAGC);
            intent.putExtra(CallActivity.EXTRA_DISABLE_BUILT_IN_NS, disableBuiltInNS);
            intent.putExtra(CallActivity.EXTRA_ENABLE_LEVEL_CONTROL, enableLevelControl);
            intent.putExtra(CallActivity.EXTRA_DISABLE_WEBRTC_AGC_AND_HPF, disableWebRtcAGCAndHPF);
            intent.putExtra(CallActivity.EXTRA_AUDIO_BITRATE, audioStartBitrate);
            intent.putExtra(CallActivity.EXTRA_AUDIOCODEC, audioCodec);
            intent.putExtra(CallActivity.EXTRA_DISPLAY_HUD, displayHud);
            intent.putExtra(CallActivity.EXTRA_TRACING, tracing);
            intent.putExtra(CallActivity.EXTRA_CMDLINE, commandLineRun);
            intent.putExtra(CallActivity.EXTRA_RUNTIME, runTimeMs);

            intent.putExtra(CallActivity.EXTRA_DATA_CHANNEL_ENABLED, dataChannelEnabled);
            if (dataChannelEnabled) {
                intent.putExtra(CallActivity.EXTRA_ORDERED, ordered);
                intent.putExtra(CallActivity.EXTRA_MAX_RETRANSMITS_MS, maxRetrMs);
                intent.putExtra(CallActivity.EXTRA_MAX_RETRANSMITS, maxRetr);
                intent.putExtra(CallActivity.EXTRA_PROTOCOL, protocol);
                intent.putExtra(CallActivity.EXTRA_NEGOTIATED, negotiated);
                intent.putExtra(CallActivity.EXTRA_ID, id);
            }

            if (useValuesFromIntent) {
                if (getIntent().hasExtra(CallActivity.EXTRA_VIDEO_FILE_AS_CAMERA)) {
                    String videoFileAsCamera =
                            getIntent().getStringExtra(CallActivity.EXTRA_VIDEO_FILE_AS_CAMERA);
                    intent.putExtra(CallActivity.EXTRA_VIDEO_FILE_AS_CAMERA, videoFileAsCamera);
                }

                if (getIntent().hasExtra(CallActivity.EXTRA_SAVE_REMOTE_VIDEO_TO_FILE)) {
                    String saveRemoteVideoToFile =
                            getIntent().getStringExtra(CallActivity.EXTRA_SAVE_REMOTE_VIDEO_TO_FILE);
                    intent.putExtra(CallActivity.EXTRA_SAVE_REMOTE_VIDEO_TO_FILE, saveRemoteVideoToFile);
                }

                if (getIntent().hasExtra(CallActivity.EXTRA_SAVE_REMOTE_VIDEO_TO_FILE_WIDTH)) {
                    int videoOutWidth =
                            getIntent().getIntExtra(CallActivity.EXTRA_SAVE_REMOTE_VIDEO_TO_FILE_WIDTH, 0);
                    intent.putExtra(CallActivity.EXTRA_SAVE_REMOTE_VIDEO_TO_FILE_WIDTH, videoOutWidth);
                }

                if (getIntent().hasExtra(CallActivity.EXTRA_SAVE_REMOTE_VIDEO_TO_FILE_HEIGHT)) {
                    int videoOutHeight =
                            getIntent().getIntExtra(CallActivity.EXTRA_SAVE_REMOTE_VIDEO_TO_FILE_HEIGHT, 0);
                    intent.putExtra(CallActivity.EXTRA_SAVE_REMOTE_VIDEO_TO_FILE_HEIGHT, videoOutHeight);
                }
            }
            intent.putExtra("userid",Userid);
            startActivityForResult(intent, CONNECTION_REQUEST);
        }

    }
    //

    // onActivityResult after calling startActivityForResult in connectToRoom method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CONNECTION_REQUEST && commandLineRun) {
            Log.d(TAG, "Return: " + resultCode);
            setResult(resultCode);
            commandLineRun = false;

            finish();
        } else if (requestCode == CONNECTION_REQUEST) {
            Log.d(TAG, "Return: " + resultCode);
            isCallConnected = false;
            isfinal = false;
            progressbar.setVisibility(View.GONE);
            text.setVisibility(View.GONE);
            call.setText("Talk To Random Person");
            share_btn.setVisibility(View.VISIBLE);
            more.setVisibility(View.VISIBLE);
        }
    }
    //

    // validate url method
    private boolean validateUrl(String url) {
        if (URLUtil.isHttpsUrl(url) || URLUtil.isHttpUrl(url)) {
            return true;
        }
        new AlertDialog.Builder(this)
                .setTitle(getText(R.string.invalid_url_title))
                .setMessage(getString(R.string.invalid_url_text, url))
                .setCancelable(false)
                .setNeutralButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .create()
                .show();
        return false;
    }
    //

    // SharedPreferences Getting Functions/Methods
    private String sharedPrefGetString(int attributeId, String intentName, int defaultId, boolean useFromIntent) {
        String defaultValue = getString(defaultId);
        if (useFromIntent) {
            String value = getIntent().getStringExtra(intentName);
            if (value != null) {
                return value;
            }
            return defaultValue;
        } else {
            String attributeName = getString(attributeId);
            return sharedPref.getString(attributeName, defaultValue);
        }
    }

    private boolean sharedPrefGetBoolean(int attributeId, String intentName, int defaultId, boolean useFromIntent) {
        boolean defaultValue = Boolean.valueOf(getString(defaultId));
        if (useFromIntent) {
            return getIntent().getBooleanExtra(intentName, defaultValue);
        } else {
            String attributeName = getString(attributeId);
            return sharedPref.getBoolean(attributeName, defaultValue);
        }
    }

    private int sharedPrefGetInteger(int attributeId, String intentName, int defaultId, boolean useFromIntent) {
        String defaultString = getString(defaultId);
        int defaultValue = Integer.parseInt(defaultString);
        if (useFromIntent) {
            return getIntent().getIntExtra(intentName, defaultValue);
        } else {
            String attributeName = getString(attributeId);
            String value = sharedPref.getString(attributeName, defaultString);
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                Log.e(TAG, "Wrong setting for: " + attributeName + ":" + value);
                return defaultValue;
            }
        }
    }

    //

    // SensorEventListener methods
    private void sensorWorking() {
        try {
            // Yeah, this is hidden field.
            field = PowerManager.class.getClass().getField("PROXIMITY_SCREEN_OFF_WAKE_LOCK").getInt(null);
        } catch (Throwable ignored) {

        }
        powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(field, getLocalClassName());
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (sensor == null){

        }
        //stopSelf();
        else
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_PROXIMITY)
        {
             /*if(sensorEvent.values[0]<=10)
             {
                 params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                 params.screenBrightness = 0;
                 getWindow().setAttributes(params);
             }else
             {
                 getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
             }
             if(wakeLock.isHeld()) {
                 wakeLock.release();
             }
          Toast.makeText(MainActivity.this,Float.toString(sensorEvent.values[0]),Toast.LENGTH_SHORT).show();*/
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    //

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        menu.add(0,777,0,"Reports");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==777){
            int reportCnt = PersistentUser.getReportCount(this.getApplicationContext());
            String title = "";
            if(reportCnt<=0){
                title = "No one reported you\nkeep using our service like this\n";
            }else{
                title = String.valueOf(reportCnt)+" users reported you\nBe careful\n";
            }
            title += "\nReport bad users\nIf you get 20 reports then you cannot use this app";
            new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setTitle("Warning")
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setMessage(title)
                    .create().show();
            return true;
        }
        if(id==R.id.action_profile){
            Intent intent = new Intent(MainActivityFemale.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        }
        if(id==R.id.action_instagram){
            Uri uri = Uri.parse(getResources().getString(R.string.instagram));
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
            return true;
        }else if(id==R.id.action_rate){
            Uri uri = Uri.parse("market://details?id=" + MainActivityFemale.this.getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=" + MainActivityFemale.this.getPackageName())));
            }
            return true;
        }else if(id==R.id.action_invite){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.share));
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }else if(id==R.id.action_privacy){
            Uri uri = Uri.parse(getResources().getString(R.string.privacy_policy));
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
            return true;
        }else if(id==R.id.action_contact){
            String[] TO_EMAILS = {"randomtalkbymoganstar@gmail.com"};
            //String[] CC = {};
            //String[] BCC = {};
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL,TO_EMAILS);
            //intent.putExtra(Intent.EXTRA_CC,CC);
            //intent.putExtra(Intent.EXTRA_BCC,BCC);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Random Talk App");
            intent.putExtra(Intent.EXTRA_TEXT,"Enter what you want to share with us here");
            startActivity(intent);
            return true;
        }
        return false;
    }

    // internet connection checking
    public boolean isInternetAvailable(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();
        if(netinfo!=null && netinfo.isConnectedOrConnecting()){
            return true;
        }
        return false;
    }
    //

}