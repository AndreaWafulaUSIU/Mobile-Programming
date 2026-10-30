package com.example.catone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // (ii) Declare the widgets
    EditText etNum1, etNum2, etNum3, etAnswer;
    Button btnMax, btnMin, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (ii) Bind the widgets to the ids in the XML layout
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etNum3 = findViewById(R.id.etNum3);
        etAnswer = findViewById(R.id.etAnswer);
        btnMax = findViewById(R.id.btnMax);
        btnMin = findViewById(R.id.btnMin);
        btnNext = findViewById(R.id.btnNext);

        // (iii) Click event: display the Maximum
        btnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] nums = readNumbers();
                if (nums == null) return;
                int max = Math.max(nums[0], Math.max(nums[1], nums[2]));
                etAnswer.setText(String.valueOf(max));
            }
        });

        // (iii) Click event: display the Minimum
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] nums = readNumbers();
                if (nums == null) return;
                int min = Math.min(nums[0], Math.min(nums[1], nums[2]));
                etAnswer.setText(String.valueOf(min));
            }
        });

        // (iv-a) Jump to the second activity, (iv-b) sending the minimum and maximum
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] nums = readNumbers();
                if (nums == null) return;
                int max = Math.max(nums[0], Math.max(nums[1], nums[2]));
                int min = Math.min(nums[0], Math.min(nums[1], nums[2]));

                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtra("MIN_VALUE", min);
                intent.putExtra("MAX_VALUE", max);
                startActivity(intent);
            }
        });
    }

    // Reads the three inputs. Returns null (with a Toast) if any is missing or invalid.
    private int[] readNumbers() {
        String s1 = etNum1.getText().toString().trim();
        String s2 = etNum2.getText().toString().trim();
        String s3 = etNum3.getText().toString().trim();

        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
            Toast.makeText(this, "Please enter all three numbers", Toast.LENGTH_SHORT).show();
            return null;
        }
        try {
            return new int[]{
                    Integer.parseInt(s1),
                    Integer.parseInt(s2),
                    Integer.parseInt(s3)
            };
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid integers", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
