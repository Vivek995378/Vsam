package com.app.vsam.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import com.app.vsam.R;
import com.app.vsam.activity.MessengerActivity;
import com.app.vsam.activity.NotificationActivity;
import com.app.vsam.adapters.CommentAdapter;
import com.app.vsam.adapters.PostsAdapter;
import com.app.vsam.models.BlockedUserData;
import com.app.vsam.models.LinkData;

public class HomeFragment extends Fragment {

    RecyclerView storiesBar , recyclerView;
    RecyclerView postsBar;
    ImageView messenger , notifications ;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        storiesBar = view.findViewById(R.id.recyclerView1);
        postsBar = view.findViewById(R.id.recyclerView2);
        messenger = view.findViewById(R.id.messenger);
        notifications = view.findViewById(R.id.notfications);

//        recyclerView = view.findViewById(R.id.recyclerView);
//        initComment();
        
        messenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MessengerActivity.class));
            }
        });

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NotificationActivity.class));
            }
        });

        init();

        return view;
    }

    private void initComment() {

        //Blocked list Adapter
        ArrayList<BlockedUserData> list = new ArrayList<>();
        list.add(new BlockedUserData("vivek9718", "1 min ago" ,this.getResources().getDrawable(R.drawable.pic)));
        list.add(new BlockedUserData("yashi001", "38 min ago",this.getResources().getDrawable(R.drawable.picc)));
        list.add(new BlockedUserData("sahil123", "4 min ago",this.getResources().getDrawable(R.drawable.piccc)));
        list.add(new BlockedUserData("rohit_0085", "42 min ago",this.getResources().getDrawable(R.drawable.picccc)));
        list.add(new BlockedUserData("raj8700", "3 min ago",this.getResources().getDrawable(R.drawable.piccccc)));
        list.add(new BlockedUserData("vivek9718", "13 min ago" ,this.getResources().getDrawable(R.drawable.pic)));
        list.add(new BlockedUserData("yashi001", "35 min ago",this.getResources().getDrawable(R.drawable.picc)));
        list.add(new BlockedUserData("sahil123", "24 min ago",this.getResources().getDrawable(R.drawable.piccc)));
        list.add(new BlockedUserData("rohit_0085", "17 min ago",this.getResources().getDrawable(R.drawable.picccc)));
        list.add(new BlockedUserData("raj8700", "34 min ago",this.getResources().getDrawable(R.drawable.piccccc)));

        CommentAdapter adapter = new CommentAdapter(getActivity() , list);
        recyclerView.setAdapter(adapter);
    }

    private void init()
    {
        List<LinkData> data = new ArrayList<>();
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.pic)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.picc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.piccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.picccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.piccccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.pic)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.picc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.piccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.pic)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.picc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.piccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.picccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.piccccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.pic)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.picc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.piccc)));

        PostsAdapter adapter1 = new PostsAdapter(data , getActivity());

        postsBar.setAdapter(adapter1);
        postsBar.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL , false));

    }
    @Override
    public void onStop() {
        super.onStop();
        getActivity().finish();
    }

}