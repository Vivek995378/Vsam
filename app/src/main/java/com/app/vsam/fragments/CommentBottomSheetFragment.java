package com.app.vsam.fragments;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.CommentAdapter;
import com.app.vsam.models.BlockedUserData;

public class CommentBottomSheetFragment extends BottomSheetDialogFragment {

    RecyclerView recyclerView;

    public CommentBottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comment_bottom_sheet, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        ArrayList<BlockedUserData> list = new ArrayList<>();
        list.add(new BlockedUserData("vivek9718", "1 min ago" ,this.getResources().getDrawable(R.drawable.pic)));
        list.add(new BlockedUserData("yashi001", "38 min ago",this.getResources().getDrawable(R.drawable.picc)));
        list.add(new BlockedUserData("sahil123", "4 min ago",this.getResources().getDrawable(R.drawable.piccc)));
        list.add(new BlockedUserData("rohit_0085", "42 min ago",this.getResources().getDrawable(R.drawable.picccc)));
        list.add(new BlockedUserData("raj8700", "3 min ago",this.getResources().getDrawable(R.drawable.piccccc)));
        list.add(new BlockedUserData("vivek9718", "13 min ago" ,this.getResources().getDrawable(R.drawable.pic)));
        list.add(new BlockedUserData("yashi001", "35 min ago",this.getResources().getDrawable(R.drawable.picc)));
        list.add(new BlockedUserData("sahil123", "24 min ago",this.getResources().getDrawable(R.drawable.piccc)));
        list.add(new BlockedUserData("rohit_0085", "17 min ago",this.getResources().getDrawable(R.drawable.picccc)));
        list.add(new BlockedUserData("raj8700", "34 min ago",this.getResources().getDrawable(R.drawable.piccccc)));

        CommentAdapter adapter = new CommentAdapter(getContext() , list);

        recyclerView.setAdapter(adapter);

        return view;
    }
}