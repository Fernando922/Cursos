package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.ui.activity.DAO.AlunoDAO;
import br.com.alura.agenda.ui.activity.model.Aluno;
import br.com.alura.agenda.ui.adapter.ListaAlunosAdapter;

import static br.com.alura.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;


public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    private final AlunoDAO dao = new AlunoDAO();
    private ListaAlunosAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_lista_alunos);

        configuraFabNovoAluno();
        configuraLista();

    }


    //cria o menu de contexto!!!!
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //atribui o xml ao menu de contexto criado
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //a solução só da para adapterView msm
        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_de_alunos_menu_remover) {
            AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
            remove(alunoEscolhido);
        }

        return super.onContextItemSelected(item);
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoSalvar = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoSalvar.setOnClickListener((view) -> abreFormularioModoInsereAluno());
    }

    private void abreFormularioModoInsereAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }


    @Override
    protected void onResume() {
        super.onResume();
        atualizaAlunos();
    }

    private void atualizaAlunos() {
        adapter.clear();  //apaga tudo
        adapter.addAll(dao.todos()); //adiciona tudo de novo (atualiza o dataSet, se nunca teve nada, agora tem)
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listView);
        configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);   //registra o menu de contexto na lista
        //como a lista é uma adapter view, poderia dar problema, mas o registerForContext
        //é bonzinho e já aplica a função para cada item da lista para você :)
    }


//    Remover o item apenas segurando o item sem confirmação nem nada

//    private void configuraListenerDeCliqueLongoPorItem(ListView listaDeAlunos) {
//        listaDeAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id) {
//                Aluno alunoSelecionado = (Aluno) adapterView.getItemAtPosition(posicao);
//                remove(alunoSelecionado);
//                return true;
//            }
//        });
//    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);  //remove da lista original e nao da copia
        adapter.remove(aluno);  //remove do adapter, para atualizar a lista em tempo real!
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
                abreFormularioModoEditaAluno(alunoEscolhido);
            }
        });
    }

    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent intent = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        intent.putExtra(CHAVE_ALUNO, aluno);
        startActivity(intent);
    }

    private void configuraAdapter(ListView listaDeAlunos) {

        adapter = new ListaAlunosAdapter(this);
        listaDeAlunos.setAdapter(this.adapter);
    }
}
