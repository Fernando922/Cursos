package br.com.udemy.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText etAlcool, etGasolina;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAlcool = findViewById(R.id.etAlcool);
        etGasolina = findViewById(R.id.etGasolina);
        tvResultado = findViewById(R.id.tvResultado);
    }


    public void calcular(View view) {

        //recupera campos digitados
        String precoAlcool = etAlcool.getText().toString();
        String precoGasolina = etGasolina.getText().toString();

        Boolean camposValidados = this.validaCampos(precoAlcool, precoGasolina);

        if (camposValidados) {
            this.calcularMelhorPreco(precoAlcool, precoGasolina);
        } else {
            tvResultado.setText("Preencha todos os campos!");
        }


    }

    public void calcularMelhorPreco(String p1, String p2) {
        double alcool = Double.parseDouble(p1);
        double gasolina = Double.parseDouble(p2);

        if (alcool / gasolina < 0.7) {
            tvResultado.setText("Melhor utilizar Álcool!");
        } else {
            tvResultado.setText("Melhor utilizar Gasolina!");
        }

    }

    public Boolean validaCampos(String p1, String p2) {
        Boolean camposValidados = true;


        if (p1 == null || p1.equals("")) {
            camposValidados = false;
        } else if (p2 == null || p2.equals("")) {
            camposValidados = false;
        }


        return camposValidados;
    }
}
