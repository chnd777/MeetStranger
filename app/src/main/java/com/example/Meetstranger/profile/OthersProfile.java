package com.example.Meetstranger.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.example.Meetstranger.GlobalChat.Model.User;
import com.example.Meetstranger.R;
import com.example.Meetstranger.util.PersistentUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class OthersProfile extends AppCompatActivity {

    private String deviceId = "",toDeviceId = "";

    private CircleImageView profile_image;
    private TextView username;

    private TextView tvUserName,tvUserAge,tvUserGender,tvUserPhone;
    private String userName,userAge,userGender,userPhone;

    private int imageFlag = 0;
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_others_profile);

        deviceId = PersistentUser.getDeviceId(this.getApplicationContext());
        toDeviceId = getIntent().getStringExtra("userId");

        profile_image = findViewById(R.id.profile_image);
        username = findViewById(R.id.username);
        tvUserName = findViewById(R.id.tv_user_name);
        tvUserAge = findViewById(R.id.tv_user_age);
        tvUserGender = findViewById(R.id.tv_user_gender);
        tvUserPhone = findViewById(R.id.tv_user_phone);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("globalchat").child("Users").child(toDeviceId);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                username.setText(user.getUsername());
                if(user.getImageURL().equals("default")){
                    profile_image.setImageResource(R.mipmap.default_user);
                }else{
                    imageFlag = 1;
                    imageUrl = user.getImageURL();
                    Glide.with(getApplicationContext()).load(user.getImageURL()).into(profile_image);
                }
                tvUserName.setText(user.getUsername());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("UserDetails").child(toDeviceId);
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                String key = dataSnapshot.getKey();
                String value = dataSnapshot.getValue(String.class);
                if(key.equals("user_age")){
                    tvUserAge.setText(value);
                }else if(key.equals("user_gender")){
                    tvUserGender.setText(value);
                }else if(key.equals("user_number")){
                    tvUserPhone.setText(value);
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

        profile_image.setOnClickListener(v->{
            Intent intent = new Intent(OthersProfile.this, ImageView.class);
            intent.putExtra("imageFlag",imageFlag);
            intent.putExtra("imageUrl",imageUrl);
            startActivity(intent);
        });

    }
}