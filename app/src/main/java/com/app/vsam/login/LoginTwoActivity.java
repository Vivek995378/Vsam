package com.app.vsam.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.vsam.R;
import com.app.vsam.activity.HomeActivity;

import static com.app.vsam.util.AppPreference.setUserLoggedIn;
import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class LoginTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_two);
        changeStatusBarColor(this , "#222121");

    }

    public void verifyLogin(View view) {
        setUserLoggedIn(LoginTwoActivity.this, true);
        startActivity(new Intent(this, HomeActivity.class));
    }
}