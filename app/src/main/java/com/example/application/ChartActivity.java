package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Pie;
import com.anychart.anychart.ValueDataEntry;
import com.anychart.anychart.chart.common.Event;
import com.anychart.anychart.chart.common.ListenersInterface;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String value = extras.getString("key");
//            //The key argument here must match that used in the other activity
//            TextView textView = (TextView) findViewById(R.id.text_view);
//            textView.setText(value);
//        }
//
//
//        Pie pie = AnyChart.pie();
//        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
//            @Override
//            public void onClick(Event event) {
//                Toast.makeText(ChartActivity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
//            }
//        });




    }
}
