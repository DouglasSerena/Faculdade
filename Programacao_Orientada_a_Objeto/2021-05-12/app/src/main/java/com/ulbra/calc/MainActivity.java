package com.ulbra.calc;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
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

    private float scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        scale = getResources().getDisplayMetrics().density;

        inputPriceGasoline = findViewById(R.id.gasoline);
        inputPriceAlcohol = findViewById(R.id.alcohol);
        viewResult = findViewById(R.id.result);
        messageErrorGasoline = findViewById(R.id.messageErrorGasoline);
        messageErrorAlcohol = findViewById(R.id.messageErrorAlcohol);
        Button buttonSubmit = findViewById(R.id.submit);


        inputPriceAlcohol.setOnKeyListener((View v, int keyCode, KeyEvent event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                this.calcPrice();
            }
            return false;
        });
        inputPriceAlcohol.addTextChangedListener(new MoneyTextWatcher(inputPriceAlcohol));
        inputPriceAlcohol.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validInputIsEmpty(inputPriceAlcohol, messageErrorAlcohol);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        inputPriceGasoline.addTextChangedListener(new MoneyTextWatcher(inputPriceGasoline));
        inputPriceGasoline.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validInputIsEmpty(inputPriceGasoline, messageErrorGasoline);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        inputPriceAlcohol.setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (!hasFocus) {
                validInputIsEmpty(inputPriceAlcohol, messageErrorAlcohol, getString(R.string.message_invalid_required_field_blur));
            }
        });
        inputPriceGasoline.setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (!hasFocus) {
                validInputIsEmpty(inputPriceGasoline, messageErrorGasoline, getString(R.string.message_invalid_required_field_blur));
            }
        });

        buttonSubmit.setOnClickListener(v -> calcPrice());
    }

    public void calcPrice() {
        if (!inputIsEmpty(inputPriceGasoline) && !inputIsEmpty(inputPriceAlcohol)) {
            double priceGasoline = Double.parseDouble(
                    MoneyTextWatcher.parseToBigDecimal(
                            inputPriceGasoline.getText().toString()).toString());

            double priceAlcohol = Double.parseDouble(
                    MoneyTextWatcher.parseToBigDecimal(
                            inputPriceAlcohol.getText().toString()).toString());

            double result = priceAlcohol / priceGasoline;

            if (result >= 0.7) {
                viewResult.setText(R.string.better_result_to_use_gasoline);
            } else {
                viewResult.setText(R.string.better_result_to_use_alcohol);
            }

            String resultMessage = getString(R.string.result) + ": " + viewResult.getText().toString();

            viewResult.setContentDescription(resultMessage);

            createToast(resultMessage);
        } else {
            validInputIsEmpty(inputPriceAlcohol, messageErrorAlcohol, null, true);
            validInputIsEmpty(inputPriceGasoline, messageErrorGasoline, null, true);

            String errorMessage = getString(R.string.message_error_calculator);
            createToast(errorMessage);
        }
    }

    public void createToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }

    public boolean inputIsEmpty(EditText input) {
        if (input.getText().toString().length() == 0) {
            return true;
        }
        return Double.parseDouble(
                MoneyTextWatcher.parseToBigDecimal(
                        input.getText().toString()).toString()) == 0;
    }

    public void validInputIsEmpty(EditText input, TextView messageError) {
        validInputIsEmpty(input, messageError, null, false);
    }

    public void validInputIsEmpty(EditText input, TextView messageError, String messageToast) {
        validInputIsEmpty(input, messageError, messageToast, false);
    }

    public void validInputIsEmpty(EditText input, TextView messageError, String messageToast, boolean withFocus) {
        if (inputIsEmpty(input)) {
            messageError.setVisibility(View.VISIBLE);
            messageError.setHeight((int) (18 * scale));
            if (messageToast != null) {
                createToast(messageToast);
            }
            if (withFocus) {
                input.requestFocus();
            }
        } else {
            messageError.setVisibility(View.INVISIBLE);
            messageError.setHeight(0);
        }
    }
}