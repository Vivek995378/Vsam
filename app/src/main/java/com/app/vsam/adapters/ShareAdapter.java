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

public class ShareAdapter extends RecyclerView.Adapter<ShareAdapter.ViewHolder>{

    private Context context;
    private ArrayList<BlockedUserData> userLists;

    public ShareAdapter(Context context, ArrayList<BlockedUserData> userLists) {
        this.context = context;
        this.userLists = userLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ShareAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_share_post,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ShareAdapter.ViewHolder holder, int position) {
        BlockedUserData data = userLists.get(position);

        holder.userProfile.setImageDrawable(data.getProfileImg());
        holder.tvName.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private CircleImageView userProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.username);
            userProfile = itemView.findViewById(R.id.profileImage);
        }
    }

}
