package com.app.vsam.fragments;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import com.app.vsam.R;

public class BossomBuddyStatsFragment extends Fragment {

    LineChart lineChart1 , lineChart2 , lineChart3 , lineChart4;
    LineData lineData1 , lineData2 , lineData3 , lineData4;
    LineDataSet lineDataSet1 , lineDataSet2 , lineDataSet3 , lineDataSet4;
    ArrayList dataEntry1 , dataEntry2 , dataEntry3 , dataEntry4;

    public BossomBuddyStatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bossom_buddy_stats, container, false);

        lineChart1 = view.findViewById(R.id.lineChart1);
        lineChart2 = view.findViewById(R.id.lineChart2);
        lineChart3 = view.findViewById(R.id.lineChart3);
        lineChart4 = view.findViewById(R.id.lineChart4);

        getEntries();

        lineDataSet1 = new LineDataSet(dataEntry1 , "");
        lineData1 = new LineData(lineDataSet1);
        lineChart1.setData(lineData1);

        lineChart1.getAxisLeft().setDrawGridLines(false);
        lineChart1.getAxisLeft().setTextColor(Color.WHITE);
        lineChart1.getAxisLeft().setAxisLineWidth(2f);
        lineChart1.getXAxis().setDrawGridLines(false);
        lineChart1.getXAxis().setTextColor(Color.WHITE);
        lineChart1.getXAxis().setAxisLineWidth(2f);
        lineChart1.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart1.getAxisRight().setDrawGridLines(false);
        lineChart1.getAxisRight().setDrawAxisLine(false);
        lineChart1.getAxisRight().setDrawLabels(false);
        lineChart1.getLegend().setEnabled(false);

        setupGradient(lineChart1);

        lineDataSet1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet1.setLineWidth(3f);
        lineDataSet1.setDrawValues(false);
        lineDataSet1.setValueTextSize(16f);
        lineDataSet1.setDrawCircles(false);

        lineDataSet2 = new LineDataSet(dataEntry2 , "");
        lineData2 = new LineData(lineDataSet2);
        lineChart2.setData(lineData2);
        lineChart2.getAxisLeft().setDrawGridLines(false);
        lineChart2.getAxisLeft().setTextColor(Color.WHITE);
        lineChart2.getAxisLeft().setAxisLineWidth(2f);
        lineChart2.getXAxis().setDrawGridLines(false);
        lineChart2.getXAxis().setTextColor(Color.WHITE);
        lineChart2.getXAxis().setAxisLineWidth(2f);
        lineChart2.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart2.getAxisRight().setDrawGridLines(false);
        lineChart2.getAxisRight().setDrawAxisLine(false);
        lineChart2.getAxisRight().setDrawLabels(false);
        lineChart2.getLegend().setEnabled(false);

        setupGradient(lineChart2);

        lineDataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet2.setLineWidth(3f);
        lineDataSet2.setDrawValues(false);
        lineDataSet2.setValueTextSize(16f);
        lineDataSet2.setDrawCircles(false);

        lineDataSet3 = new LineDataSet(dataEntry3 , "");
        lineData3 = new LineData(lineDataSet3);
        lineChart3.setData(lineData3);
        lineChart3.getAxisLeft().setDrawGridLines(false);
        lineChart3.getAxisLeft().setTextColor(Color.WHITE);
        lineChart3.getAxisLeft().setAxisLineWidth(2f);
        lineChart3.getXAxis().setDrawGridLines(false);
        lineChart3.getXAxis().setTextColor(Color.WHITE);
        lineChart3.getXAxis().setAxisLineWidth(2f);
        lineChart3.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart3.getAxisRight().setDrawGridLines(false);
        lineChart3.getAxisRight().setDrawAxisLine(false);
        lineChart3.getAxisRight().setDrawLabels(false);
        lineChart3.getLegend().setEnabled(false);

        setupGradient(lineChart3);

        lineDataSet3.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet3.setLineWidth(3f);
        lineDataSet3.setDrawValues(false);
        lineDataSet3.setValueTextSize(16f);
        lineDataSet3.setDrawCircles(false);

        lineDataSet4 = new LineDataSet(dataEntry4 , "");
        lineData4 = new LineData(lineDataSet3);
        lineChart4.setData(lineData3);
        lineChart4.getAxisLeft().setDrawGridLines(false);
        lineChart4.getAxisLeft().setTextColor(Color.WHITE);
        lineChart4.getAxisLeft().setAxisLineWidth(2f);
        lineChart4.getXAxis().setDrawGridLines(false);
        lineChart4.getXAxis().setTextColor(Color.WHITE);
        lineChart4.getXAxis().setAxisLineWidth(2f);
        lineChart4.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart4.getAxisRight().setDrawGridLines(false);
        lineChart4.getAxisRight().setDrawAxisLine(false);
        lineChart4.getAxisRight().setDrawLabels(false);
        lineChart4.getLegend().setEnabled(false);

        setupGradient(lineChart4);

        lineDataSet4.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet4.setLineWidth(3f);
        lineDataSet4.setDrawValues(false);
        lineDataSet4.setValueTextSize(16f);
        lineDataSet4.setDrawCircles(false);

        return view;
    }

    private void setupGradient(LineChart mChart) {
        Paint paint = mChart.getRenderer().getPaintRender();

        LinearGradient linGrad = new LinearGradient(0f, 600f, 0f, 0f,
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                Shader.TileMode.CLAMP);
        paint.setShader(linGrad);
    }

    private void getEntries(){
        dataEntry1 = new ArrayList<>();
        dataEntry1.add(new BarEntry(100f , 12));
        dataEntry1.add(new BarEntry(200f , 4));
        dataEntry1.add(new BarEntry(300f , 3));
        dataEntry1.add(new BarEntry(400f , 5));
        dataEntry1.add(new BarEntry(500f , 6));
        dataEntry1.add(new BarEntry(600f , 4));

        dataEntry2 = new ArrayList<>();
        dataEntry2.add(new BarEntry(1f , 2));
        dataEntry2.add(new BarEntry(2f , 4));
        dataEntry2.add(new BarEntry(3f , 3));
        dataEntry2.add(new BarEntry(4f , 5));
        dataEntry2.add(new BarEntry(5f , 6));
        dataEntry2.add(new BarEntry(6f , 4));

        dataEntry3 = new ArrayList<>();
        dataEntry3.add(new BarEntry(1f , 2));
        dataEntry3.add(new BarEntry(2f , 4));
        dataEntry3.add(new BarEntry(3f , 3));
        dataEntry3.add(new BarEntry(4f , 5));
        dataEntry3.add(new BarEntry(5f , 6));
        dataEntry3.add(new BarEntry(6f , 4));

        dataEntry4 = new ArrayList<>();
        dataEntry4.add(new BarEntry(1f , 2));
        dataEntry4.add(new BarEntry(2f , 4));
        dataEntry4.add(new BarEntry(3f , 3));
        dataEntry4.add(new BarEntry(4f , 5));
        dataEntry4.add(new BarEntry(5f , 6));
        dataEntry4.add(new BarEntry(6f , 4));

    }
}