package com.app.vsam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import com.app.vsam.R;
import com.app.vsam.adapters.ChartDataAdapter;
import com.app.vsam.models.CountryData;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class ChartActivity extends AppCompatActivity {

    private GoogleMap mGoogleMap;
    private RecyclerView recyclerView;

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barDataEntries , pieDataEntries;

    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;

    LineChart lineChart;
    LineData lineData;
    LineDataSet lineDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        changeStatusBarColor(this , "#1A1A1A");

        //Initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);

        //Async map
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull @NotNull GoogleMap googleMap) {
                //When map is ready
                mGoogleMap = googleMap;
                MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(ChartActivity.this, R.raw.style_map);
                mGoogleMap.setMapStyle(mapStyleOptions);

                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull @NotNull LatLng latLng) {
                        //when click on map initializing marker option
                        MarkerOptions markerOptions = new MarkerOptions();
                        //setting position of marker
                        markerOptions.position(latLng);     //latLng - Latitude/Longitude
                        //set title of marker
                        markerOptions.title(latLng.latitude + " : " + latLng.longitude);
                        //remove all markers
                        googleMap.clear();
                        //Animating to zoom the marker
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom( latLng , 10));
                        //Add marker on map
                        googleMap.addMarker(markerOptions);

                    }
                });

            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        init();

        barChart = findViewById(R.id.barChart);
        pieChart = findViewById(R.id.pieChart);
        lineChart = findViewById(R.id.lineChart);

        getEntries();

        barDataSet = new BarDataSet(barDataEntries , "Data Set");
        barData = new BarData(barDataSet);
        barData.setBarWidth(0.5f);
        barChart.setData(barData);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisLeft().setTextColor(Color.WHITE);
        barChart.getAxisLeft().setAxisLineWidth(2f);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setTextColor(Color.WHITE);
        barChart.getXAxis().setAxisLineWidth(2f);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisRight().setDrawAxisLine(false);
        barChart.getAxisRight().setDrawLabels(false);
        barChart.getLegend().setEnabled(false);
        Description description = new Description();
        description.setText("");
        barChart.setDescription(description);
        int startColor = ContextCompat.getColor(this, R.color.color2);
        int endColor = ContextCompat.getColor(this, R.color.color1);
        barDataSet.setGradientColor(startColor , endColor);
     //   barDataSet.setGradientColor(startColor , endColor);

        barDataSet.setDrawValues(false);
        barDataSet.setValueTextSize(16f);

        pieDataSet = new PieDataSet(pieDataEntries , "Data Set 2");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setDescription(description);
        pieChart.getLegend().setEnabled(false);

        pieDataSet.setDrawValues(false);
        pieDataSet.setColors(Color.BLUE , Color.YELLOW , Color.RED);
        pieDataSet.setValueTextSize(16f);

        lineDataSet = new LineDataSet(barDataEntries , "Data Set 3");
        lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisLeft().setTextColor(Color.WHITE);
        lineChart.getAxisLeft().setAxisLineWidth(2f);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getXAxis().setTextColor(Color.WHITE);
        lineChart.getXAxis().setAxisLineWidth(2f);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawAxisLine(false);
        lineChart.getAxisRight().setDrawLabels(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.setDescription(description);

        setupGradient(lineChart);

        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setLineWidth(3f);
        lineDataSet.setDrawValues(false);
        lineDataSet.setValueTextSize(16f);
        lineDataSet.setDrawCircles(false);
        lineChart.animateXY(500, 500);
        lineChart.notifyDataSetChanged();
        lineChart.invalidate();
    }

    private void setupGradient(LineChart mChart) {
        Paint paint = mChart.getRenderer().getPaintRender();

        LinearGradient linGrad = new LinearGradient(0f, 600f, 0f, 0f,
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                Shader.TileMode.CLAMP);
        paint.setShader(linGrad);
    }

    private void setupLineChart() {

    }

    private void getEntries(){
        barDataEntries = new ArrayList<>();
        barDataEntries.add(new BarEntry(1f , 5));
        barDataEntries.add(new BarEntry(2f , 4));
        barDataEntries.add(new BarEntry(3f , 6));
        barDataEntries.add(new BarEntry(4f , 4));
        barDataEntries.add(new BarEntry(5f , 6));
        barDataEntries.add(new BarEntry(6f , 4));

        pieDataEntries = new ArrayList<>();
        pieDataEntries.add(new PieEntry(55f , "Male"));
        pieDataEntries.add(new PieEntry(25f , "Female"));
        pieDataEntries.add(new PieEntry(20f , "Prefer not to say"));

    }

    private void init() {

        //Posts Adapter
        ArrayList<CountryData> data = new ArrayList<>();
        data.add(new CountryData("Usa", "32K", this.getResources().getDrawable(R.drawable.white_dot) , this.getResources().getDrawable(R.drawable.ic_drop_down)));
        data.add(new CountryData("Eng", "22K", this.getResources().getDrawable(R.drawable.white_dot) , this.getResources().getDrawable(R.drawable.ic_arrow_up)));
        data.add(new CountryData("Aus", "12K", this.getResources().getDrawable(R.drawable.white_dot) , this.getResources().getDrawable(R.drawable.ic_drop_down)));
        data.add(new CountryData("Ind", "7K", this.getResources().getDrawable(R.drawable.white_dot) , this.getResources().getDrawable(R.drawable.ic_arrow_up)));
        data.add(new CountryData("Pak", "3K", this.getResources().getDrawable(R.drawable.white_dot) , this.getResources().getDrawable(R.drawable.ic_drop_down)));
        data.add(new CountryData("Afg", "18k", this.getResources().getDrawable(R.drawable.white_dot) , this.getResources().getDrawable(R.drawable.ic_arrow_up)));

        ChartDataAdapter adapter = new ChartDataAdapter(ChartActivity.this , data);

        recyclerView.setAdapter(adapter);

    }

    public void backProfileViews(View view) {
        onBackPressed();
    }

}