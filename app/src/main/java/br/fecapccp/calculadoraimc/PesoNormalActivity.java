package br.fecapccp.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PesoNormalActivity extends AppCompatActivity {

    private TextView txtDados, txtMensagem;
    private ImageView imagem;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_normal);

        txtDados = findViewById(R.id.txtDados);
        txtMensagem = findViewById(R.id.txtMensagem);
        imagem = findViewById(R.id.imgResultado);
        btnFechar = findViewById(R.id.btnFechar);

        Intent intent = getIntent();
        double peso = intent.getDoubleExtra("peso", 0);
        double altura = intent.getDoubleExtra("altura", 0);
        double imc = intent.getDoubleExtra("imc", 0);

        String resultado = "Peso: " + peso + " kg\n" +
                "Altura: " + altura + " m\n" +
                "IMC: " + String.format("%.2f", imc) +
                "\nClassificação: Peso Normal";

        txtDados.setText(resultado);
        txtMensagem.setText("Parabéns! Você está com o peso ideal 😊");
        imagem.setImageResource(R.drawable.peso_normal);

        btnFechar.setOnClickListener(v -> {
            finish(); // volta pra tela anterior
        });
    }
}
