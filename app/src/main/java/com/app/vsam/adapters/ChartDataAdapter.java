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
import com.app.vsam.models.CountryData;

public class ChartDataAdapter extends RecyclerView.Adapter<ChartDataAdapter.ViewHolder>{

    private Context context;
    private ArrayList<CountryData> data;

    public ChartDataAdapter(Context context, ArrayList<CountryData> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ChartDataAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_chart_country, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChartDataAdapter.ViewHolder holder, int position) {
        CountryData countryData = data.get(position);

        holder.imageViewRoundLogo.setImageDrawable(countryData.getImgRoundLogo());
        holder.tvCountryName.setText(countryData.getCountryName());
        holder.tvPercentage.setText(countryData.getPercentage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewRoundLogo , imageViewIncDec;
        private TextView tvCountryName, tvPercentage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewRoundLogo = itemView.findViewById(R.id.imageViewRoundLogo);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
            tvPercentage = itemView.findViewById(R.id.tvPercentage);
        }
    }

}
