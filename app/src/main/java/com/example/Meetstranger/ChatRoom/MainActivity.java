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

    //

    private Button chatRoom1,chatRoom2,chatRoom3;

    private String name;
    private int flag = 0;

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room_activity_main);



        name = PersistentUser.getUserName(this.getApplicationContext());


        // Joining chat rooms
        findViewById(R.id.chat_room1).setOnClickListener(v->{
            flag = 1;
            Intent intent = new Intent(MainActivity.this,ChatRoom.class);
            intent.putExtra("room_name",flag);
            intent.putExtra("user_name",name);
            startActivity(intent);

        });

        findViewById(R.id.chat_room2).setOnClickListener(v->{
            flag = 2;
            Intent intent = new Intent(MainActivity.this,ChatRoom.class);
            intent.putExtra("room_name",flag);
            intent.putExtra("user_name",name);
            startActivity(intent);

        });

        findViewById(R.id.chat_room3).setOnClickListener(v->{
            flag = 3;
            Intent intent = new Intent(MainActivity.this,ChatRoom.class);
            intent.putExtra("room_name",flag);
            intent.putExtra("user_name",name);
            startActivity(intent);

        });
        //

    }

}