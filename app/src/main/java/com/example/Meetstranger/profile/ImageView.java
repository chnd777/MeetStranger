package com.example.Meetstranger.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.Meetstranger.R;

public class ImageView extends AppCompatActivity {

    int imageFlag = 0;
    String imageUrl = "";
    private android.widget.ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gc_image_view);

        imageView = findViewById(R.id.image_view);

        Intent in = getIntent();
        imageFlag = in.getIntExtra("imageFlag",0);
        if(imageFlag==1){
            imageUrl = in.getStringExtra("imageUrl");
            Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        }

    }

}
