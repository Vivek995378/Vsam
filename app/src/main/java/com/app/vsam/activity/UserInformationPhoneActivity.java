package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class UserInformationPhoneActivity extends AppCompatActivity {

    private Calendar myCalendar;
    private EditText name , createPassword , conformPassword;
    private EditText username;
    private TextView dob;
    private Button btn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_phone);

        changeStatusBarColor(this , "#222121");

        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        dob=findViewById(R.id.dob);
        createPassword=findViewById(R.id.createPassword);
        conformPassword=findViewById(R.id.confirmPassword);
        btn=findViewById(R.id.btn);
       // username.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, days));
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ProgressDialog pd = new ProgressDialog(UserInformationPhoneActivity.this);
//                pd.setMessage("Please Wait.....");
//                String str_name = name.getText().toString();
//                String str_username = username.getText().toString();
//                String str_dob = dob.getText().toString();
//                String str_createPassword = createPassword.getText().toString();
//                String str_conformpassword = conformPassword.getText().toString();
//
//                if (TextUtils.isEmpty(str_name) || TextUtils.isEmpty(str_username) || TextUtils.isEmpty(str_dob) || TextUtils.isEmpty(str_createPassword) || TextUtils.isEmpty(str_conformpassword)) {
//
//                    Toast.makeText(UserInformationPhoneActivity.this, "All Fields are Required ", Toast.LENGTH_SHORT).show();
//                } else if (username.length() < 4) {
//                    Toast.makeText(UserInformationPhoneActivity.this, "username must have 4 character", Toast.LENGTH_SHORT).show();
//                } else if (str_createPassword.length() < 6) {
//                    Toast.makeText(UserInformationPhoneActivity.this, "Password must have 6 character", Toast.LENGTH_SHORT).show();
//                } else if (str_conformpassword.length() < 6) {
//                    Toast.makeText(UserInformationPhoneActivity.this, "Password must have 6 character", Toast.LENGTH_SHORT).show();
//
//                } else if (!str_createPassword.equals(str_conformpassword)){
//                    Toast.makeText(UserInformationPhoneActivity.this, "Password didn't match", Toast.LENGTH_SHORT).show();
//                }
//
//                else {
//
//                    //register(str_name, str_username, str_dob, str_createPassword, str_conformpassword);
//                    pd.dismiss();
//                    Toast.makeText(UserInformationPhoneActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(UserInformationPhoneActivity.this, HomeActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
//                    finish();
//                }
//
//            }
//
//        });

        myCalendar = Calendar.getInstance();

        int year = myCalendar.get(Calendar.YEAR);
        int month = myCalendar.get(Calendar.MONTH);
        int day = myCalendar.get(Calendar.DAY_OF_MONTH);

        this.setTheme(R.style.DatePickerDialog);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        dob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(UserInformationPhoneActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dob.setText(sdf.format(myCalendar.getTime()));
    }


    public void finishUserInfo(View view) {
        onBackPressed();
    }

    public void enterHomeActivity(View view) {
        startActivity(new Intent(UserInformationPhoneActivity.this , HomeActivity.class));
    }

    public void openTerms(View view) {
    }

    public void openPrivacy(View view) {
    }

}