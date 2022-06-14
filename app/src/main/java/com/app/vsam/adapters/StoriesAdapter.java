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

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder>{

    private List<LinkData> stories;
    private Context context;

    public StoriesAdapter(List<LinkData> stories , Context context) {
        this.stories = stories;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new StoriesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_story,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StoriesAdapter.StoriesViewHolder holder, int position) {
        //changing background color if the story is seen
    }

    @Override
    public int getItemCount() {
        return stories == null ? 0 : stories.size();
    }

    //ViewHolder
    public static class StoriesViewHolder extends RecyclerView.ViewHolder {
        public StoriesViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
