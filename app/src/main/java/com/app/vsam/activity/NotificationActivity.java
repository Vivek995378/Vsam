package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.NotificationAdapter;
import com.app.vsam.adapters.PageAdapter;
import com.app.vsam.fragments.ActivityFragment;
import com.app.vsam.fragments.RequestFragment;
import com.app.vsam.models.NotificationData;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class NotificationActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    private ArrayList<Fragment> fragments;
    private ActivityFragment activityFragment;
    private RequestFragment requestFragment;

    private RecyclerView recyclerView;
    private ArrayList<NotificationData> arrayList;
    private NotificationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        changeStatusBarColor(this , "#1A1A1A");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        fragments = new ArrayList<>();
        activityFragment = new ActivityFragment();
        requestFragment = new RequestFragment();

        fragments.add(activityFragment);
        fragments.add(requestFragment);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Activity");
        tabLayout.getTabAt(1).setText("Request");
        
    }

    public void backMessages(View view) {
        onBackPressed();
    }
}