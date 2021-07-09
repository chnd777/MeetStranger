package com.example.Meetstranger;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;
import com.example.Meetstranger.util.PersistentUser;

import java.math.BigInteger;
import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    private String deviceId = "null";

    long SPLASH_TIME = 3000;
    String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        deviceId = Settings.Secure.getString(this.getContentResolver(),Settings.Secure.ANDROID_ID);

        // reprots count
        PersistentUser.setReportCount(this.getApplicationContext(),0);
        int cnt[] = {0};
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("reports").child(deviceId);
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable String previousChildName) {
                cnt[0]++;
                PersistentUser.setReportCount(SplashActivity.this,cnt[0]);
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        //

        //
        int id1 = PersistentUser.getSpeakingTipsCount(this.getApplicationContext());
        int id2 = PersistentUser.getTongueTwistersCount(this.getApplicationContext());
        if(id1==-100||id2==-100){
            PersistentUser.setSpeakingTipsCount(this.getApplicationContext(),0);
            PersistentUser.setTongueTwistersCount(this.getApplicationContext(),0);
        }
        //

        // ads click count algorithm
        String time = PersistentUser.getTime(this.getApplicationContext());
        long ctime = System.currentTimeMillis()/1000;
        String cstime = String.valueOf(ctime);
        if(time.equals("null")){
            PersistentUser.setAdsCount(this.getApplicationContext(),0);
            PersistentUser.setTime(this.getApplicationContext(),cstime);
        }else{
            BigInteger b2 = new BigInteger(time);
            BigInteger b1 = new BigInteger(cstime);
            BigInteger dif = b1.subtract(b2);
            BigInteger cp = new BigInteger("10800"); // 1 hour = 60min*60sec = 3600sec // 3 hrs = 10800
            if(dif.compareTo(cp) > 0){
                PersistentUser.setAdsCount(this.getApplicationContext(),0);
                PersistentUser.setTime(this.getApplicationContext(),cstime);
            }
        }
        //

        // to create reminder for users to use this app
        createNotificationChannel();
        Intent intent = new Intent(SplashActivity.this,ReminderBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(SplashActivity.this,0,intent,0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        long timeAtOpeningThisActivity = System.currentTimeMillis();
        long extraTime = 1000*3600; // 1 hours = 3600 seconds
        alarmManager.set(AlarmManager.RTC_WAKEUP,
                timeAtOpeningThisActivity+extraTime,
                pendingIntent);
        //

        //
        if(PersistentUser.getDeviceId(this.getApplicationContext()).equals("null")){
            PersistentUser.setDeviceId(this.getApplicationContext(), deviceId);
        }
        if(!PersistentUser.isRegisteredBefore(this.getApplicationContext())){
            checkIfRegisteredBefore();
        }
        //

        internetCheckingDialog();

    }

    private void internetCheckingDialog(){
        if(!isInternetAvailable()){
            new AlertDialog.Builder(SplashActivity.this)
                    .setTitle("Connection Failed")
                    .setMessage(getResources().getString(R.string.internet_connection))
                    .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(!isInternetAvailable()){
                                internetCheckingDialog();
                            }else{
                                dialog.cancel();
                                goToOtherActivity();
                            }
                        }
                    })
                    .setCancelable(false)
                    .create().show();
        }else{
            goToOtherActivity();
        }
    }

    private void goToOtherActivity(){

        //
        TextView textView = findViewById(R.id.text_view);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        textView.startAnimation(animation);

        ImageView imageView = findViewById(R.id.image_view);
        imageView.startAnimation(animation);
        //

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(SPLASH_TIME);
                    if(isInternetAvailable()){
                        Intent i = new Intent(SplashActivity.this, RegisterActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.internet_connection),Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }

    //
    private void checkIfRegisteredBefore(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("UserDetails");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(Objects.equals(snapshot.getKey(), deviceId)){
                    PersistentUser.setRegisterBefore(SplashActivity.this,true);
                    for(DataSnapshot s : snapshot.getChildren()){
                        String key = s.getKey();
                        String value = s.getValue(String.class);
                        if(key.equals("user_age")){
                            PersistentUser.setUserAge(SplashActivity.this,value);
                        }else if(key.equals("user_gender")){
                            PersistentUser.setUserGender(SplashActivity.this,value);
                        }else if(key.equals("user_name")){
                            PersistentUser.setUserName(SplashActivity.this,value);
                        }else if(key.equals("user_number")){
                            PersistentUser.setUserNumber(SplashActivity.this,value);
                        }else if(key.equals("user_country_default")){
                            PersistentUser.setUserCountryDefault(SplashActivity.this,value);
                        }else if(key.equals("user_country_selected")){
                            PersistentUser.setUserCountrySelected(SplashActivity.this,value);
                        }
                    }
                }
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
    //

    //
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Random Talk and Global Chat Reminder";
            String description = "Reminder for using Random Talk and Global Chat app";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("reminder",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    //

    public boolean isInternetAvailable(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return (networkInfo!=null);
    }

}