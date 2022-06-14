package com.app.vsam.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.setStatusTheme;

public class ReelsActivity extends AppCompatActivity{

    private VideoView videoBG;
    MediaPlayer mediaPlayer;
    int mCurrentVideoPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reels);
        setStatusTheme(this);

        videoBG = (VideoView) findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid);

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

    }

    @Override
    protected void onPause() {
        super.onPause();

        mCurrentVideoPosition = mediaPlayer.getCurrentPosition();
        videoBG.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }

}
