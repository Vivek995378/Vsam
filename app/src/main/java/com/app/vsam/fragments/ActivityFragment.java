package com.app.vsam.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.NotificationAdapter;
import com.app.vsam.models.NotificationData;

public class ActivityFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<NotificationData> arrayList;
    private NotificationAdapter adapter;

    public ActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        setData();

        return view;
    }

    private void setData() {

        arrayList = new ArrayList<>();
        arrayList.add(new NotificationData("Rahul_97" , "James like your post." , this.getResources().getDrawable(R.drawable.pic) , this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Sunny_oo1" , "Shared your post/flash." , this.getResources().getDrawable(R.drawable.picc), this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Rohit123" , "Tagged you in Flash." , this.getResources().getDrawable(R.drawable.piccc) , this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Vijay231" , "Action taken against the post/flash you report." , this.getResources().getDrawable(R.drawable.pic) , this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new NotificationData("Yashi_9810" , "James mentioned you in a comment." , this.getResources().getDrawable(R.drawable.piccc), this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new NotificationData("Vivek_9718" , "Comment on a post you're tagged in." , this.getResources().getDrawable(R.drawable.piccccc), this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Rahul123" , "James like your post." , this.getResources().getDrawable(R.drawable.pic) , this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Sunny563" , "Shared your post/flash." , this.getResources().getDrawable(R.drawable.picc), this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new NotificationData("Rohit231" , "Tagged you in Flash." , this.getResources().getDrawable(R.drawable.piccc), this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Vijay_oo2" , "Action taken against the post/flash you report." , this.getResources().getDrawable(R.drawable.pic), this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new NotificationData("Yashi_9718" , "James mentioned you in a comment." , this.getResources().getDrawable(R.drawable.piccc), this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Vivek_9810" , "James like your post." , this.getResources().getDrawable(R.drawable.piccccc), this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Rahul_9991" , "Shared your post/flash." , this.getResources().getDrawable(R.drawable.pic), this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Sunny_441" , "Tagged you in Flash." , this.getResources().getDrawable(R.drawable.picc), this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new NotificationData("Rohit231" , "Action taken against the post/flash you report." , this.getResources().getDrawable(R.drawable.piccc), this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new NotificationData("Vijay001" , "James mentioned you in a comment." , this.getResources().getDrawable(R.drawable.pic), this.getResources().getDrawable(R.drawable.picc)));
        arrayList.add(new NotificationData("Yashi_9810" , "Comment on a post you're tagged in." , this.getResources().getDrawable(R.drawable.piccc), this.getResources().getDrawable(R.drawable.pic)));
        arrayList.add(new NotificationData("Vivek_9718" , "James like your post." , this.getResources().getDrawable(R.drawable.piccccc), this.getResources().getDrawable(R.drawable.pic)));

        adapter = new NotificationAdapter(getContext() , arrayList);
        recyclerView.setAdapter(adapter);

    }
}