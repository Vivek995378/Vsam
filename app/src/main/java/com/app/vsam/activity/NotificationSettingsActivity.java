package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class NotificationSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);
        changeStatusBarColor(this , "#1A1A1A");
    }

    public void backEditProfile(View view) {
        onBackPressed();
    }
}