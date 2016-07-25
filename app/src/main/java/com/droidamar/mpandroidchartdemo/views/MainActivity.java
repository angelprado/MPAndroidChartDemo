package com.droidamar.mpandroidchartdemo.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.droidamar.mpandroidchartdemo.R;
import com.droidamar.mpandroidchartdemo.util.MPUtil;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BarChart chart;
    private AppCompatButton btnXAnimation, btnYAnimation, btnXYAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Random r = new Random();
        List<Float> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add((float) (r.nextInt(300 - 20) + 20));
        }

        BarData barData2 = new BarData(MPUtil.getXAxisValues(20), MPUtil.getDataSet(MainActivity.this, dataList));
        MPUtil.drawChart(MainActivity.this, chart, barData2);

        btnXAnimation.setOnClickListener(this);
        btnYAnimation.setOnClickListener(this);
        btnXYAnimation.setOnClickListener(this);
    }

    private void init() {
        chart = (BarChart) findViewById(R.id.chart);
        btnXAnimation = (AppCompatButton) findViewById(R.id.btnXAnimation);
        btnYAnimation = (AppCompatButton) findViewById(R.id.btnYAnimation);
        btnXYAnimation = (AppCompatButton) findViewById(R.id.btnXYAnimation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnXAnimation:
                chart.animateX(3000);
                break;
            case R.id.btnYAnimation:
                chart.animateY(3000);
                break;
            case R.id.btnXYAnimation:
                chart.animateXY(3000, 3000);
                break;
        }
    }
}
