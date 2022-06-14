package com.app.vsam.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.FriendRequestAdapter;
import com.app.vsam.adapters.NotificationAdapter;
import com.app.vsam.models.BlockedUserData;
import com.app.vsam.models.NotificationData;

public class RequestFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<NotificationData> arrayList;
    private NotificationAdapter adapter;

    public RequestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_request, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        setData();

        return view;
    }

    private void setData() {

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
        list.add(new BlockedUserData("Vivek", "vivek9718" ,this.getResources().getDrawable(R.drawable.pic)));
        list.add(new BlockedUserData("Yashi", "yashi001",this.getResources().getDrawable(R.drawable.picc)));
        list.add(new BlockedUserData("Sahil", "sahil123",this.getResources().getDrawable(R.drawable.piccc)));
        list.add(new BlockedUserData("Rohit", "rohit_0085",this.getResources().getDrawable(R.drawable.picccc)));
        list.add(new BlockedUserData("Raj", "raj8700",this.getResources().getDrawable(R.drawable.piccccc)));

        FriendRequestAdapter adapter = new FriendRequestAdapter(getContext() , list);

        recyclerView.setAdapter(adapter);

    }

}