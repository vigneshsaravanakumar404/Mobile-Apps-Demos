package com.example.broadcastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BroadcastReceiver receiver = new BatteryMonitor();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
//        batteryFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
//        registerReceiver(receiver, batteryFilter);


    }

    public static class BatteryMonitor extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

            if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
                Toast.makeText(context, "Charging", Toast.LENGTH_LONG).show();
            } else if (status == BatteryManager.BATTERY_STATUS_FULL) {
                Toast.makeText(context, "Battery Full", Toast.LENGTH_LONG).show();
            } else if (status == BatteryManager.BATTERY_STATUS_DISCHARGING) {
                Toast.makeText(context, "Discharging", Toast.LENGTH_LONG).show();
            } else if (status == BatteryManager.BATTERY_STATUS_NOT_CHARGING) {
                Toast.makeText(context, "Not Charging", Toast.LENGTH_LONG).show();
            } else if (status == BatteryManager.BATTERY_STATUS_UNKNOWN) {
                Toast.makeText(context, "Unknown", Toast.LENGTH_LONG).show();
            }




            Toast.makeText(context, "Message Received", Toast.LENGTH_LONG).show();


        }
    }
}