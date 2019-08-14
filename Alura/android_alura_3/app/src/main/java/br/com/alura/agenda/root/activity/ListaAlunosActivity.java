package br.com.alura.agenda.root.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import br.com.alura.agenda.R;
import br.com.alura.agenda.root.ListaAlunosView;
import br.com.alura.agenda.root.model.Aluno;
import static br.com.alura.agenda.root.activity.ConstantesActivities.CHAVE_ALUNO;


public class ListaAlunosActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Lista de alunos";
    private final ListaAlunosView listaAlunosView = new ListaAlunosView(this);  //this é o contexto

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
        if (itemId == R.id.activity_lista_de_alunos_menu_remover) {  //verifica se escolhi a opção remover msm!
            listaAlunosView.confirmaRemocao(item);

        } else if (itemId == R.id.activity_lista_de_alunos_menu_elogio) {
            Toast.makeText(this, "Você é lindão! :)", Toast.LENGTH_LONG).show();
        }

        return super.onContextItemSelected(item);
    }



    private void configuraFabNovoAluno() {
        FloatingActionButton botaoSalvar = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoSalvar.setOnClickListener((view) -> abreFormularioModoInsereAluno());
    }


    @Override
    protected void onResume() {
        super.onResume();
        listaAlunosView.atualizaAlunos();
    }


    private void configuraLista() {
        //pega a referencia da lista desejada e exibir os dados
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listView);

        listaAlunosView.configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);   //registra o menu de contexto na lista

    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener((adapterView, view, posicao, id) -> {
            Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
            abreFormularioModoEditaAluno(alunoEscolhido);
        });
    }


    private void abreFormularioModoInsereAluno() {
        Intent intent = new Intent(this, FormularioAlunoActivity.class);
        startActivity(intent);
    }

    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent intent = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        intent.putExtra(CHAVE_ALUNO, aluno);   //envia o extra como parametro para ser editado, mas o aluno deve ser do tipo serializavel
        startActivity(intent);
    }


}
