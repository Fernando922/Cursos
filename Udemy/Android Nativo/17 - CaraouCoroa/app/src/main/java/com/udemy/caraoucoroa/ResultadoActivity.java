package com.udemy.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    ImageView ivResultado, ivVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        ivResultado = findViewById(R.id.ivResultado);
        ivVoltar = findViewById(R.id.ivVoltar);



        //recuperando dados recebidos
        Bundle dados = getIntent().getExtras();
        int resultado = dados.getInt("numero");

        if(resultado == 0){
            ivResultado.setImageResource(R.drawable.moeda_cara);
        }else{
            ivResultado.setImageResource(R.drawable.moeda_coroa);
        }

        //evento de clique para voltar pra home
        ivVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
