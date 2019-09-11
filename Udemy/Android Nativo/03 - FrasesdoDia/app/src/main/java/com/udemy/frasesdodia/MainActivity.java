package com.udemy.frasesdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarFrase(View view){   //View view é pq será chamado a partir de um método de interface
        String[] frases = {
                "Eu prefiro morrer do que perder a vida.",
                "Tubarão que dorme a onda leva.",
                "Pau que nasce torto nunca se indireita.",
                "Mais vale um pássaro na mão do que dois voando.",
                "Não procure ser o melhor, mas sim o mais simples. Porque até a maior árvore da floresta começa do chão.",
                "Se você cansar, aprenda a descansar e não a desistir.",
                "Toda mente é um cofre. Não existem mentes impenetráveis, apenas chaves erradas.",
                "Não adianta encher de perfume se o que falta é a essência.",
                "Troque suas folhas, mas não perca suas raízes. Mude suas opiniões, mas não perca seus princípios.",
                "Ignorar é a forma mais elegante de se defender da maldade.",
                "Não faça da sua vida um rascunho, poderá não ter tempo de passá-la a limpo.",
                "A paciência é a chave para todos os problemas que não dependem de você."
        };
        int numero = new Random().nextInt(frases.length);

        TextView resposta = findViewById(R.id.tvResultado);
        resposta.setText(frases[numero]);
    }
}
