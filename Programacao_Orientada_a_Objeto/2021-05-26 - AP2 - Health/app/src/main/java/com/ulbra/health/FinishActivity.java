package com.ulbra.health;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ulbra.health.parcelables.ScoreParcelable;

import java.util.Objects;

public class FinishActivity extends AppCompatActivity {
    ScoreParcelable scoreParcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Objects.requireNonNull(getSupportActionBar()).hide();

//        scoreParcelable = getIntent().getExtras().getParcelable("score");

        Button btnRestart = findViewById(R.id.btnRestart);
        TextView textScoreTotal = findViewById(R.id.textScoreTotal);

//        textScoreTotal.setText(scoreParcelable.getScoreTotal());

        btnRestart.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}
