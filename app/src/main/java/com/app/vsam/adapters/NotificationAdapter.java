package com.app.vsam.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.models.NotificationData;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{

    private Context context;
    private ArrayList<NotificationData> notificationData;

    public NotificationAdapter(Context context, ArrayList<NotificationData> notificationData) {
        this.context = context;
        this.notificationData = notificationData;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new NotificationAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notification,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationAdapter.ViewHolder holder, int position) {
        NotificationData data = notificationData.get(position);

        holder.tvUsername.setText(data.getUserName());
        holder.tvNotification.setText(data.getNotification());
        holder.profileImg.setImageDrawable(data.getProfileImg());
        holder.imageView.setImageDrawable(data.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.dialog.getWindow().setContentView(R.layout.custom_notification_dialog);
                holder.dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                holder.dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                // dialog.getWindow().setGravity(Gravity.BOTTOM);
                holder.dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notificationData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUsername, tvNotification;
        private ImageView profileImg , imageView;
        Dialog dialog;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvNotification = itemView.findViewById(R.id.tvNotification);
            profileImg = itemView.findViewById(R.id.profileImage);
            imageView = itemView.findViewById(R.id.imageView);
            dialog = new Dialog(context);
        }
    }

}
