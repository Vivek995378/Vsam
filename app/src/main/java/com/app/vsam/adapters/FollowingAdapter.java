package com.app.vsam.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.models.BlockedUserData;

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BlockedUserData> userLists;

    public FollowingAdapter(Context context, ArrayList<BlockedUserData> userLists) {
        this.context = context;
        this.userLists = userLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new FollowingAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_following, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FollowingAdapter.ViewHolder holder, int position) {
        BlockedUserData data = userLists.get(position);

        holder.userImage.setImageDrawable(data.getProfileImg());
        holder.name.setText(data.getName());
        holder.userName.setText(data.getUserName());

        holder.following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.dialog.getWindow().setContentView(R.layout.custom_following_dialog);
                holder.dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                holder.dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                // dialog.getWindow().setGravity(Gravity.BOTTOM);

                WindowManager.LayoutParams lp = holder.dialog.getWindow().getAttributes();
                lp.dimAmount=0.4f;
                lp.alpha=0.9f;
                holder.dialog.getWindow().setAttributes(lp);
                holder.dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                holder.dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ShapeableImageView userImage;
        private TextView userName, name;
        private Button following;
        Dialog dialog;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.img_block);
            name = itemView.findViewById(R.id.tv_blockName);
            userName = itemView.findViewById(R.id.tv_blockUserName);
            following = itemView.findViewById(R.id.btn_following);
            dialog = new Dialog(context);;
        }
    }

}
