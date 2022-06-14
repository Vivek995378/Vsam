package com.app.vsam.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.app.vsam.R;
import com.app.vsam.activity.AllStatsActivity;
import com.app.vsam.activity.ChartActivity;
import com.app.vsam.activity.EditProfile;
import com.app.vsam.activity.FollowerActivity;
import com.app.vsam.activity.SettingsActivity;
import com.app.vsam.adapters.HighlightAdapter;
import com.app.vsam.adapters.PageAdapter;
import com.app.vsam.models.LinkData;
import com.app.vsam.models.StoriesDecoration;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class ProfileFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    RecyclerView storyBar;

    TextView editProfile ;
    ImageView settings , statistics;
    LinearLayout followers , views;


    private ArrayList<Fragment> fragments;
    private GalleryFragment galleryFragment;
    private ReelsFragment reelsFragment;
    private MentionedFragment mentionedFragment;
    private LinkFragment linkFragment;
    private SaveFragment saveFragment;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        storyBar = view.findViewById(R.id.recyclerView1);
        init();

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        editProfile =(TextView) view.findViewById(R.id.editProfile);
        settings =(ImageView) view.findViewById(R.id.settings);
        statistics =(ImageView) view.findViewById(R.id.statistics);
        views =(LinearLayout) view.findViewById(R.id.llViews);
        followers =(LinearLayout) view.findViewById(R.id.llFollowers);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditProfile.class));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
            }
        });
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllStatsActivity.class));
            }
        });
        views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ChartActivity.class));
            }
        });
        followers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FollowerActivity.class));
            }
        });

        galleryFragment = new GalleryFragment();
        reelsFragment = new ReelsFragment();
        mentionedFragment = new MentionedFragment();
        linkFragment = new LinkFragment();
        saveFragment = new SaveFragment();
        fragments = new ArrayList<>();
        fragments.add(galleryFragment);
        fragments.add(reelsFragment);
        fragments.add(mentionedFragment);
        //fragments.add(linkFragment);
        fragments.add(saveFragment);

        pagerAdapter = new PageAdapter(getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        int tabIconColor = ContextCompat.getColor(getContext(), R.color.fragmentTextColor);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        int tabIconColor = ContextCompat.getColor(getContext(), R.color.toolbarColor);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_gallery);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_reels);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_mentioned);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_save);
//        tabLayout.getTabAt(4).setIcon(R.drawable.ic_save);
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                if(position == 1){
//                    reelsFragment.startVideo();
//                }else{
////                    reelsFragment.stopVideo();
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
        return view;
    }

    private void init() {
        List<LinkData> data = new ArrayList<>();
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.add)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.picc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.piccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.picccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.piccccc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.pic)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.picc)));
        data.add(new LinkData(this.getResources().getDrawable(R.drawable.piccc)));


        HighlightAdapter adapter = new HighlightAdapter(data, getActivity());

        storyBar.setAdapter(adapter);
        storyBar.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        //Setting the space between stories
        storyBar.addItemDecoration(new StoriesDecoration(10));


    }

}