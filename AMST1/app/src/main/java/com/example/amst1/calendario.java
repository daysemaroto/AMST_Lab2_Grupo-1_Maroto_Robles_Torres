package com.example.amst1;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class calendario extends AppCompatActivity {
    CalendarView calendarView;
    TextView myDate;
    Button btnSalir;
    Calendar calendar;
    //private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMM- yyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        btnSalir = (Button) findViewById(R.id.btnSalir);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        calendar.set(Calendar.YEAR, 2020);

        myDate = (TextView) findViewById(R.id.myDate);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if (year == 2020 & month == 10 & dayOfMonth == 20){
                    Toast toast=Toast.makeText(getApplicationContext(),"Clases de AMST",Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Toast toast=Toast.makeText(getApplicationContext(),"Nada programado para esta fecha",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });







    }
}