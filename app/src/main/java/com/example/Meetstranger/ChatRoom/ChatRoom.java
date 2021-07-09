package com.example.Meetstranger.ChatRoom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.Meetstranger.R;
import com.example.Meetstranger.util.PersistentUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatRoom extends AppCompatActivity {

    private String deviceId = "";

    RecyclerView recyclerView;
    EditText editText;

    ArrayList<ChatData> chatData;
    ChatAdapter chatAdapter;

    private String user_name,room_name;

    DatabaseReference reference;
    String temp_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room);

        deviceId = PersistentUser.getDeviceId(this.getApplicationContext());

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);
        linearLayoutManager.setStackFromEnd(true);
        //linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        editText = findViewById(R.id.edit_text);

        chatData = new ArrayList<>();

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        user_name = getIntent().getExtras().get("user_name").toString();
        room_name = "chatroom";
        room_name += String.valueOf(getIntent().getExtras().getInt("room_name"));
        
        reference = FirebaseDatabase.getInstance().getReference().child("chatrooms").child(room_name);
        setTitle(" Room - "+room_name);

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                append_chat(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                append_chat(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                append_chat(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        chatAdapter = new ChatAdapter(ChatRoom.this,chatData);
        recyclerView.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void send(View v)
    {
        if(TextUtils.isEmpty(editText.getText().toString().trim())){
            Toast.makeText(getApplicationContext(),"Enter some message to send it",Toast.LENGTH_SHORT).show();
            editText.setText("");
            return;
        }
        // Getting Current date
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY"); // todo : error came and seen in 17-05-2021 after 9 9.0 release in this day.
        String dateString = dateFormat.format(calendar.getTime());
        String date = "~"+dateString;
        //

        Map<String,Object> map = new HashMap<String,Object>();
        temp_key = reference.push().getKey();
        reference.updateChildren(map);

        DatabaseReference child_ref = reference.child(temp_key);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("name",user_name);
        map2.put("msg", editText.getText().toString());
        map2.put("date",date); // todo : look for adjusting different time zones
        map2.put("id",deviceId);
        child_ref.updateChildren(map2).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        editText.setText("");
        chatAdapter.notifyDataSetChanged();
    }

    public void append_chat(DataSnapshot ss)
    {
        String chat_date,chat_id,chat_msg,chat_username;
        Iterator i = ss.getChildren().iterator();
        while(i.hasNext())
        {
            chat_date = ((DataSnapshot)i.next()).getValue().toString();
            chat_id = ((DataSnapshot)i.next()).getValue().toString();
            chat_msg = ((DataSnapshot)i.next()).getValue().toString();
            chat_username = ((DataSnapshot)i.next()).getValue().toString();
            chatData.add(new ChatData(chat_username,chat_msg,chat_date,chat_id));
            //textView.append(chat_username+" :\n"+chat_msg+"\n"+"-------------------------\n");
        }
        chatAdapter.notifyDataSetChanged();
    }

}