package com.ulbra.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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

    Button btnNext;
    Button btnBack;

    ScoreParcelable scoreParcelable = new ScoreParcelable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        radioGroupOptions = findViewById(R.id.options);
        textLabel = findViewById(R.id.textLabel);
        textScoreTotal = findViewById(R.id.textScoreTotal);
        textCount = findViewById(R.id.textCount);

        createView();

        radioGroupOptions.setOnCheckedChangeListener((group, checkedId) -> {
            int indexRadioButton = group.indexOfChild(findViewById(checkedId));
            scoreParcelable.setChecked(indexOptionCurrent, indexRadioButton);
            textScoreTotal.setText(String.valueOf(scoreParcelable.getScoreTotal()));
            validBtnNext();
        });

        btnBack.setOnClickListener(v -> handleBack());
        btnNext.setOnClickListener(v -> handleNext());
    }

    @Override
    public void onBackPressed() {
        if(indexOptionCurrent > 0) {
            handleBack();
        } else {
            super.onBackPressed();
        }
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
        if (indexOptionCurrent < Score.totalOptionsScore - 1) {
            indexOptionCurrent++;
            createView();
        } else {
            Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
            intent.putExtra("score", scoreParcelable);
            startActivity(intent);
        }
    }

    private void validBtnBack()  {
        btnBack.setVisibility(indexOptionCurrent == 0 ? View.INVISIBLE : View.VISIBLE);
    }

    private void validBtnNext() {
        int[] checked = scoreParcelable.getChecked();
        btnNext.setEnabled(checked[indexOptionCurrent] > -1);

        if(indexOptionCurrent < Score.totalOptionsScore - 1) {
            btnNext.setText(getString(R.string.btn_next));
        } else {
            btnNext.setText(getString(R.string.btn_finish));
        }
    }

    private void createView() {
        textScoreTotal.setText(String.valueOf(scoreParcelable.getScoreTotal()));
        textCount.setText(
                ((this.indexOptionCurrent + 1) + "/" + (Score.totalOptionsScore)));

        switch (indexOptionCurrent) {
            case 0:
                fillView(R.string.label_age,R.array.options_age);
                break;
            case 1:
                fillView(R.string.label_sex,R.array.options_sex);
                break;
            case 2:
                fillView(R.string.label_weight,R.array.options_weight);
                break;
            case 3:
                fillView(R.string.label_activity,R.array.options_activity);
                break;
            case 4:
                fillView(R.string.label_smokes,R.array.options_smokes);
                break;
            case 5:
                fillView(R.string.label_pressure,R.array.options_pressure);
                break;
            case 6:
                fillView(R.string.label_illness_in_family,R.array.options_illness_in_family);
                break;
            case 7:
                fillView(R.string.label_cholesterol,R.array.options_cholesterol);
                break;
        }
    }

    private void fillView(int stringId, int stringArrayId) {
        textLabel.setText(getResources().getString(stringId));

        String[] optionsString = getResources().getStringArray(stringArrayId);
        int[] checked = scoreParcelable.getChecked();
        RadioButton btnRadioOption;

        for (int index = 0; index < optionsString.length; index++) {
            btnRadioOption = (RadioButton) radioGroupOptions.getChildAt(index);

            btnRadioOption.setText(optionsString[index]);
        }

        if(checked[indexOptionCurrent] > -1) {
            btnRadioOption = (RadioButton) radioGroupOptions.getChildAt(checked[indexOptionCurrent]);
            btnRadioOption.setChecked(true);
        } else {
            radioGroupOptions.clearCheck();
        }
        validBtnNext();
        validBtnBack();
    }
}