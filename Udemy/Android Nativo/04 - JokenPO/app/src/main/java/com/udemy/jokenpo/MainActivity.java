package com.udemy.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void opcaoSelecionada(String escolhaUsuario) {

        String[] opcoes = {"pedra", "papel", "tsoura"};
        ImageView imagemResultado = findViewById(R.id.ivResultado);
        imagemResultado.setImageResource(R.drawable.pedra);
        TextView resultado = findViewById(R.id.tvResultado);


        String escolhaComputador = opcoes[new Random().nextInt(3)];


        switch (escolhaUsuario) {
            case "papel":
                if (escolhaComputador == "papel") {
                    imagemResultado.setImageResource(R.drawable.papel);
                    resultado.setText("Empate!");
                } else if (escolhaComputador == "tesoura") {
                    imagemResultado.setImageResource(R.drawable.tesoura);
                    resultado.setText("Você perdeu!");
                } else {
                    imagemResultado.setImageResource(R.drawable.pedra);
                    resultado.setText("Você ganhou!");
                }
                break;
            case "tesoura":
                if (escolhaComputador == "tesoura") {
                    imagemResultado.setImageResource(R.drawable.tesoura);
                    resultado.setText("Empate!");
                } else if (escolhaComputador == "pedra") {
                    imagemResultado.setImageResource(R.drawable.pedra);
                    resultado.setText("Você perdeu!");
                } else {
                    imagemResultado.setImageResource(R.drawable.papel);
                    resultado.setText("Você ganhou!");
                }
                break;
            case "pedra":
                if (escolhaComputador == "pedra") {
                    resultado.setText("Empate!");
                    imagemResultado.setImageResource(R.drawable.pedra);
                } else if (escolhaComputador == "papel") {
                    imagemResultado.setImageResource(R.drawable.papel);
                    resultado.setText("Você perdeu!");
                } else {
                    imagemResultado.setImageResource(R.drawable.tesoura);
                    resultado.setText("Você ganhou!");
                }
                break;
        }
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }
}
