package com.app.vsam.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.vsam.R;
import com.app.vsam.activity.UserInformationPhoneActivity;
import com.app.vsam.apiService.ApiClient;
import com.app.vsam.models.User;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.app.vsam.util.AppPreference.setUserLoggedIn;
import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class SignupOtpActivity extends AppCompatActivity {

    private EditText Ed1, Ed2, Ed3, Ed4, Ed5, Ed6;
    TextView resendotp , sample;
    String getotpbackend;
    private String url = "http://api.vsam.xyz/";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_otp);

        changeStatusBarColor(this , "#222121");

        Ed1 = findViewById(R.id.inputotp1);
        Ed2 = findViewById(R.id.inputotp2);
        Ed3 = findViewById(R.id.inputotp3);
        Ed4 = findViewById(R.id.inputotp4);
        Ed5 = findViewById(R.id.inputotp5);
        Ed6 = findViewById(R.id.inputotp6);
        resendotp = findViewById(R.id.textresendotp);
        sample = findViewById(R.id.tvSample);
        //getotpbackend = getIntent().getStringExtra("backendotp");
//        mCountDownTimer=new CountDownTimer(30000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//                String sDuration= String.format(Locale.ENGLISH,"%02d",
//                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished));
//                timer.setText(sDuration);
//            }
//
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onFinish() {
//                resendotp.setTextColor(R.color.textColor);
//                resendotp.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        PhoneAuthProvider.getInstance(firebaseAuth).verifyPhoneNumber(getIntent().getStringExtra("mobile"), 60
//                                , TimeUnit.SECONDS, SignupOtpActivity.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                                    @Override
//                                    public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential) {
//
//                                    }
//
//                                    @Override
//                                    public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e) {
//
//
//                                        Toast.makeText(SignupOtpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                                    }
//
//                                    @Override
//                                    public void onCodeSent(@NonNull @NotNull String newbackendotp, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//
//                                        getotpbackend = newbackendotp;
//                                        Toast.makeText(SignupOtpActivity.this, "OTP Resend on your Phone", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                    }
//                });
//
//
//            }
//        }.start();
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignupOtpActivity.this , UserInformationPhoneActivity.class));
//                if (!Ed1.getText().toString().trim().isEmpty() && !Ed2.getText().toString().trim().isEmpty() &&
//                        !Ed3.getText().toString().trim().isEmpty() && !Ed4.getText().toString().trim().isEmpty()
//                        && !Ed5.getText().toString().trim().isEmpty() && !Ed6.getText().toString().trim().isEmpty()) {
//
//                    String entercodeotp = Ed1.getText().toString() + Ed2.getText().toString() + Ed3.getText().toString() +
//                            Ed4.getText().toString() + Ed5.getText().toString() + Ed6.getText().toString();
//
//
//                    if (getotpbackend != null) {
//                        progressBar.setVisibility(View.VISIBLE);
//                        submit.setVisibility(View.INVISIBLE);
//                        com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(getotpbackend, entercodeotp);
//
//                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
//
//                                progressBar.setVisibility(View.GONE);
//                                submit.setVisibility(View.VISIBLE);
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(SignupOtpActivity.this, "OTP Verify  & your register Successful!", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(SignupOtpActivity.this, UserInformationPhoneActivity.class);
//                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                    startActivity(intent);
//                                    finish();
//
//                                } else {
//                                    Toast.makeText(SignupOtpActivity.this, "Enter Correct OTP", Toast.LENGTH_SHORT).show();
//                                }
//
//                            }
//                        });
//
//                    } else {
//                        Toast.makeText(SignupOtpActivity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
//                    }
//
//
//                } else {
//                    Toast.makeText(SignupOtpActivity.this, "Please enter all 6 numbers", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//        });
//
//        numberotpmove();
    }

    private void numberotpmove() {
        Ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Ed1.getText().toString().length() == 1) {
                    Ed2.requestFocus();
                }
            }
        });
        Ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Ed2.getText().toString().length() == 0) {
                    Ed1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Ed2.getText().toString().length() == 1) {
                    Ed3.requestFocus();
                }
            }
        });
        Ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Ed3.getText().toString().length() == 0) {
                    Ed2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Ed3.getText().toString().length() == 1) {
                    Ed4.requestFocus();
                }
            }
        });
        Ed4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Ed4.getText().toString().length() == 0) {
                    Ed3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Ed4.getText().toString().length() == 1) {
                    Ed5.requestFocus();
                }
            }
        });
        Ed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Ed5.getText().toString().length() == 0) {
                    Ed4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Ed5.getText().toString().length() == 1) {
                    Ed6.requestFocus();
                }
            }
        });
        Ed6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Ed6.getText().toString().length() == 0) {
                    Ed5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Ed6.getText().toString().length() == 1) {
                    Ed6.requestFocus();
                }
            }
        });

    }

    public void finishSignupOtp(View view) {
        onBackPressed();
    }

    public void enterUserInformationPhone(View view) {
        setUserLoggedIn(SignupOtpActivity.this, true);
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiClient api = retrofit.create(ApiClient.class);
        Call<User> call = api.login(String.valueOf(FirebaseMessaging.getInstance().getToken()));

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
               // sample.setText(response.toString());
                Toast.makeText(getBaseContext() , response.toString() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getBaseContext() , t.toString() , Toast.LENGTH_SHORT).show();
            }
        });

        startActivity(new Intent(this, UserInformationPhoneActivity.class));
    }
}