package com.app.vsam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.models.BlockedUserData;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    private Context context;
    private ArrayList<BlockedUserData> userLists;

    public CommentAdapter(Context context, ArrayList<BlockedUserData> userLists) {
        this.context = context;
        this.userLists = userLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new CommentAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_comment,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CommentAdapter.ViewHolder holder, int position) {
        BlockedUserData data = userLists.get(position);

        holder.userProfile.setImageDrawable(data.getProfileImg());
        holder.tvName.setText(data.getName());
        holder.tvTime.setText(data.getUserName());
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvTime;
        private ShapeableImageView userProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvTime = itemView.findViewById(R.id.tvTime);
            userProfile = itemView.findViewById(R.id.userProfile);
        }
    }

}
