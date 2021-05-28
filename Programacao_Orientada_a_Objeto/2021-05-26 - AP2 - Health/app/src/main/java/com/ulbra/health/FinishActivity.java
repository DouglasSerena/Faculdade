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

        scoreParcelable = getIntent().getExtras().getParcelable("score");

        Button btnRestart = findViewById(R.id.btnRestart);
        TextView textScoreTotal = findViewById(R.id.textScoreTotal);
        TextView textResult = findViewById(R.id.textResult);

        int score = scoreParcelable.getScoreTotal();

        textScoreTotal.setText(String.valueOf(score));

        if(score < 12) {
            textResult.setText(getResources().getStringArray(R.array.options_results)[0]);
            textResult.setTextColor(getColor(R.color.success));
        } else if(score < 18) {
            textResult.setText(getResources().getStringArray(R.array.options_results)[1]);
            textResult.setTextColor(getColor(R.color.success));
        } else if(score < 25) {
            textResult.setText(getResources().getStringArray(R.array.options_results)[2]);
            textResult.setTextColor(getColor(R.color.warning));
        } else if (score < 32) {
            textResult.setText(getResources().getStringArray(R.array.options_results)[3]);
            textResult.setTextColor(getColor(R.color.warning));
        } else if (score < 41) {
            textResult.setText(getResources().getStringArray(R.array.options_results)[4]);
            textResult.setTextColor(getColor(R.color.danger));
        } else {
            textResult.setText(getResources().getStringArray(R.array.options_results)[5]);
            textResult.setTextColor(getColor(R.color.danger));
        }

        btnRestart.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}
