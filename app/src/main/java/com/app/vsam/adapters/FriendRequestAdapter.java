package com.app.vsam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.models.BlockedUserData;
import de.hdodenhof.circleimageview.CircleImageView;

public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BlockedUserData> userLists;

    public FriendRequestAdapter(Context context, ArrayList<BlockedUserData> userLists) {
        this.context = context;
        this.userLists = userLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_request, parent, false));
    }

    @Override
    public void onBindViewHolder(FriendRequestAdapter.ViewHolder holder, int position) {
        BlockedUserData data = userLists.get(position);

        holder.profileImage.setImageDrawable(data.getProfileImg());
        holder.tvUsername.setText(data.getUserName());

    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView profileImage;
        private TextView tvUsername;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.profileImage);
            tvUsername = itemView.findViewById(R.id.tvUsername);
        }
    }

}

