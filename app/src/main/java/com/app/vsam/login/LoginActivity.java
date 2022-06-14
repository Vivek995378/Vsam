package com.app.vsam.login;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.vsam.R;
import com.app.vsam.webView.WebViewActivity;

import static com.app.vsam.util.AppUtil.setHomeStatusTheme;

public class LoginActivity extends AppCompatActivity {

    private VideoView videoBG;
    MediaPlayer mediaPlayer;
    int mCurrentVideoPosition;
    Dialog dialog;

    private String privacyUrl = "https://mobile.vsam.me/privacy";
    private String termsUrl = "https://mobile.vsam.me/terms";

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setHomeStatusTheme(this);

        dialog = new Dialog(this);

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

    public void openPrivacy(View view) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", privacyUrl);
        intent.putExtra("isAbout", false);
        startActivity(intent);
    }

    public void openTerms(View view) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", termsUrl);
        startActivity(intent);
    }

    public void openMoreDialog(View view) {
        dialog.getWindow().setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
       // dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();
    }

    public void startLogin(View view) {
       // startActivity(new Intent(this, HomeActivity.class));
        startActivity(new Intent(this, LoginTwoActivity.class));
    }

    public void startSignup(View view) {
        startActivity(new Intent(this, SignupActivity.class));
    }
}
