package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        BlankFragment blankFragment = new BlankFragment();
        fragmentTransaction.add(R.id.topFragment, blankFragment, null);

        fragmentTransaction.commit();

        button.setOnClickListener(v -> {
            BlankFragment2 blankFragment2 = new BlankFragment2();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.topFragment, blankFragment2, null);
            fragmentTransaction.commit();
        }


    }
}