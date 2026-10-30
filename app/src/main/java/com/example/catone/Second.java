package com.example.catone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// (iv) Second activity: receives the minimum and maximum and shows them in two TextViews
public class Second extends AppCompatActivity {

    TextView tvMinimum, tvMaximum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        tvMinimum = findViewById(R.id.tvMinimum);
        tvMaximum = findViewById(R.id.tvMaximum);

        Intent intent = getIntent();
        int min = intent.getIntExtra("MIN_VALUE", 0);
        int max = intent.getIntExtra("MAX_VALUE", 0);

        tvMinimum.setText("Minimum: " + min);
        tvMaximum.setText("Maximum: " + max);
    }
}
