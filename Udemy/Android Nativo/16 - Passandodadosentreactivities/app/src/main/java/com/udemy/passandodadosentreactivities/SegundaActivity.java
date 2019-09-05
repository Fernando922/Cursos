package com.udemy.passandodadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView nome, numero, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        nome = findViewById(R.id.tvNome);
        email = findViewById(R.id.tvEmail);
        numero = findViewById(R.id.tvNumero);


        //recuperar dados enviados
        Bundle dados = getIntent().getExtras();   //instancia um objeto do tipo bundle
        String nomeRetorno = dados.getString("nome");
        Integer numeroRetorno = dados.getInt("numero");
        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        nome.setText(nomeRetorno);
        numero.setText(numeroRetorno.toString());  //ou String.valueOf(idade)
        email.setText(usuario.getEmail());
    }
}
