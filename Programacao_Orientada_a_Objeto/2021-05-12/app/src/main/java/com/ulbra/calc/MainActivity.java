package com.ulbra.calc;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private EditText inputPriceGasoline;
    private EditText inputPriceAlcohol;
    private TextView viewResult;

    private TextView messageErrorGasoline;
    private TextView messageErrorAlcohol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        inputPriceGasoline = findViewById(R.id.gasoline);
        inputPriceAlcohol = findViewById(R.id.alcohol);
        viewResult = findViewById(R.id.result);
        messageErrorGasoline = findViewById(R.id.messageErrorGasoline);
        messageErrorAlcohol = findViewById(R.id.messageErrorAlcohol);
        Button buttonSubmit = findViewById(R.id.submit);


        inputPriceAlcohol.addTextChangedListener(new MoneyTextWatcher(inputPriceAlcohol));
        inputPriceAlcohol.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(inputIsEmpty(inputPriceAlcohol)) {
                    messageErrorAlcohol.setVisibility(View.VISIBLE);
                } else {
                    messageErrorAlcohol.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });

        inputPriceGasoline.addTextChangedListener(new MoneyTextWatcher(inputPriceGasoline));
        inputPriceGasoline.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(inputIsEmpty(inputPriceGasoline)) {
                    messageErrorGasoline.setVisibility(View.VISIBLE);
                } else {
                    messageErrorGasoline.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });

        inputPriceAlcohol.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(inputIsEmpty(inputPriceAlcohol)) {
                        messageErrorAlcohol.setVisibility(View.VISIBLE);
                    } else {
                        messageErrorAlcohol.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
        inputPriceGasoline.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if(inputIsEmpty(inputPriceGasoline)) {
                        messageErrorGasoline.setVisibility(View.VISIBLE);
                    } else {
                        messageErrorGasoline.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        buttonSubmit.setOnClickListener(v -> calcPrice());
    }

    public  void calcPrice() {
        inputPriceAlcohol.clearFocus();
        inputPriceGasoline.clearFocus();

        if(!inputIsEmpty(inputPriceGasoline) && !inputIsEmpty(inputPriceAlcohol)) {
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

            createToast(resultMessage);
        } else {
            if(inputIsEmpty(inputPriceAlcohol)) {
                messageErrorAlcohol.setVisibility(View.VISIBLE);
                inputPriceAlcohol.requestFocus();
            } else {
                messageErrorAlcohol.setVisibility(View.INVISIBLE);
            }
            if(inputIsEmpty(inputPriceGasoline)) {
                messageErrorGasoline.setVisibility(View.VISIBLE);
                inputPriceGasoline.requestFocus();
            } else {
                messageErrorGasoline.setVisibility(View.INVISIBLE);
            }
            String errorMessage = getString(R.string.message_error_calculator);
            createToast(errorMessage);
        }
    }

    public void createToast(String message) {
        Toast toast = Toast.makeText( getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }

    public boolean inputIsEmpty(EditText input) {
        if(input.getText().toString().length() == 0) {
            return true;
        }
        return Double.parseDouble(
                MoneyTextWatcher.parseToBigDecimal(
                        input.getText().toString()).toString()) == 0;
    }
}