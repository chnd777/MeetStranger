package com.example.Meetstranger.GlobalChat.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.Meetstranger.GlobalChat.Adapter.UserAdapter;
import com.example.Meetstranger.GlobalChat.Model.Chat;
import com.example.Meetstranger.GlobalChat.Model.User;
import com.example.Meetstranger.R;
import com.example.Meetstranger.util.PersistentUser;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {

    private String deviceId = "";

    private RecyclerView recyclerView;

    private UserAdapter userAdapter;
    private List<User> mUsers;

    DatabaseReference reference;

    private List<String> usersList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gc_fragment_chats,container,false);

        deviceId = PersistentUser.getDeviceId(this.getActivity());

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        usersList = new ArrayList<>();

        //
        reference = FirebaseDatabase.getInstance().getReference().child("globalchat").child("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Chat chat = snapshot.getValue(Chat.class);

                    if(chat.getSender().equals(deviceId)){
                        usersList.add(chat.getReceiver());
                    }
                    if(chat.getReceiver().equals(deviceId)){
                        usersList.add(chat.getSender());
                    }
                }

                readChats();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //

        return view;
    }

    // readChats
    private void readChats(){
        mUsers = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference().child("globalchat").child("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUsers.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);

                    // this is our own imple
                    for(String id : usersList){
                        if(user.getId().equals(id)){
                            if(mUsers.size()!=0){
                                int tFlag = 1;
                                for(User user1 : mUsers){
                                    if(user.getId().equals(user1.getId())){
                                        tFlag = 0;
                                    }
                                }
                                if(tFlag==1){
                                    mUsers.add(user);
                                }
                            }else{
                                mUsers.add(user);
                            }
                        }
                    }

                }

                userAdapter = new UserAdapter(getContext(),mUsers,true);
                recyclerView.setAdapter(userAdapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //

}