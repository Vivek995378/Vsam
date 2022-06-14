package com.app.vsam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import com.app.vsam.R;
import com.app.vsam.models.LinkData;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder>{

    private List<LinkData> data;
    private Context context;

    public FilterAdapter(List<LinkData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new FilterAdapter.FilterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_filters,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FilterAdapter.FilterViewHolder holder, int position) {

        LinkData filterData = data.get(position);

        holder.filter.setImageDrawable(filterData.getDrawable());

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    //ViewHolder
    public static class FilterViewHolder extends RecyclerView.ViewHolder {

        ImageView filter;

        public FilterViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            filter = itemView.findViewById(R.id.imageView);
        }
    }

}
