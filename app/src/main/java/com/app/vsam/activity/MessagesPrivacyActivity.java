package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class MessagesPrivacyActivity extends AppCompatActivity {

    TextView lastSeen;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_privacy);
        changeStatusBarColor(this , "#1A1A1A");

        lastSeen = findViewById(R.id.tvLastSeen);
        dialog = new Dialog(this);

        lastSeen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.getWindow().setContentView(R.layout.custom_last_seen_dialog);
                dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                // dialog.getWindow().setGravity(Gravity.BOTTOM);
                dialog.show();
            }
        });
    }

    public void backMessages(View view) {
        onBackPressed();
    }
}