package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        changeStatusBarColor(this, "#1A1A1A");
    }
}