package com.app.vsam.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import com.app.vsam.R;
import com.app.vsam.listener.VideoPlayListener;
import com.app.vsam.models.ReelData;

public class ReelAdapter extends RecyclerView.Adapter<ReelAdapter.ReelViewHolder>{

    private List<ReelData> dataList;
    private Context context;
    private VideoPlayListener listener;

    public ReelAdapter(List<ReelData> dataList, Context context, VideoPlayListener listener) {
        this.dataList = dataList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public ReelViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ReelAdapter.ReelViewHolder(LayoutInflater.from(context).inflate(R.layout.item_reel,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ReelAdapter.ReelViewHolder holder, int position) {
            holder.videoView.setVideoPath(dataList.get(position).getDesc());
            holder.textView.setText(String.valueOf(position));
            if(dataList.get(position).getPercentage() >= 100){
                holder.textView.setText("Ye wali chlegi");
                holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        holder.videoView.start();
                    }
                });
            }else if(dataList.get(position).getPercentage() <100){
//                holder.textView.setText("Ye wali ni chlegi");
//                try{
//                    holder.videoView.pause();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
            }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    //ViewHolder
    public static class ReelViewHolder extends RecyclerView.ViewHolder{

        public VideoView videoView;
        private TextView textView;

        public ReelViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textView = itemView.findViewById(R.id.textView5);
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull @NotNull ReelAdapter.ReelViewHolder holder) {
       if(listener != null){
           listener.onNewViewHolder(holder);
       }
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull @NotNull ReelAdapter.ReelViewHolder holder) {
        try{
            holder.videoView.pause();
        }catch (Exception e){

        }
        super.onViewDetachedFromWindow(holder);
    }
}
