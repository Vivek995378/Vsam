package com.app.vsam.fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.app.vsam.R;

public class FlashFragment extends Fragment {

    private VideoView videoBG;
    public MediaPlayer mediaPlayer;
    int mCurrentVideoPosition;

    public FlashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flash, container, false);

        videoBG = (VideoView) view.findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.vid);

        videoBG.setVideoURI(uri);
        videoBG.start();

        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer = mp;
                mediaPlayer.setLooping(true);
                if(mCurrentVideoPosition != 0)
                {
                    mediaPlayer.seekTo(mCurrentVideoPosition);
                    mediaPlayer.start();
                }
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        mCurrentVideoPosition = mediaPlayer.getCurrentPosition();
        videoBG.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }

}