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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<LinkData> dataList;
    Context context;

    public SearchAdapter(List<LinkData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new SearchAdapter.SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search_photo,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SearchAdapter.SearchViewHolder holder, int position) {
        LinkData data = dataList.get(position);

        holder.imageView.setImageDrawable(data.getDrawable());
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    //ViewHolder
    public static class SearchViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public SearchViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
