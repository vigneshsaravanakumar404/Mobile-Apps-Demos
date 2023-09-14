package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView secondTextview;
    Button secondButton;

    public static final String EXTRAEXTRA_CODE = "code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondButton = findViewById(R.id.secondButton);
        secondTextview = findViewById(R.id.secondTextView);

        secondButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(EXTRAEXTRA_CODE, secondTextview.getText().toString() + "EXTRA");
            setResult(RESULT_OK);
            finish();
        });
        secondTextview.setText(getIntent().getStringExtra(MainActivity.EXTRA_CODE));

    }
}