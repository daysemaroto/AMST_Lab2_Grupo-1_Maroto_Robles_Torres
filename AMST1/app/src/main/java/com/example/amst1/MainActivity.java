package com.example.amst1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fltCal;
    FloatingActionButton fltYtb;
    FloatingActionButton fltMap;
    FloatingActionButton fltGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fltCal = (FloatingActionButton)findViewById(R.id.fltCal);
        fltYtb = (FloatingActionButton)findViewById(R.id.fltYtb);
        fltMap= (FloatingActionButton)findViewById(R.id.fltMap);
        fltGraph= (FloatingActionButton)findViewById(R.id.fltGraph);



        fltCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),calendario.class);
                startActivity(i);
            }
        });

        fltYtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),youtube.class);
                startActivity(i);
            }
        });

        fltMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);
            }
        });

        fltGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),graficoLineal.class);
                startActivity(i);
            }
        });
    }
}