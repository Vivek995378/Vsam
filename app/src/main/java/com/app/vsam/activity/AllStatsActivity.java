package com.app.vsam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.PageAdapter;
import com.app.vsam.fragments.BossomBuddyStatsFragment;
import com.app.vsam.fragments.DieHardStatsFragment;
import com.app.vsam.fragments.FollowersStatsFragment;
import com.app.vsam.fragments.PostStatsFragment;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class AllStatsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    private ArrayList<Fragment> fragments;
    private PostStatsFragment postStatsFragment;
    private FollowersStatsFragment followersStatsFragment;
    private DieHardStatsFragment dieHardStatsFragment;
    private BossomBuddyStatsFragment bossomBuddyStatsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_stats);

        changeStatusBarColor(this , "#1A1A1A");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        postStatsFragment = new PostStatsFragment();
        followersStatsFragment = new FollowersStatsFragment();
        dieHardStatsFragment = new DieHardStatsFragment();
        bossomBuddyStatsFragment = new BossomBuddyStatsFragment();

        fragments = new ArrayList<>();

        fragments.add(dieHardStatsFragment);
        fragments.add(followersStatsFragment);
        fragments.add(postStatsFragment);
        fragments.add(bossomBuddyStatsFragment);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setCurrentItem(2);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Die-hard");
        tabLayout.getTabAt(1).setText("Followers");
        tabLayout.getTabAt(2).setText("Posts");
        tabLayout.getTabAt(3).setText("Bossom-Buddy");

    }

    public void backStatistics(View view) {
        onBackPressed();
    }
}