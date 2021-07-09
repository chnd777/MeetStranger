package com.example.Meetstranger.GlobalChat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.Meetstranger.GlobalChat.Fragments.ChatsFragment;
import com.example.Meetstranger.GlobalChat.Fragments.UsersFragment;
import com.example.Meetstranger.GlobalChat.Model.User;
import com.example.Meetstranger.R;
import com.example.Meetstranger.profile.ProfileActivity;
import com.example.Meetstranger.util.PersistentUser;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private String userGender = "default";

    CircleImageView profile_image;
    TextView username;
    private String deviceId = "";
    DatabaseReference reference;

    // Facebook Ads
    private InterstitialAd interstitialAd;
    private InterstitialAdListener interstitialAdListener;
    private int adscount = 0;
    private int maxadscount = 0;

    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gc_activity_main);

        userGender = PersistentUser.getUserGender(this.getApplicationContext());

        // facebook ads
        adscount = PersistentUser.getAdsCount(this.getApplicationContext());
        maxadscount = getResources().getInteger(R.integer.maxadscount);

        AudienceNetworkAds.initialize(this);
        interstitialAd = new InterstitialAd(this,getResources().getString(R.string.fb_interstitial_ad2));
        interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                loadAds();
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
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
                PersistentUser.setAdsCount(com.example.Meetstranger.GlobalChat.MainActivity.this,adscount);
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        loadAds();
        //

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        initializeViews();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                username.setText(user.getUsername());
                if(user.getImageURL().equals("default")){
                    profile_image.setImageResource(R.mipmap.default_user);
                }else{
                    Glide.with(getApplicationContext()).load(user.getImageURL()).into(profile_image);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new ChatsFragment(),"Chats");
        viewPagerAdapter.addFragment(new UsersFragment(),"Users");
        //viewPagerAdapter.addFragment(new ProfileFragment(),"Profile");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        profile_image.setOnClickListener(v->{
            openOtherActivity();
        });
        username.setOnClickListener(v->{
            openOtherActivity();
        });

    }

    private void loadAds(){
        if(adscount<=maxadscount){
            interstitialAd.loadAd(
                    interstitialAd.buildLoadAdConfig()
                            .withAdListener(interstitialAdListener)
                            .build());
        }
    }

    private void openOtherActivity(){
        if(interstitialAd==null || interstitialAd.isAdInvalidated() || !interstitialAd.isAdLoaded()){
            loadAds();
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }else{
            interstitialAd.show();
        }
    }

    private void initializeViews() {
        deviceId = PersistentUser.getDeviceId(this.getApplicationContext());
        profile_image = findViewById(R.id.profile_image);
        username = findViewById(R.id.username);
        reference = FirebaseDatabase.getInstance().getReference().child("globalchat").child("Users").child(deviceId);
    }

    // Class ViewPagerAdapter extends FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        ViewPagerAdapter(FragmentManager fm){
            super(fm);
            this.fragments = new ArrayList<>();
            this.titles = new ArrayList<>();
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment(Fragment fragment,String title){
            fragments.add(fragment);
            titles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
    //

    private void status(String status){
        reference = FirebaseDatabase.getInstance().getReference().child("globalchat").child("Users").child(deviceId);

        HashMap<String , Object> hashMap = new HashMap<>();
        hashMap.put("status",status);

        reference.updateChildren(hashMap);
    }

    @Override
    protected void onResume() {
        super.onResume();
        status("online");
    }

    @Override
    protected void onPause() {
        super.onPause();
        status("offline");
    }

    // todo mainly
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(userGender.equals("male")){
            menu.add(0,0,0,"Only Female Users");
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle().equals("Only Female Users")){
            Intent intent = new Intent(MainActivity.this,FemaleUsers.class);
            startActivity(intent);
        }
        return false;
    }
    //
}