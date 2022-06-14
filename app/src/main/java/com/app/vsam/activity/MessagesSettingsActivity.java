package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class MessagesSettingsActivity extends AppCompatActivity {

    TextView messagesPrivacy , block , mute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_settings);
        changeStatusBarColor(this, "#1A1A1A");

        messagesPrivacy = findViewById(R.id.tvPrivacy);
        block = findViewById(R.id.tvBlock);
        mute = findViewById(R.id.tvMute);

        Intent intent1 = new Intent(this , MessagesPrivacyActivity.class);
        Intent intent2 = new Intent(this , BlockedUserActivity.class);
        Intent intent3 = new Intent(this , MutedUsersActivity.class);

        messagesPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
        block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });
    }

    public void backMessages(View view) {
        onBackPressed();
    }
}