package com.ulbra.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private EditText inputPriceGasoline;
    private EditText inputPriceAlcohol;
    private TextView viewResult;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        inputPriceGasoline = findViewById(R.id.gasoline);
        inputPriceAlcohol = findViewById(R.id.alcohol);
        viewResult = findViewById(R.id.result);
        buttonSubmit = findViewById(R.id.submit);

        inputPriceAlcohol.addTextChangedListener(new MoneyTextWatcher(inputPriceAlcohol));
        inputPriceGasoline.addTextChangedListener(new MoneyTextWatcher(inputPriceGasoline));

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcPrice();
            }
        });
    }

    public  void calcPrice() {
        double priceGasoline = Double.parseDouble(
                MoneyTextWatcher.parseToBigDecimal(
                        inputPriceGasoline.getText().toString()).toString());

        double priceAlcohol = Double.parseDouble(
                MoneyTextWatcher.parseToBigDecimal(
                        inputPriceAlcohol.getText().toString()).toString());

        double result = priceAlcohol / priceGasoline;

        if(result >= 0.7) {
            viewResult.setText(R.string.better_result_to_use_gasoline);
        } else {
            viewResult.setText(R.string.better_result_to_use_alcohol);
        }

        String resultMessage = getString(R.string.result) + ": " + viewResult.getText().toString();

        viewResult.setContentDescription(resultMessage);

        Toast toast = Toast.makeText( getApplicationContext(), resultMessage, Toast.LENGTH_LONG);
        toast.show();
    }
}