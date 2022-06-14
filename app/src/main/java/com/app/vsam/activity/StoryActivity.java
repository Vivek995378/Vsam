package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class StoryActivity extends AppCompatActivity {

    ImageView  caption;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        changeStatusBarColor(this, "#1A1A1A");

        caption = findViewById(R.id.imgCaption);

        caption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoryActivity.this , CaptionActivity.class));
            }
        });
    }
}