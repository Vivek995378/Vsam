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
import com.app.vsam.adapters.FilterAdapter;
import com.app.vsam.models.LinkData;

public class StoryFragment extends Fragment {

    RecyclerView recyclerView;

    public StoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_story, container, false);

        recyclerView = view.findViewById(R.id.filterRecyclerView);
        init();

        return view;
    }

    private void init() {
        List<LinkData> data = new ArrayList<>();
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.ic_capture_image_black)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.ic_click_image)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.ic_filter1)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.ic_filter2)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.ic_filter3)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.ic_filter4)));

        FilterAdapter adapter = new FilterAdapter(data, getActivity());

        recyclerView.setAdapter(adapter);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        //Setting the space between stories
      //  recyclerView.addItemDecoration(new StoriesDecoration(10));


    }

}