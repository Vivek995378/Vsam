package com.app.vsam.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.app.vsam.R;
import com.app.vsam.adapters.PostImageAdapter;
import com.app.vsam.models.PostData;

public class SaveFragment extends Fragment {

    private RecyclerView postRecyclerView;

    public SaveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save, container, false);

        postRecyclerView = view.findViewById(R.id.postRecyclerView);
        postRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3 , StaggeredGridLayoutManager.VERTICAL));
        init();

        return view;
    }

    private void init() {

        //Posts Adapter
        List<PostData> postData = new ArrayList<>();

        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.piccc));

        postRecyclerView.setAdapter(new PostImageAdapter(getActivity() , postData));

    }

}