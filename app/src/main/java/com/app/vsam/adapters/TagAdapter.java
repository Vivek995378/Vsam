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

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder>{

    private Context context;
    private ArrayList<BlockedUserData> userLists;

    public TagAdapter(Context context, ArrayList<BlockedUserData> userLists) {
        this.context = context;
        this.userLists = userLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new TagAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TagAdapter.ViewHolder holder, int position) {
        BlockedUserData data = userLists.get(position);

        holder.userImage.setImageDrawable(data.getProfileImg());
        holder.name.setText(data.getName());
        holder.userName.setText(data.getUserName());
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ShapeableImageView userImage;
        private TextView userName, name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.img_user);
            name = itemView.findViewById(R.id.tv_userName);
            userName = itemView.findViewById(R.id.tv_message);
        }
    }

}
