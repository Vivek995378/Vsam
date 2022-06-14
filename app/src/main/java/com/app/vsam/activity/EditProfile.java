package com.app.vsam.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.app.vsam.R;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class EditProfile extends AppCompatActivity {

    TextView tvGender;
    CardView cardView;
    View view;
    Dialog dialog;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        changeStatusBarColor(this , "#1A1A1A");

        tvGender = findViewById(R.id.tvGender);
        cardView = findViewById(R.id.cardView);
        view = findViewById(R.id.view1);
        dialog = new Dialog(this);

        tvGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.getWindow().setContentView(R.layout.custom_gender_dialog);
                dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                // dialog.getWindow().setGravity(Gravity.BOTTOM);

                WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
                lp.dimAmount=0.4f;
                lp.alpha=0.9f;
                dialog.getWindow().setAttributes(lp);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.show();
            }
        });

    }
    public void backEditProfile(View view) {
        onBackPressed();
    }

}
