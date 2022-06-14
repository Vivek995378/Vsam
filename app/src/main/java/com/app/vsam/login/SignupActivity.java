package com.app.vsam.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import com.app.vsam.R;
import com.app.vsam.activity.UserInformationGoogleActivity;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.internal.GsonBuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.app.vsam.util.AppPreference.setUserLoggedIn;
import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class SignupActivity extends AppCompatActivity {

    private CallbackManager mCallbackManager;
    private LoginButton fbLoginButton;
    private FirebaseAuth mAuth;
    private AccessTokenTracker accessTokenTracker;
    private FirebaseAuth.AuthStateListener authStateListener;
    private static final String EMAIL = "email";
    private static final String TAG = "FacebookAuthentication";

    private boolean isFacebook = false, isGoogle = false;
    private String url = "http://api.vsam.xyz/";

    private GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        changeStatusBarColor(this, "#222121");

        mAuth = FirebaseAuth.getInstance();

        //Fb Login
        mCallbackManager = CallbackManager.Factory.create();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull @NotNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    updateUI(user);
                } else {
                    updateUI(null);
                }
            }
        };

//        Retrofit.Builder builder = new Retrofit.Builder()
//                                        .baseUrl("http://api.vsam.xyz/")
//                                        .addConverterFactory(GsonConvertorFactory.create());
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public void finishSignUp(View view) {
        onBackPressed();
    }

    public void openTerms(View view) {
    }

    public void openPrivacy(View view) {
    }

    public void verifyNumber(View view) {
        Intent intent = new Intent(this, SignupOtpActivity.class);
        startActivity(intent);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    //Facebook

    public void startFacebookLogin(View view) {

        isGoogle = false;
        isFacebook = true;

        fbLoginButton = new LoginButton(this);
        fbLoginButton.setLoginBehavior(LoginBehavior.WEB_VIEW_ONLY);
        setFacebookCallback();
        fbLoginButton.performClick();
    }

    private void setFacebookCallback() {
        fbLoginButton.setPermissions(Arrays.asList(EMAIL));
        mCallbackManager = CallbackManager.Factory.create();
        fbLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(SignupActivity.this, "Facebook cancelled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(SignupActivity.this, "Facebook Exception: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleFacebookToken(AccessToken token) {
        Log.d(TAG, "handleFacebookToken" + token);
        AuthCredential authCredential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "Sign in with Credential:Successful");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);

                } else {
                    Log.d(TAG, "Sign in with Credential:Failure", task.getException());
                    Toast.makeText(SignupActivity.this, "Authentication Successfull", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }
            }
        });
    }

    //Google

    public void startGoogleLogin(View view) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        isGoogle = true;
        isFacebook = false;

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityIfNeeded(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (isFacebook) {
            isFacebook = false;
            mCallbackManager.onActivityResult(requestCode, resultCode, data);
        } else if (isGoogle) {
            isGoogle = false;
            if(requestCode == RC_SIGN_IN){
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                handleSignInResult(task);
            }
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try{

            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            Toast.makeText(SignupActivity.this,"Signed In Successfully",Toast.LENGTH_SHORT).show();
            setUserLoggedIn(SignupActivity.this, true);
            Intent intent=new Intent(SignupActivity.this, UserInformationGoogleActivity.class);
            startActivity(intent);
            FirebaseGoogleAuth(acc);
            FirebaseMessaging.getInstance().getToken().addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(String token) {
                    if (!TextUtils.isEmpty(token)) {
                        Log.d(TAG, "retrieve token successful : " + token);
                        Toast.makeText(SignupActivity.this,"retrieve token successful : " + token,Toast.LENGTH_SHORT).show();
                    } else{
                        Log.w(TAG, "token should not be null...");
                    }
                }
            }).addOnFailureListener(e -> {
                //handle e
            }).addOnCanceledListener(() -> {
                //handle cancel
            }).addOnCompleteListener(task -> Toast.makeText(SignupActivity.this,"This is the token : " + task.getResult(),Toast.LENGTH_SHORT).show());
        }
        catch (ApiException e){
            Toast.makeText(SignupActivity.this,"Sign In Failed",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acct) {

        if (acct != null) {
            AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
            mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignupActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mAuth.getCurrentUser();

                    } else {
                        Toast.makeText(SignupActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
        else{
            Toast.makeText(SignupActivity.this, "acc failed", Toast.LENGTH_SHORT).show();
        }
    }

    protected void updateUI(FirebaseUser user) {
        if (user.isEmailVerified()){
            setUserLoggedIn(SignupActivity.this, true);
            Intent intent = new Intent(SignupActivity.this, UserInformationGoogleActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    public void startLinkedinLogin(View view) {
        setUserLoggedIn(SignupActivity.this, true);
        Intent intent = new Intent(this, UserInformationGoogleActivity.class);
        startActivity(intent);
    }
}