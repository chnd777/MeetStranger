package com.example.Meetstranger.ChatRoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.example.Meetstranger.R;
import com.example.Meetstranger.util.PersistentUser;

public class MainActivity extends AppCompatActivity {

    // Facebook Ads
    private InterstitialAd interstitialAd;
    private InterstitialAdListener interstitialAdListener;
    private int adscount = 0;
    private int maxadscount = 0;
    //

    private Button chatRoom1,chatRoom2,chatRoom3;

    private String name;
    private int flag = 0;

    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room_activity_main);

        adscount = PersistentUser.getAdsCount(this.getApplicationContext());
        maxadscount = getResources().getInteger(R.integer.maxadscount);

        name = PersistentUser.getUserName(this.getApplicationContext());

        // Facebook Ads
        // Initialize the Audience Network SDK
        AudienceNetworkAds.initialize(this);
        interstitialAd = new InterstitialAd(this,getResources().getString(R.string.fb_chat_room_interstitial_ad));
        interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                loadAds();
                if(flag!=0){
                    Intent intent = new Intent(MainActivity.this,ChatRoom.class);
                    intent.putExtra("room_name",flag);
                    intent.putExtra("user_name",name);
                    startActivity(intent);
                }else{
                    Log.e("Chatrooms Main Activity","some error in that");
                }
            }

            @Override
            public void onError(Ad ad, AdError adError) {
            }

            @Override
            public void onAdLoaded(Ad ad) {
            }

            @Override
            public void onAdClicked(Ad ad) {
                adscount++;
                PersistentUser.setAdsCount(MainActivity.this,adscount);
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        loadAds();
        //

        // Joining chat rooms
        findViewById(R.id.chat_room1).setOnClickListener(v->{
            flag = 1;
            if(interstitialAd.isAdInvalidated() || !interstitialAd.isAdLoaded() || interstitialAd==null){
                loadAds();
                Intent intent = new Intent(MainActivity.this,ChatRoom.class);
                intent.putExtra("room_name",flag);
                intent.putExtra("user_name",name);
                startActivity(intent);
            }else{
                interstitialAd.show();
            }
        });

        findViewById(R.id.chat_room2).setOnClickListener(v->{
            flag = 2;
            if(interstitialAd.isAdInvalidated() || !interstitialAd.isAdLoaded() || interstitialAd==null){
                loadAds();
                Intent intent = new Intent(MainActivity.this,ChatRoom.class);
                intent.putExtra("room_name",flag);
                intent.putExtra("user_name",name);
                startActivity(intent);
            }else{
                interstitialAd.show();
            }
        });

        findViewById(R.id.chat_room3).setOnClickListener(v->{
            flag = 3;
            if(interstitialAd.isAdInvalidated() || !interstitialAd.isAdLoaded() || interstitialAd==null){
                loadAds();
                Intent intent = new Intent(MainActivity.this,ChatRoom.class);
                intent.putExtra("room_name",flag);
                intent.putExtra("user_name",name);
                startActivity(intent);
            }else{
                interstitialAd.show();
            }
        });
        //

    }

    private void loadAds(){
        if(adscount<=maxadscount){
            interstitialAd.loadAd(
                    interstitialAd.buildLoadAdConfig()
                            .withAdListener(interstitialAdListener)
                            .build());
        }
    }

}