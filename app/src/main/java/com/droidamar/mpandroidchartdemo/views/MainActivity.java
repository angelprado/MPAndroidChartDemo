package com.droidamar.mpandroidchartdemo.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.droidamar.mpandroidchartdemo.R;
import com.droidamar.mpandroidchartdemo.util.MPUtil;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random r = new Random();

        List<Float> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add((float) (r.nextInt(300 - 50) + 50));
        }

        chart = (BarChart) findViewById(R.id.chart);

        BarData barData2 = new BarData(MPUtil.getXAxisValues(20), MPUtil.getDataSet(MainActivity.this, dataList));
        MPUtil.drawChart(MainActivity.this, chart, barData2);
    }
}
