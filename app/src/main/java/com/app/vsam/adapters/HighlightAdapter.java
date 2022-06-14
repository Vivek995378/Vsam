package com.app.vsam.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import com.app.vsam.R;
import com.app.vsam.models.LinkData;
import de.hdodenhof.circleimageview.CircleImageView;

public class HighlightAdapter extends RecyclerView.Adapter<HighlightAdapter.HighlightViewHolder> {

    private List<LinkData> data;
    private Context context;

    public HighlightAdapter(List<LinkData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public HighlightViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new HighlightViewHolder(LayoutInflater.from(context).inflate(R.layout.item_highlight,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HighlightAdapter.HighlightViewHolder holder, int position) {
        //changing background color if the story is seen
        LinkData badgeData = data.get(position);

        holder.story.setImageDrawable(badgeData.getDrawable());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    //ViewHolder
    public static class HighlightViewHolder extends RecyclerView.ViewHolder {

        CircleImageView story;

        public HighlightViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            story = itemView.findViewById(R.id.story1);
        }
    }
}
