package com.app.vsam.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.camerakit.CameraKitView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.PageAdapter;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class AddFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    public CameraKitView cameraKitView;

    private ArrayList<Fragment> fragments;
    private StoryFragment storyFragment;
    private LiveFragment liveFragment;
    private PostFragment postFragment;
    private FlashFragment flashFragment;

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        cameraKitView = view.findViewById(R.id.camera);

        storyFragment = new StoryFragment();
        liveFragment = new LiveFragment();
        postFragment = new PostFragment();
        flashFragment = new FlashFragment();

        fragments = new ArrayList<>();

        fragments.add(liveFragment);
        fragments.add(postFragment);
        fragments.add(flashFragment);
        fragments.add(storyFragment);

        pagerAdapter = new PageAdapter(getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setCurrentItem(1);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                try {
                    if (position == 0) {
                        if(liveFragment.mediaPlayer != null && !liveFragment.mediaPlayer.isPlaying()){
                            liveFragment.mediaPlayer.start();
                        }
                    } else {
                        if (liveFragment.mediaPlayer != null && liveFragment.mediaPlayer.isPlaying()) {
                            liveFragment.mediaPlayer.pause();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.getTabAt(0).setText("Live");
        tabLayout.getTabAt(1).setText("Post");
        tabLayout.getTabAt(2).setText("Flash");
        tabLayout.getTabAt(3).setText("Story");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        cameraKitView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        cameraKitView.onResume();
    }

    @Override
    public void onPause() {
        cameraKitView.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        cameraKitView.onStop();
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        cameraKitView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}