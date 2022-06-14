package com.app.vsam.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.app.vsam.R;
import com.app.vsam.adapters.LinkAdapter;
import com.app.vsam.models.LinkData;

public class LinkFragment extends Fragment {

    RecyclerView recyclerView;
    
    public LinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_link, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        init();

        return view;
    }

    private void init() {

        //Posts Adapter
        List<LinkData> posts = new ArrayList<>();
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link1)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link2)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link3)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link4)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link5)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link6)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link7)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link8)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link9)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link10)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link1)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link2)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link3)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link4)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link5)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link6)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link7)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link8)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link9)));
        posts.add(new LinkData(this.getResources().getDrawable(R.drawable.link10)));


        LinkAdapter adapter = new LinkAdapter(posts , getActivity());

        recyclerView.setAdapter(adapter);

    }
    
}