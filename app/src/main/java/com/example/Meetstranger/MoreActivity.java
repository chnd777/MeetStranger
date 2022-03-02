package com.example.Meetstranger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.Meetstranger.grammar.VocabularyActivity;
import com.example.Meetstranger.util.PersistentUser;

public class MoreActivity extends AppCompatActivity {

    private GridView gridView;

    int icons[] = {
            R.drawable.more1,
            R.drawable.more2,
            R.drawable.more3,
            R.drawable.more4,
            R.drawable.more5,
    };

    String name[] = {
            "Chat Rooms",
            "Global Chat",
            "Speaking Tips",
            "Tongue Twisters",
            "Vocabulary & Grammar",
    };

    private int speaking_tips = 0;
    private int speaking_tips_max = 0;
    private String[] st;
    private int tongue_twisters = 0;
    private int tongue_twisters_max = 0;
    private String[] tt;

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        speaking_tips = PersistentUser.getSpeakingTipsCount(this.getApplicationContext());
        speaking_tips_max = getResources().getInteger(R.integer.speaking_tips_count);
        st = getResources().getStringArray(R.array.speaking_tips);
        tongue_twisters = PersistentUser.getTongueTwistersCount(this.getApplicationContext());
        tongue_twisters_max = getResources().getInteger(R.integer.tongue_twisters_count);
        tt = getResources().getStringArray(R.array.tongue_twisters);



        gridView = findViewById(R.id.grid_view);
        MoreAdapter adapter = new MoreAdapter(name,icons,getApplicationContext());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                pos++;
                if(pos==1){
                    if(!isInternetAvailable()){
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.internet_connection),Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(MoreActivity.this,com.example.Meetstranger.ChatRoom.MainActivity.class);
                        startActivity(intent);
                    }
                }else if(pos==2){
                    if(!isInternetAvailable()){
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.internet_connection),Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(MoreActivity.this,com.example.Meetstranger.GlobalChat.MainActivity.class);
                        startActivity(intent);
                    }
                }else if(pos==3){
                    speakingTips();
                }else if(pos==4){
                    tongueTwisters();
                }else if(pos==5){
                    vocabulayAndGrammar();
                }else if(pos==6){
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.moganstar.activegroups");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }else if(pos==7){
                    Toast.makeText(getApplicationContext(),"More Features will be added soon.\n" +
                            "Suggest us to add new feature you want by writing a mail to randomtalkbymoganstar@gmail.com",Toast.LENGTH_SHORT).show();

                }
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(getApplicationContext(),name[pos],Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    private void speakingTips(){
        speaking_tips++;
        PersistentUser.setSpeakingTipsCount(MoreActivity.this,speaking_tips);
        speaking_tips %= speaking_tips_max;
        new AlertDialog.Builder(MoreActivity.this)
                .setTitle("Speaking Tips")
                .setMessage(st[speaking_tips])
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        speakingTips();
                    }
                })
                .setCancelable(false)
                .create().show();
    }

    private void tongueTwisters(){
        tongue_twisters++;
        PersistentUser.setTongueTwistersCount(MoreActivity.this,tongue_twisters);
        tongue_twisters %= tongue_twisters_max;
        new AlertDialog.Builder(MoreActivity.this)
                .setTitle("Tongue Twisters")
                .setMessage(tt[tongue_twisters])
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tongueTwisters();
                    }
                })
                .setCancelable(false)
                .create().show();
    }

    private void vocabulayAndGrammar(){
        Intent intent = new Intent(MoreActivity.this, VocabularyActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_invite){
            Intent intentInvite = new Intent(Intent.ACTION_SEND);
            intentInvite.setType("text/plain");
            String body = "https://github.com/chnd777/moneyManager/blob/master/Money-manager.apk?raw=true";
            String subject = "Your Subject";
            intentInvite.putExtra(Intent.EXTRA_SUBJECT, subject);
            intentInvite.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(intentInvite, "Share using"));
            return true;
        }else if(id==R.id.action_contact){
            String[] TO_EMAILS = {"chndmalla@gmail.com"};
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL,TO_EMAILS);
            intent.putExtra(Intent.EXTRA_SUBJECT,"App Meet Strangers");
            intent.putExtra(Intent.EXTRA_TEXT,"Enter what you want to share with us here");
            startActivity(intent);
            return true;
        }
        return false;
    }

    // internet connection checking
    public boolean isInternetAvailable(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if(netInfo!=null && netInfo.isConnectedOrConnecting()){
            return true;
        }
        return false;
    }

}