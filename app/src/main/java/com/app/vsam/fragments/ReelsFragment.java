package com.app.vsam.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.app.vsam.R;
import com.app.vsam.adapters.PostImageAdapter;
import com.app.vsam.models.PostData;

public class ReelsFragment extends Fragment {

    private RecyclerView postRecyclerView;

//   private RecyclerView recyclerView;
//   private ArrayList<ReelData> reelData;
//   private ReelAdapter adapter;
//   private LinearLayoutManager manager;
//   private ReelAdapter.ReelViewHolder lastViewHolder;
//   private ReelAdapter.ReelViewHolder currentViewHolder;

//    private VideoPlayListener listener = new VideoPlayListener() {
//        @Override
//        public void onNewViewHolder(ReelAdapter.ReelViewHolder holder) {
//            if(lastViewHolder == null){
//                lastViewHolder = holder;
//            }else if(lastViewHolder != holder){
//                currentViewHolder = holder;
//            }
//        }
//    };

    public ReelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_reels, container, false);
//        recyclerView = view.findViewById(R.id.video_player);
//        manager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(manager);
//        init();
        postRecyclerView = view.findViewById(R.id.postRecyclerView);
        postRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3 , StaggeredGridLayoutManager.VERTICAL));
        init();

        return view;
    }

    private void init() {

        //Posts Adapter
        List<PostData> postData = new ArrayList<>();

        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.piccc));

        postRecyclerView.setAdapter(new PostImageAdapter(getActivity() , postData));

    }

//    private void init() {
//        reelData = new ArrayList<>();
//        adapter = new ReelAdapter(sampleVideoList(), getActivity(), listener);
//        recyclerView.setAdapter(adapter);
//    }
//
//    public void startVideo(){
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//            int mostVisibleItemPosition = 0;
//            int lastMostVisibleItemPosition = -1;
//            @Override
//            public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                int firstItemPosition = manager.findFirstVisibleItemPosition();
//                int secondItemPosition = manager.findLastVisibleItemPosition();
//                if (firstItemPosition == secondItemPosition) {
//                    mostVisibleItemPosition = firstItemPosition;
//                } else {
//                    View firstView = manager.findViewByPosition(firstItemPosition);
//                    View secondView = manager.findViewByPosition(secondItemPosition);
//                    if (Math.abs(firstView.getTop()) <= Math.abs(secondView.getTop())) {
//                        if (mostVisibleItemPosition != firstItemPosition) {
//                            mostVisibleItemPosition = firstItemPosition;
//                        }
//                    } else {
//                        if (mostVisibleItemPosition != secondItemPosition) {
//                            mostVisibleItemPosition = secondItemPosition;
//                        }
//                    }
//                }
//
//                if(lastMostVisibleItemPosition != mostVisibleItemPosition){
//                    Log.d("TAG", "recyclerView ko scroll kiya: "+mostVisibleItemPosition);
//                    lastMostVisibleItemPosition = mostVisibleItemPosition;
////                    reelData.get(lastMostVisibleItemPosition).setPercentage(100);
////                    adapter.notifyItemChanged(lastMostVisibleItemPosition);
//                }
//            }
//        });
//    }
//
//    public void stopVideo(){
//        for (int i = 0; i < reelData.size(); i++) {
//            reelData.get(i).setPercentage(0);
//            adapter.notifyItemChanged(i);
//        }
//    }
//
//    private List<ReelData> sampleVideoList() {
//        reelData.add(new ReelData(100,
//                "Big Buck Bunny First" ,
//                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4" ,
//                "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself."));
//        reelData.add(new ReelData(0,
//                "Big Buck Bunny Second" ,
//                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4" ,
//                "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself."));
//        reelData.add(new ReelData(0,
//                "Big Buck Bunny Third" ,
//                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4" ,
//                "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself."));
//        reelData.add(new ReelData(0,
//                "Big Buck Bunny Forth" ,
//                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4" ,
//                "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself."));
//        reelData.add(new ReelData(0,
//                "Big Buck Bunny Fifth" ,
//                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4" ,
//                "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself."));
//        return reelData;
////        return Arrays.asList(new ReelData(0,
////                "Big Buck Bunny" ,
////                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4" ,
////                "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself."
////        ),new ReelData(0,
////                "Elephant Dream" ,
////                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4" ,
////                "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself."
////        ),new ReelData(0,
////                "For Bigger Blazes" ,
////                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4" ,
////                "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself."
////        ),new ReelData(0,
////                "For Bigger Escape" ,
////                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4" ,
////                "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself."
////        ));
//    }
}