package br.com.udemy.calculadoradegorjetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etValorConta, etGorjeta, etTotalConta;
    private SeekBar skPorcentagem;
    private TextView tvPorcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicialização das referencias
        skPorcentagem = findViewById(R.id.sbPorcentagem);
        etValorConta = findViewById(R.id.etValorConta);
        etGorjeta = findViewById(R.id.etValorGorgeta);
        etTotalConta = findViewById(R.id.etValorTotal);
        tvPorcentagem = findViewById(R.id.tvPorcentagem);


        skPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double valorConta = Double.parseDouble(etValorConta.getText().toString());
                if (valorConta> 0) {
                    Toast.makeText(MainActivity.this, "Digite o valor da conta!", Toast.LENGTH_SHORT).show();
                } else {
                    int valor = seekBar.getProgress();
                    double valorGorgeta = valorConta * (valor / 100);
                    tvPorcentagem.setText(valor + "%");
                    etGorjeta.setText(Double.toString(valorGorgeta));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Não seja mão de vaca!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
