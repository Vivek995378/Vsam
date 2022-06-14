package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class CaptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caption);
        changeStatusBarColor(this, "#1A1A1A");
    }
}