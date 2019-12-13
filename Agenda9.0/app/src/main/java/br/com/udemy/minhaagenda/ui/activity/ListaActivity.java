package br.com.udemy.minhaagenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.udemy.minhaagenda.R;
import br.com.udemy.minhaagenda.data.model.Contato;
import br.com.udemy.minhaagenda.ui.adapter.ListaAdapter;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listaContatosView = findViewById(R.id.lista_lista_contatos);

        listaContatosView.setAdapter(new ListaAdapter(this, getContatos()));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ListaActivity.this, "oi moço", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Contato> getContatos() {
        ArrayList<Contato> contatos = new ArrayList<Contato>();

        for(int i = 1; i<11 ; i++){
            Contato contato = new Contato();
            contato.setNome("Nome Contato " + i);
            contato.setEmail("Email contato " + i);
            contatos.add(contato);
        }
        return contatos;
    }


    //adapter é uma classe que faz intermedio entre o que ta no banco e suas views, serve para popular sua lista

}
