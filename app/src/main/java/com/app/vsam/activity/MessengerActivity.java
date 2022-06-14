package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.MessengerAdapter;
import com.app.vsam.models.MessengerData;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class MessengerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MessengerData> arrayList;
    private MessengerAdapter adapter;
    ImageView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        changeStatusBarColor(this, "#1A1A1A");
        settings = findViewById(R.id.setting);

        recyclerView = findViewById(R.id.recyclerView);
        setData();

        Intent intent = new Intent(this , MessagesSettingsActivity.class);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        
    }

    private void setData() {

        arrayList = new ArrayList<>();
        arrayList.add(new MessengerData("Rahul" , "Hi there" , "4 min ago" , this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new MessengerData("Sunny" , "Always rock" , "5 min ago" , this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new MessengerData("Rohit" , "Text only" , "6 min ago" , this.getResources().getDrawable(R.drawable.piccc)));
        arrayList.add(new MessengerData("Vijay" , "Available" , "7 min ago" , this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new MessengerData("Yashi" , "No calls" , "8 min ago" , this.getResources().getDrawable(R.drawable.piccc)));
        arrayList.add(new MessengerData("Vivek" , "Hi ." , "9 min ago" , this.getResources().getDrawable(R.drawable.piccccc)));
        arrayList.add(new MessengerData("Rahul" , "Hi there" , "4 min ago" , this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new MessengerData("Sunny" , "Always rock" , "5 min ago" , this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new MessengerData("Rohit" , "Text only" , "6 min ago" , this.getResources().getDrawable(R.drawable.piccc)));
        arrayList.add(new MessengerData("Vijay" , "Available" , "7 min ago" , this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new MessengerData("Yashi" , "No calls" , "8 min ago" , this.getResources().getDrawable(R.drawable.piccc)));
        arrayList.add(new MessengerData("Vivek" , "Hi ." , "9 min ago" , this.getResources().getDrawable(R.drawable.piccccc)));

        adapter = new MessengerAdapter(this , arrayList);
        recyclerView.setAdapter(adapter);

    }

    public void backMessages(View view) {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}