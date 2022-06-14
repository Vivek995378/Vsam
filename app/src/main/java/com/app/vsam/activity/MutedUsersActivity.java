package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.MuteAdapter;
import com.app.vsam.models.BlockedUserData;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class MutedUsersActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muted_users);
        changeStatusBarColor(this , "#1A1A1A");

        recyclerView = findViewById(R.id.rv_mute);
        init();
    }

    private void init() {

        //Blocked list Adapter
        ArrayList<BlockedUserData> list = new ArrayList<>();
        list.add(new BlockedUserData("Vivek", "vivek9718" ,this.getResources().getDrawable(R.drawable.pic)));
        list.add(new BlockedUserData("Yashi", "yashi001",this.getResources().getDrawable(R.drawable.picc)));
        list.add(new BlockedUserData("Sahil", "sahil123",this.getResources().getDrawable(R.drawable.piccc)));
        list.add(new BlockedUserData("Rohit", "rohit_0085",this.getResources().getDrawable(R.drawable.picccc)));
        list.add(new BlockedUserData("Raj", "raj8700",this.getResources().getDrawable(R.drawable.piccccc)));
        list.add(new BlockedUserData("Vivek", "vivek9718" ,this.getResources().getDrawable(R.drawable.pic)));
        list.add(new BlockedUserData("Yashi", "yashi001",this.getResources().getDrawable(R.drawable.picc)));
        list.add(new BlockedUserData("Sahil", "sahil123",this.getResources().getDrawable(R.drawable.piccc)));
        list.add(new BlockedUserData("Rohit", "rohit_0085",this.getResources().getDrawable(R.drawable.picccc)));
        list.add(new BlockedUserData("Raj", "raj8700",this.getResources().getDrawable(R.drawable.piccccc)));

        MuteAdapter adapter = new MuteAdapter(this , list);

        recyclerView.setAdapter(adapter);

    }

    public void backMessages(View view) {
        onBackPressed();
    }

}