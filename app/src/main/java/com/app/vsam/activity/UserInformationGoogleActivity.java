package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class UserInformationGoogleActivity extends AppCompatActivity {

    private EditText createPassword,conformPassword;
    private EditText username;
    private Button btn;
    CheckBox checkBox;
    String[] days = new String[]{"akshay_kumar", "vivek", "amir@123", "amir_khan", "akshay-0010", "vivak-001", "sunnday"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_google);

        changeStatusBarColor(this , "#222121");

        username = findViewById(R.id.username);
        createPassword = findViewById(R.id.createPassword);
        conformPassword = findViewById(R.id.confirmPassword);
        checkBox = findViewById(R.id.checkbox);
        btn=findViewById(R.id.btn);
      //  username.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, days));


    }

    public void enterHomeActivityFromGoogle(View view) {
        ProgressDialog pd = new ProgressDialog(UserInformationGoogleActivity.this);
        pd.setMessage("Please Wait.....");

        String str_username = username.getText().toString();
        String str_createPassword = createPassword.getText().toString();
        String str_conformpassword = conformPassword.getText().toString();

        if (TextUtils.isEmpty(str_username) || TextUtils.isEmpty(str_createPassword) || TextUtils.isEmpty(str_conformpassword)) {
            Toast.makeText(UserInformationGoogleActivity.this, "All Fields are Required ", Toast.LENGTH_SHORT).show();
        } else if (username.length() < 4) {
            Toast.makeText(UserInformationGoogleActivity.this, "username must have 4 character", Toast.LENGTH_SHORT).show();
        } else if (str_createPassword.length() < 6) {
            Toast.makeText(UserInformationGoogleActivity.this, "Password must have 6 character", Toast.LENGTH_SHORT).show();
        } else if (str_conformpassword.length() < 6) {
            Toast.makeText(UserInformationGoogleActivity.this, "Password must have 6 character", Toast.LENGTH_SHORT).show();

        } else if (!str_createPassword.equals(str_conformpassword)){
            Toast.makeText(UserInformationGoogleActivity.this, "Password didn't match", Toast.LENGTH_SHORT).show();
        } else if(!checkBox.isChecked()){
            Toast.makeText(UserInformationGoogleActivity.this, "Please accept terms and privacy conditions", Toast.LENGTH_SHORT).show();
        }
        else {
            //register(str_name, str_username, str_dob, str_createPassword, str_conformpassword);
            pd.dismiss();
            Toast.makeText(UserInformationGoogleActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(UserInformationGoogleActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

    public void enterHomeActivity(View view) {
        startActivity(new Intent(UserInformationGoogleActivity.this , HomeActivity.class));
    }

    public void finishUserInfo(View view) {
        onBackPressed();
    }
}