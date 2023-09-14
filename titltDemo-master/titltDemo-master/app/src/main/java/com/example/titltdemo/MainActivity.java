package com.example.titltdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // Create Vars
    TextView textView, maxX, maxY, maxZ;
    double maxXValue, maxYValue, maxZValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        maxX = findViewById(R.id.maxX);
        maxY = findViewById(R.id.maxY);
        maxZ = findViewById(R.id.maxZ);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        sensorManager.registerListener(MainActivity.this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(MainActivity.this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView.setText("X: " + sensorEvent.values[0] +
                "\nY: " + sensorEvent.values[1] +
                "\nZ: " + sensorEvent.values[2]);

        if (Math.abs(sensorEvent.values[0]) > maxXValue) {
            maxXValue = (double) Math.abs(sensorEvent.values[0]);
            maxX.setText("Max X: " + maxXValue + "m/s^2");
        }
        if (Math.abs(sensorEvent.values[0]) > maxYValue) {
            maxYValue = (double) Math.abs(sensorEvent.values[1]);
            maxY.setText("Max Y: " + maxYValue + "m/s^2");
        }
        if (Math.abs(sensorEvent.values[0]) > maxZValue) {
            maxZValue = (double) Math.abs(sensorEvent.values[2]);
            maxZ.setText("Max Z: " + maxZValue + "m/s^2");
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}