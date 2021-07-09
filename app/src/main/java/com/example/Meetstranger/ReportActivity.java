package com.example.Meetstranger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.Meetstranger.util.PersistentUser;

public class ReportActivity extends AppCompatActivity {

    String deviceId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        deviceId = PersistentUser.getDeviceId(this.getApplicationContext());

        findViewById(R.id.unblock).setOnClickListener(v->{
            String[] TO_EMAILS = {"randomtalkbymoganstar@gmail.com"};
            //String[] CC = {};
            //String[] BCC = {};
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL,TO_EMAILS);
            //intent.putExtra(Intent.EXTRA_CC,CC);
            //intent.putExtra(Intent.EXTRA_BCC,BCC);
            intent.putExtra(Intent.EXTRA_SUBJECT,"UNBLOCK ME "+deviceId);
            intent.putExtra(Intent.EXTRA_TEXT,"state the reason why more users are blocking you");
            startActivity(intent);
        });

    }
}