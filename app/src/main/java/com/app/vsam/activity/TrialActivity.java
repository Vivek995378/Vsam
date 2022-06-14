package com.app.vsam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class TrialActivity extends AppCompatActivity {

    ImageView tag , edit , caption , location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit1);
        changeStatusBarColor(this, "#1A1A1A");

        tag = findViewById(R.id.imgTag);
        edit = findViewById(R.id.imgEdit);
        caption = findViewById(R.id.imgCaption);
        location = findViewById(R.id.imgLocation);

        tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrialActivity.this , TagActivity.class));
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrialActivity.this , EditActivity.class));
            }
        });
        caption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrialActivity.this , CaptionActivity.class));
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrialActivity.this , LocationActivity.class));
            }
        });

    }

}
