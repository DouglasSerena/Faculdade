package com.ulbra.health;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;

import com.ulbra.health.parcelables.ScoreParcelable;
import com.ulbra.health.types.Score;

import java.util.Objects;

public class OptionActivity extends AppCompatActivity {
    int indexOptionCurrent = 0;
    RadioGroup radioGroupOptions;
    TextView textLabel;
    TextView textScoreTotal;
    TextView textCount;

    ScoreParcelable scoreParcelable = new ScoreParcelable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button btnNext = findViewById(R.id.btnNext);
        Button btnBack = findViewById(R.id.btnBack);

        radioGroupOptions = findViewById(R.id.options);
        textLabel = findViewById(R.id.textLabel);
        textScoreTotal = findViewById(R.id.textScoreTotal);
        textCount = findViewById(R.id.textCount);

        createView();

        radioGroupOptions.setOnCheckedChangeListener((group, checkedId) -> {
            int indexRadioButton = group.indexOfChild(findViewById(checkedId));
            scoreParcelable.setChecked(indexOptionCurrent, indexRadioButton);
            textScoreTotal.setText(String.valueOf(scoreParcelable.getScoreTotal()));
        });

        btnBack.setOnClickListener(v -> handleBack());
        btnNext.setOnClickListener(v -> handleNext());
    }

    @Override
    public void onBackPressed() {
        handleBack();
    }

    private void handleBack() {
        if (indexOptionCurrent == 0) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else {
            indexOptionCurrent--;
            createView();
        }
    }

    private void handleNext() {
        if (indexOptionCurrent < 7) {
            indexOptionCurrent++;
            createView();
        } else {
            Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
            intent.putExtra("score", scoreParcelable);
            startActivity(intent);
        }
    }

    private void createView() {
        textScoreTotal.setText(String.valueOf(scoreParcelable.getScoreTotal()));
        textCount.setText((this.indexOptionCurrent + 1) + "/" + (Score.getTotalOptions() + 2));

        switch (indexOptionCurrent) {
            case 0:
                fillLabel(R.string.label_age);
                fillRadios(R.array.options_age);
                break;
            case 1:
                fillLabel(R.string.label_sex);
                fillRadios(R.array.options_sex);
                break;
            case 2:
                fillLabel(R.string.label_weight);
                fillRadios(R.array.options_weight);
                break;
            case 3:
                fillLabel(R.string.label_activity);
                fillRadios(R.array.options_activity);
                break;
            case 4:
                fillLabel(R.string.label_smokes);
                fillRadios(R.array.options_smokes);
                break;
            case 5:
                fillLabel(R.string.label_pressure);
                fillRadios(R.array.options_pressure);
                break;
            case 6:
                fillLabel(R.string.label_illness_in_family);
                fillRadios(R.array.options_illness_in_family);
                break;
            case 7:
                fillLabel(R.string.label_cholesterol);
                fillRadios(R.array.options_cholesterol);
                break;
        }
    }

    private void fillLabel(int stringId) {
        textLabel.setText(getResources().getString(stringId));
    }

    private void fillRadios(int stringArrayId) {
        String[] optionsString = getResources().getStringArray(stringArrayId);
        int[] checked = scoreParcelable.getChecked();

        for (int index = 0; index < optionsString.length; index++) {
            RadioButton option = (RadioButton) radioGroupOptions.getChildAt(index);
            if (checked[indexOptionCurrent] == index) {
                option.setChecked(true);
            }
            option.setText(optionsString[index]);
        }
    }
}