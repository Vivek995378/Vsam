package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class SettingsActivity extends AppCompatActivity {

    TextView tvFollowings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        changeStatusBarColor(this , "#1A1A1A");

        tvFollowings = findViewById(R.id.textView);

        tvFollowings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this , FollowingActivity.class));
            }
        });

    }
    public void backEditProfile(View view) {
        onBackPressed();
    }

    public void openProfileSettings(View view) {
        startActivity(new Intent(this, ProfileSettingsActivity.class));
    }

    public void openNotificationSettings(View view) {
        startActivity(new Intent(this, NotificationSettingsActivity.class));
    }
}