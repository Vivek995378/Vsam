package com.app.vsam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import com.app.vsam.R;
import com.app.vsam.fragments.CommentBottomSheetFragment;
import com.app.vsam.fragments.LikeBottomSheetFragment;
import com.app.vsam.fragments.MoreBottomSheetFragment;
import com.app.vsam.fragments.ShareBottomSheetFragment;
import com.app.vsam.models.LinkData;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<LinkData> dataList;
    Context context;

    public PostsAdapter(List<LinkData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_post,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PostsAdapter.PostsViewHolder holder, int position) {

        LinkData data = dataList.get(position);

        holder.post.setImageDrawable(data.getDrawable());

        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                                  holder.likeBottomSheetFragment.show(((FragmentActivity) context).getSupportFragmentManager() , holder.likeBottomSheetFragment.getTag());

                                              }
                                          }
        );

        holder.moreBtn.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {

                                                   holder.moreBottomSheetFragment.show(((FragmentActivity) context).getSupportFragmentManager() , holder.moreBottomSheetFragment.getTag());

                                               }
                                           }
        );
        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                                  holder.shareBottomSheetFragment.show(((FragmentActivity) context).getSupportFragmentManager() , holder.shareBottomSheetFragment.getTag());

                                              }
                                          }
        );
        holder.commentBtn.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                                    holder.commentBottomSheetFragment.show(((FragmentActivity) context).getSupportFragmentManager() , holder.commentBottomSheetFragment.getTag());

                                              }
                                          }
        );

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    //ViewHolder
    public static class PostsViewHolder extends RecyclerView.ViewHolder {
        private ImageView post , moreBtn , shareBtn , commentBtn ;
        private RelativeLayout likeBtn;
        private CommentBottomSheetFragment commentBottomSheetFragment;
        private ShareBottomSheetFragment shareBottomSheetFragment;
        private MoreBottomSheetFragment moreBottomSheetFragment;
        private LikeBottomSheetFragment likeBottomSheetFragment;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);

            post = itemView.findViewById(R.id.imageView1);
            moreBtn = itemView.findViewById(R.id.imageView12);
            shareBtn = itemView.findViewById(R.id.imageView7);
            commentBtn = itemView.findViewById(R.id.imageView6);
            likeBtn = itemView.findViewById(R.id.relativeLayout2);

            commentBottomSheetFragment = new CommentBottomSheetFragment();
            shareBottomSheetFragment = new ShareBottomSheetFragment();
            moreBottomSheetFragment = new MoreBottomSheetFragment();
            likeBottomSheetFragment = new LikeBottomSheetFragment();

        }
    }
}
;