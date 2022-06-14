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

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.LinkViewHolder>{

    private List<LinkData> dataList;
    Context context;

    public LinkAdapter(List<LinkData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public LinkViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new LinkAdapter.LinkViewHolder(LayoutInflater.from(context).inflate(R.layout.item_link,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LinkAdapter.LinkViewHolder holder, int position) {
        LinkData data = dataList.get(position);

        holder.imageView.setImageDrawable(data.getDrawable());
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    //ViewHolder
    public static class LinkViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public LinkViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
