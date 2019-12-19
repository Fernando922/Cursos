package br.com.udemy.listaparafazer.ui.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.udemy.listaparafazer.R;
import br.com.udemy.listaparafazer.ui.dao.TarefaDao;
import br.com.udemy.listaparafazer.ui.model.Tarefa;
import br.com.udemy.listaparafazer.ui.ui.activity.adapter.ListaAdapter;
import br.com.udemy.listaparafazer.ui.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PERMISSOES = 645;

    private FloatingActionButton fabNovaTarefa;

    ListView listaTarefas;
    ArrayList<Tarefa> tarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaTarefas = findViewById(R.id.lista_tarefas); //atribui layout lista tarefas

        //este é o listener de clique por item para edição
        listaTarefas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Tarefa tarefa = tarefas.get(position); //recupera no array de acordo com o index e cria uma instancia de tarefa


                //qualquer objeto passado como parametro ou a ser salvo no banco deve ser do tipo serializavel!!!
                //uma intent chama a outra tela, no exemplo abaixo como estou passando um parametro para ser verificado do outro lado
                //indica que eu quero editar esse objeto da lista
                Intent intent = new Intent(MainActivity.this, CadastraTarefa.class);
                intent.putExtra(Constants.PARAMETRO_TAREFA, tarefa); //uso de constantes evita erro de digitação

            }
        });

        fabNovaTarefa = findViewById(R.id.fab_novo);
        fabNovaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //vamos criar uma intent pra ir pra outra tela cadastrar um novo
                Intent intent = new Intent(MainActivity.this, CadastraTarefa.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        criaAdapter();
    }

    private void criaAdapter() {
        //adapter é uma classe que faz intermedio entre o que ta no banco e suas views, serve para popular a lista
        listaTarefas.setAdapter(new ListaAdapter(this, getTarefas()));
    }

    private ArrayList<Tarefa> getTarefas() {
        tarefas = new ArrayList();
        TarefaDao tarefaDao = new TarefaDao(this);
        tarefas = tarefaDao.buscaTarefas();
        tarefaDao.close();
        return tarefas;
    }
}

