package com.app.vsam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.models.ChallengeData;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ChallengeData> challengeData;

    public ChallengeAdapter(Context context, ArrayList<ChallengeData> challengeData) {
        this.context = context;
        this.challengeData = challengeData;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_challenge,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeAdapter.ViewHolder holder, int position) {
        ChallengeData data = challengeData.get(position);

      //  holder.challenge.setText(data.getChallenge());
        holder.hashtag.setText(data.getHashtag());
      //  holder.sponsor.setImageDrawable(data.getSponsor());

    }

    @Override
    public int getItemCount() {
        return challengeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView challenge, hashtag;
        private ImageView sponsor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            challenge = itemView.findViewById(R.id.tvChallenge);
            hashtag = itemView.findViewById(R.id.tvHashtag);
            sponsor = itemView.findViewById(R.id.imageView);
        }
    }

}
