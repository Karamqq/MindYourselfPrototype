package com.example.prototype2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.Arrays;

public class SleepActivity extends AppCompatActivity {
    //initialise variables
    private EditText sleepHoursInput;
    private TextView printAverage,averageHint,moreDetail;
    private Button clearButton;
    private CardView sleepCard;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        //set variables to view ids
        Button plotButton = findViewById(R.id.plot_button);
        averageHint = findViewById(R.id.sleep_hint);
        sleepHoursInput = findViewById(R.id.sleep_hours_input);
        printAverage = findViewById(R.id.sleep_average);
        clearButton = findViewById(R.id.clear_button);
        moreDetail = findViewById(R.id.detailsLink);
        sleepCard = findViewById(R.id.sleepCard);

        //on click for the plot button
        plotButton.setOnClickListener(view -> {


            //check to see if input is empty
            if (sleepHoursInput.getText().toString().isEmpty()) {
                Toast.makeText(SleepActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }


            //checks if input is in the correct format
            int[] sleepHours = parseSleepHoursInput();
            if (sleepHours == null) {
                Toast.makeText(SleepActivity.this, "Invalid input. Please enter a valid hour value for each day of the week, seperated by Commas", Toast.LENGTH_SHORT).show();
                return;
            }


            //runs the function and calculates average input
            plotSleepData(sleepHours);
            int average = computeAverage(sleepHours);
            printAverage.setText(String.valueOf(average));
            String lessthan6hours = getResources().getString(R.string.less6hours);
            String sleep7to9hours = getResources().getString(R.string.sleep7to9);
            String sleep10ormore = getResources().getString(R.string.sleep10ormore);


            //checks whether sleep hours are healthy or not and sets correct message to view
            if(average <= 6) {
            averageHint.setText(lessthan6hours);
            }
            if(average >=7 && average <=9) {
                averageHint.setText(sleep7to9hours);
            }
            if(average >9) {
                averageHint.setText(sleep10ormore);
            }
        });

        // on click for card allowing user to view relevant website on sleep
        sleepCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moreDetail.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });


        // on click to clear all edit texts and average
        clearButton.setOnClickListener(view -> {
            GraphView sleepHoursPlot = findViewById(R.id.sleep_hours_plot);
            sleepHoursPlot.removeAllSeries();
            printAverage.setText(" ");
            sleepHoursInput.setText("");
            averageHint.setText("");
            // Clear the chart here
        });
    }


    // function takes the input string and sorts it into na array of ints
    private int[] parseSleepHoursInput() {
        String inputString = sleepHoursInput.getText().toString();
        String[] inputArray = inputString.split(",");
        if (inputArray.length != 7) {
            return null;
        }


        //uses the int array to store the 7 values
        int[] sleepHours = new int[7];
        for (int i = 0; i < inputArray.length; i++) {
            try {
                sleepHours[i] = Integer.parseInt(inputArray[i]);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return sleepHours;
    }


    //uses the sleephours array and plots on graphview
    private void plotSleepData(int[] sleepHours) {
        GraphView sleepHoursPlot = findViewById(R.id.sleep_hours_plot);
        DataPoint[] dataPoints = new DataPoint[sleepHours.length];
        for (int i = 0; i < sleepHours.length; i++) {
            dataPoints[i] = new DataPoint(i + 1, sleepHours[i]);
        }
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(dataPoints);
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
            }
        });
        sleepHoursPlot.addSeries(series);


        sleepHoursPlot.getViewport().setMinX(1);
        sleepHoursPlot.getViewport().setMaxX(8);
        sleepHoursPlot.getViewport().setMinY(0);
        sleepHoursPlot.getViewport().setMaxY(24);
        sleepHoursPlot.getViewport().setYAxisBoundsManual(true);
        sleepHoursPlot.getViewport().setXAxisBoundsManual(true);
        sleepHoursPlot.getGridLabelRenderer().setHorizontalAxisTitle("Days of the Week");
        sleepHoursPlot.getGridLabelRenderer().setVerticalAxisTitle("Hours");
    }
    //calculates average from values passed
    private int computeAverage(int[] values) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return (int) Arrays.stream(values).average().orElse(0);
        }
        return 0;
      }
}
