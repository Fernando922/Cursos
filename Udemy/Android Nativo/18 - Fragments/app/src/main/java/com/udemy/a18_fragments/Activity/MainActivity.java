package com.udemy.a18_fragments.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.udemy.a18_fragments.Fragment.ContatosFragment;
import com.udemy.a18_fragments.Fragment.ConversasFragment;
import com.udemy.a18_fragments.R;

public class MainActivity extends AppCompatActivity {

    private Button btnContato, btnConversas;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContato = findViewById(R.id.btnContatos);
        btnConversas = findViewById(R.id.btnConversas);

        //remover sombra actionBar
        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();

        //configurar objeto para o fragmento

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fmConteudo, conversasFragment);
        transaction.commit();


        btnContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contatoFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fmConteudo, contatoFragment);
                transaction.commit();
            }
        });

        btnConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversasFragment = new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fmConteudo, conversasFragment);
                transaction.commit();
            }
        });



    }
}
