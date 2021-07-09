package com.example.Meetstranger.ChatRoom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Meetstranger.GlobalChat.MessageActivity;
import com.example.Meetstranger.R;
import com.example.Meetstranger.util.PersistentUser;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    ArrayList<ChatData> chatData;
    Context context;

    public ChatAdapter(Context context,ArrayList<ChatData> chatData){
        this.context = context;
        this.chatData = chatData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // set Loop to ImageView
        holder.username.setText(chatData.get(position).getUserName());
        holder.message.setText(chatData.get(position).getMessage());
        holder.date.setText(chatData.get(position).getDate());

        if(chatData.get(position).getId().equals(PersistentUser.getDeviceId(context))){
            holder.relativeLayout.setBackground(ContextCompat.getDrawable(context,R.drawable.style_chat_item2));
        }


    }

    @Override
    public int getItemCount() {
        return chatData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView username,message,date;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.text_username);
            message = itemView.findViewById(R.id.text_message);
            date = itemView.findViewById(R.id.text_date);
            relativeLayout = itemView.findViewById(R.id.relative_layout);

            relativeLayout.setOnClickListener(v->{
                if(chatData.get(getPosition()).getId().equals(PersistentUser.getDeviceId(context))){
                    Toast.makeText(context,"You cannot message to yourself",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(context, MessageActivity.class);
                    intent.putExtra("userid",chatData.get(getPosition()).getId());
                    context.startActivity(intent);
                }
            });


        }
    }

}