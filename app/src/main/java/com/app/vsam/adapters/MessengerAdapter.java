package com.app.vsam.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import com.app.vsam.activity.UserMessageActivity;
import com.app.vsam.models.MessengerData;
import com.app.vsam.R;

public class MessengerAdapter extends RecyclerView.Adapter<MessengerAdapter.ViewHolder>{

    private Context context;
    private ArrayList<MessengerData> messengerData;

    public MessengerAdapter(Context context, ArrayList<MessengerData> messengerData) {
        this.context = context;
        this.messengerData = messengerData;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MessengerAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_messenger,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MessengerAdapter.ViewHolder holder, int position) {
        MessengerData data = messengerData.get(position);

        holder.userName.setText(data.getUserName());
        holder.bio.setText(data.getBio());
        holder.time.setText(data.getTime());
        holder.profileImg.setImageDrawable(data.getprofileImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserMessageActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return messengerData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userName, bio, time;
        private ImageView profileImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.tvUsername);
            bio = itemView.findViewById(R.id.tvBio);
            time = itemView.findViewById(R.id.tvTime);
            profileImg = itemView.findViewById(R.id.profileImage);
        }
    }
}
