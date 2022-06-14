package com.app.vsam.adapters;

import android.content.Context;
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
import com.app.vsam.models.ChallengeData;

public class ChallengeCardAdapter extends RecyclerView.Adapter<ChallengeCardAdapter.ViewHolder>{

    private Context context;
    private ArrayList<ChallengeData> challengeData;

    public ChallengeCardAdapter(Context context, ArrayList<ChallengeData> challengeData) {
        this.context = context;
        this.challengeData = challengeData;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ChallengeCardAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_challenge_card,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChallengeCardAdapter.ViewHolder holder, int position) {
        ChallengeData data = challengeData.get(position);

        holder.tv1.setText(data.getChallenge());
        holder.tv2.setText(data.getHashtag());
        holder.background.setImageDrawable(data.getSponsor());
    }

    @Override
    public int getItemCount() {
        return challengeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv1, tv2;
        private ImageView background;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            background = itemView.findViewById(R.id.imageView);
        }
    }

}
