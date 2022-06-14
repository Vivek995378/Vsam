package com.app.vsam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class UserMessageActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar messagetoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_message);

        changeStatusBarColor(this, "#1A1A1A");

        messagetoolbar = findViewById(R.id.messagetoolbar);
        setSupportActionBar(messagetoolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chat_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.block:
                Toast.makeText(this , "User Blocked" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.mute:
               // auth.signOut();
                Toast.makeText(this , "User Muted" , Toast.LENGTH_SHORT).show();
                break;

            case R.id.report:
                Toast.makeText(this , "User Reported" , Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void backMessages(View view) {
        onBackPressed();
    }
}