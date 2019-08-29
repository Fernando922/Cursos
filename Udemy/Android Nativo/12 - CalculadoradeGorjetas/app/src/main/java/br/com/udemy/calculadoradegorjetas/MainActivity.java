package br.com.udemy.calculadoradegorjetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etValorConta;
    private TextView tvPorcentagem, tvValorGorjeta, tvValorTotal;
    private SeekBar sbPorcentagem;

    private double porcentagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etValorConta = findViewById(R.id.etValorTotal);
        tvPorcentagem = findViewById(R.id.tvPorcentagem);
        tvValorGorjeta = findViewById(R.id.tvValorGorjeta);
        tvValorTotal = findViewById(R.id.tvValorTotal);
        sbPorcentagem = findViewById(R.id.sbPorcentagem);

        sbPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (etValorConta.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Digite o valor da conta!", Toast.LENGTH_SHORT).show();
                    seekBar.setProgress(0);
                    tvPorcentagem.setText(Math.round(porcentagem) + "%");
                }else{
                    porcentagem = seekBar.getProgress();
                    tvPorcentagem.setText(Math.round(porcentagem) + "%");
                    calcular();

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!etValorConta.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Não seja mão de vaca!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void calcular(){
        double valorDigitado = Double.parseDouble(etValorConta.getText().toString());
        double gorjeta = valorDigitado * (porcentagem/100);
        double total = gorjeta + valorDigitado;

        tvValorGorjeta.setText("R$ " + Math.round(gorjeta));
        tvValorTotal.setText("R$ " + Math.round(total));
    }
}
