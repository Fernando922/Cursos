package br.com.udemy.minhaagenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.udemy.minhaagenda.R;
import br.com.udemy.minhaagenda.data.dao.ContatoDao;
import br.com.udemy.minhaagenda.data.model.Contato;
import br.com.udemy.minhaagenda.ui.adapter.ListaAdapter;

public class ListaActivity extends AppCompatActivity {

    ListView listaContatosView;
    ArrayList<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContatosView = findViewById(R.id.lista_lista_contatos);
        listaContatosView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Contato contato = contatos.get(position);

                Intent intent = new Intent(ListaActivity.this, CadastraActivity.class);
                intent.putExtra(CadastraActivity.PARAMETRO_CONTATO, contato);  //uso de constantes evita erro de digitação
                startActivity(intent);
            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaActivity.this, CadastraActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(listaContatosView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        criaAdapter();
    }

    private void criaAdapter() {
        listaContatosView.setAdapter(new ListaAdapter(this, getContatos()));
    }

    private ArrayList<Contato> getContatos() {
        contatos = new ArrayList();

        ContatoDao contatoDao = new ContatoDao(this);
        contatos = contatoDao.buscaContatos();
        contatoDao.close();
        return contatos;
    }


    //adapter é uma classe que faz intermedio entre o que ta no banco e suas views, serve para popular sua lista
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Contato contato = (Contato) listaContatosView.getItemAtPosition(info.position);

        MenuItem del = menu.add("Apagar");
        del.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                ContatoDao dao = new ContatoDao(ListaActivity.this);
                dao.remove(contato);
                criaAdapter();
                dao.close();
                return false;
            }
        });

    }
}
