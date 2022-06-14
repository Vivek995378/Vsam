package com.app.vsam.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import com.app.vsam.R;
import com.app.vsam.activity.StatisticsActivity;
import com.app.vsam.models.PostData;

public class PostStatAdapter extends RecyclerView.Adapter<PostStatAdapter.PostViewHolder> {

    Context context;
    private List<PostData> postData;

    public PostStatAdapter(Context context, List<PostData> postData) {
        this.context = context;
        this.postData = postData;
    }

    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.item_post_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.setPostImage(postData.get(position));

        holder.postImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context , StatisticsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return postData.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView postImageView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postImageView = itemView.findViewById(R.id.imagePost);
        }

        void setPostImage(PostData postData) {
            postImageView.setImageResource(postData.getImage());
        }

    }

}
