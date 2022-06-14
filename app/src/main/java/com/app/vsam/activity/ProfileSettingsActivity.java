package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class ProfileSettingsActivity extends AppCompatActivity {

    TextView tvAccount , tvPhone , tvEmail , tvDob , tvReset , tvDisable , tvDelete;
    CardView cardAccount , cardPhone , cardEmail , cardReset , cardDisable , cardDelete;
    private Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);
        changeStatusBarColor(this , "#1A1A1A");

        tvAccount = findViewById(R.id.textView50);
        tvPhone = findViewById(R.id.textView35);
        tvEmail = findViewById(R.id.textView36);
        tvDob = findViewById(R.id.textView37);
        tvReset = findViewById(R.id.textView38);
        tvDisable = findViewById(R.id.textView39);
        tvDelete = findViewById(R.id.textView40);

        cardAccount = findViewById(R.id.cardView5);
        cardPhone = findViewById(R.id.cardView);
        cardEmail = findViewById(R.id.cardView1);
        cardReset = findViewById(R.id.cardView2);
        cardDisable = findViewById(R.id.cardView3);
        cardDelete = findViewById(R.id.cardView4);

        tvAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardAccount.setVisibility(View.VISIBLE);
            }
        });
        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardPhone.setVisibility(View.VISIBLE);
            }
        });
        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardEmail.setVisibility(View.VISIBLE);
            }
        });

        tvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardReset.setVisibility(View.VISIBLE);
            }
        });
        tvDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardDisable.setVisibility(View.VISIBLE);
            }
        });
        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardDelete.setVisibility(View.VISIBLE);
            }
        });

        /* Calender */
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

        tvDob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ProfileSettingsActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        tvDob.setText(sdf.format(myCalendar.getTime()));
    }

    public void backEditProfile(View view) {
        onBackPressed();
    }
}