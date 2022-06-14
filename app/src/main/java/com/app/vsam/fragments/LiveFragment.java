package com.app.vsam.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.LiveScreenAdapter;
import com.app.vsam.models.BlockedUserData;

public class LiveFragment extends Fragment {

    private RecyclerView recyclerView;
    private SurfaceView surfaceView;
    public MediaPlayer mediaPlayer;

    public LiveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

//        surfaceView = view.findViewById(R.id.surfaceView);
//
//        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.livevedio);
//        SurfaceHolder surfaceHolder = surfaceView.getHolder();
//        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(@NonNull SurfaceHolder holder) {
//                mediaPlayer.setDisplay(surfaceHolder);
//            }
//
//            @Override
//            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
//
//            }
//
//            @Override
//            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
//                mediaPlayer.pause();
//            }
//        });

        init();

        return view;
    }

    private void init() {

        //Blocked list Adapter
        ArrayList<BlockedUserData> list = new ArrayList<>();
        list.add(new BlockedUserData("Vivek", "You really know how to dress well", this.getResources().getDrawable(R.drawable.pic)));
        list.add(new BlockedUserData("Yashi", "Looking awesome Million-dollar smile!", this.getResources().getDrawable(R.drawable.picc)));
        list.add(new BlockedUserData("Sahil", "Whats upp", this.getResources().getDrawable(R.drawable.piccc)));
        list.add(new BlockedUserData("Rohit", "Well looking gorgeous, Arresting in beauty", this.getResources().getDrawable(R.drawable.picccc)));
        list.add(new BlockedUserData("Raj", "How are you", this.getResources().getDrawable(R.drawable.piccccc)));
        list.add(new BlockedUserData("Vivek", "What do you do", this.getResources().getDrawable(R.drawable.pic)));
        list.add(new BlockedUserData("Yashi", "Hate you", this.getResources().getDrawable(R.drawable.picc)));
        list.add(new BlockedUserData("Sahil", "Whats going on", this.getResources().getDrawable(R.drawable.piccc)));
        list.add(new BlockedUserData("Rohit", "Heyy buddy", this.getResources().getDrawable(R.drawable.picccc)));

        LiveScreenAdapter adapter = new LiveScreenAdapter(getActivity(), list);

        recyclerView.setAdapter(adapter);

    }

}