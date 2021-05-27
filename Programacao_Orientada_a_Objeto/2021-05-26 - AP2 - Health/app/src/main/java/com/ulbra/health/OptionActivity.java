package com.ulbra.health;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class OptionActivity extends AppCompatActivity {
    int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button btnNext = findViewById(R.id.btnNext);
        Button btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            if(option == 0) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                option--;
            }
        });
        btnNext.setOnClickListener(v -> {
            if(option < 8) {
                option++;
            } else {
                Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
                startActivity(intent);
            }
        });
    }
}