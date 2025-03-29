package br.fecapccp.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAbrirCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbrirCalculadora = findViewById(R.id.btnAbrirCalculadora);

        btnAbrirCalculadora.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CalculoIMCActivity.class);
            startActivity(intent);
        });
    }
}
