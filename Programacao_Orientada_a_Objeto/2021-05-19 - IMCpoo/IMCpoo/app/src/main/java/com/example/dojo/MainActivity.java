package com.example.dojo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText pesoEditText;
    EditText alturaEditText;
    TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        pesoEditText = (EditText) findViewById(R.id.peso);
        alturaEditText = (EditText) findViewById(R.id.altura);
        resultadoTextView = (TextView) findViewById(R.id.textResultado);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(
                    pesoEditText.getText().length()==0 ||
                    alturaEditText.getText().length()==0
                ){
                    Toast.makeText(
                            getApplicationContext(),
                            "Por favor preencha o campo",
                            Toast.LENGTH_SHORT
                    ).show();
                }else{
                    double peso = (Double) Double.parseDouble(
                            pesoEditText.getText().toString());
                    double altura = (Double) Double.parseDouble(
                            alturaEditText.getText().toString());

                    if(peso==0 || altura==0.0){
                        Toast.makeText(
                                getApplicationContext(),"Preencha um valor válido",
                                Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        calcular(peso, altura);
                    }
                }
            }
        });
    }

    public void calcular(double peso, double altura) {
        DecimalFormat df = new DecimalFormat("#.00");
        double textResultado = peso / (altura * altura);
        if(textResultado<18.5){
            resultadoTextView.setText("Seu IMC é " + df.format(textResultado) + ". Está abaixo do ideal");
        }else if(textResultado>18.6 && textResultado<24.9){
            resultadoTextView.setText("Seu IMC é " + df.format(textResultado) + ". Está no peso ideal");
        }else if(textResultado>25.0 && textResultado<29.9){
            resultadoTextView.setText("Seu IMC é " + df.format(textResultado) + ". Está levemente acima do peso ideal");
        }else if(textResultado>30.0 && textResultado<34.9){
            resultadoTextView.setText("Seu IMC é " + df.format(textResultado) + ". Está com obesidade grau 1");
        }else if(textResultado>35.0 && textResultado<39.9){
            resultadoTextView.setText("Seu IMC é " + df.format(textResultado) + ". Está com obesidade grau 2 (severa)");
        } else{
            resultadoTextView.setText("Seu IMC é " + df.format(textResultado) + ". Está com obesidade grau 3 (mórbida)");
        }

    }
}