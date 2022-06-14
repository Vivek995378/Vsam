package com.app.vsam.splash;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import com.app.vsam.R;
import com.app.vsam.activity.HomeActivity;
import com.app.vsam.login.LoginActivity;
import com.app.vsam.util.AppPreference;

import static com.app.vsam.util.AppUtil.printHashKeyForFacebook;
import static com.app.vsam.util.AppUtil.saveFirebaseToken;
import static com.app.vsam.util.AppUtil.setStatusTheme;

import androidx.annotation.Nullable;

public class SplashActivity extends Activity implements MediaPlayer.OnCompletionListener
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setStatusTheme(this);
        saveFirebaseToken(this);
        printHashKeyForFacebook(this);

        VideoView video = (VideoView) findViewById(R.id.videoView);
        video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.splash);
        video.start();
        video.setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mp)
    {
        if (AppPreference.isUserLoggedIn(SplashActivity.this)) {
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }
        finish();
    }
}