package com.app.vsam.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.activity.BadgeActivity;
import com.app.vsam.adapters.ChallengeAdapter;
import com.app.vsam.adapters.ChallengeCardAdapter;
import com.app.vsam.models.ChallengeData;

public class ChallengeFragment extends Fragment {

    private RecyclerView recyclerView , recyclerView2 , recyclerView3 , recyclerView4 ;
    private ArrayList<ChallengeData> arrayList , arrayList2;
    private ChallengeAdapter adapter;
    private ChallengeCardAdapter adapter1;
    private ImageView badgeImg;

    public ChallengeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);

        recyclerView = view.findViewById(R.id.recyclerView1);
        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView3 = view.findViewById(R.id.recyclerView3);
        recyclerView4 = view.findViewById(R.id.recyclerView4);
        recyclerView = view.findViewById(R.id.recyclerView);
        badgeImg = view.findViewById(R.id.badgeImg);
        setData();

        badgeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity() , BadgeActivity.class));
            }
        });
        
        return view;
    }

    private void setData() {

        arrayList = new ArrayList<>();
        arrayList.add(new ChallengeData("Dance bugs" , "#vsamdance" , this.getResources().getDrawable(R.drawable.ic_sponsor1)));
        arrayList.add(new ChallengeData("Rais your Mic" , "#vsamrock" , this.getResources().getDrawable(R.drawable.ic_sponsor2)));
        arrayList.add(new ChallengeData("Voice of heart" , "#vsamsing" , this.getResources().getDrawable(R.drawable.ic_sponsor1)));
        arrayList.add(new ChallengeData("Bring music to life" , "#vsammusic" , this.getResources().getDrawable(R.drawable.ic_sponsor2)));
        arrayList.add(new ChallengeData("Geographic bee" , "#vsamgeobee" , this.getResources().getDrawable(R.drawable.ic_sponsor1)));
        arrayList.add(new ChallengeData("Mr. and Miss. funny bones" , "#vsamfun" , this.getResources().getDrawable(R.drawable.ic_sponsor2)));
        arrayList.add(new ChallengeData("Go Green" , "#vsamgeobee" , this.getResources().getDrawable(R.drawable.ic_sponsor1)));
        arrayList.add(new ChallengeData("Map the social & Eco" , "#vsambesocial" , this.getResources().getDrawable(R.drawable.ic_sponsor2)));
        arrayList.add(new ChallengeData("Geographic bee" , "#vsamgeobee" , this.getResources().getDrawable(R.drawable.ic_sponsor1)));
        arrayList.add(new ChallengeData("Mr. and Miss. funny bones" , "#vsamfun" , this.getResources().getDrawable(R.drawable.ic_sponsor2)));
        arrayList.add(new ChallengeData("Go Green" , "#vsamgeobee" , this.getResources().getDrawable(R.drawable.ic_sponsor1)));
        arrayList.add(new ChallengeData("Map the social & Eco" , "#vsambesocial" , this.getResources().getDrawable(R.drawable.ic_sponsor2)));

        adapter = new ChallengeAdapter(getActivity() , arrayList);
        recyclerView3.setAdapter(adapter);

        arrayList2 = new ArrayList<>();
        arrayList2.add(new ChallengeData("Live" , "Music" , this.getResources().getDrawable(R.drawable.bg1)));
        arrayList2.add(new ChallengeData("Band" , "Performances" , this.getResources().getDrawable(R.drawable.bg2)));
        arrayList2.add(new ChallengeData("Live" , "Music" , this.getResources().getDrawable(R.drawable.bg3)));
        arrayList2.add(new ChallengeData("Band" , "Performances" , this.getResources().getDrawable(R.drawable.bg1)));
        arrayList2.add(new ChallengeData("Live" , "Music" , this.getResources().getDrawable(R.drawable.bg2)));
        arrayList2.add(new ChallengeData("Band" , "Performances" , this.getResources().getDrawable(R.drawable.bg3)));
        arrayList2.add(new ChallengeData("Live" , "Music" , this.getResources().getDrawable(R.drawable.bg1)));
        arrayList2.add(new ChallengeData("Band" , "Performances" , this.getResources().getDrawable(R.drawable.bg2)));

        adapter1 = new ChallengeCardAdapter(getActivity() , arrayList2);
        recyclerView.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter1);
        recyclerView4.setAdapter(adapter1);
    }
}