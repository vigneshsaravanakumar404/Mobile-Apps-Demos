package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static final String EXTRA_CODE = "abc123";
    static final int REQ_CODE = 123;
    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.mainTextView);
        button = findViewById(R.id.mainButton);


        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(EXTRA_CODE, "This is from the Main");
            startActivity(intent);

            startActivityForResult(intent, REQ_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            textView.setText(data.getStringExtra(SecondActivity.EXTRAEXTRA_CODE));
        }
    }
}