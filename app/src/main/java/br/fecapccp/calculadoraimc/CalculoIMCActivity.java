package br.fecapccp.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CalculoIMCActivity extends AppCompatActivity {

    private EditText edtPeso, edtAltura;
    private Button btnCalcular, btnLimpar, btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFechar = findViewById(R.id.btnFechar);

        btnCalcular.setOnClickListener(v -> {
            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double imc = peso / (altura * altura);

            Intent intent;

            if (imc < 18.5) {
                intent = new Intent(this, AbaixoDoPesoActivity.class);
            } else if (imc < 25) {
                intent = new Intent(this, PesoNormalActivity.class);
            } else if (imc < 30) {
                intent = new Intent(this, SobrepesoActivity.class);
            } else if (imc < 35) {
                intent = new Intent(this, Obesidade1Activity.class);
            } else if (imc < 40) {
                intent = new Intent(this, Obesidade2Activity.class);
            } else {
                intent = new Intent(this, Obesidade3Activity.class);
            }

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("imc", imc);

            startActivity(intent);
        });

        btnLimpar.setOnClickListener(v -> {
            edtPeso.setText("");
            edtAltura.setText("");
        });

        btnFechar.setOnClickListener(v -> finish());
    }
}
