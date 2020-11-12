package com.example.amst1;

import androidx.appcompat.app.AppCompatActivity;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class graficoLineal extends AppCompatActivity {

    LineChartView lineChartView;
    String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct"};
    int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_lineal);

        lineChartView = findViewById(R.id.chart);

        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();


        Line line = new Line(yAxisValues).setColor(Color.parseColor("#ff7400"));

        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#000000"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("Sales in millions");
        yAxis.setTextColor(Color.parseColor("#000000"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 61;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);

    }
}