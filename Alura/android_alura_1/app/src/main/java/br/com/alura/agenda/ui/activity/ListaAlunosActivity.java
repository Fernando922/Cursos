package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.alura.agenda.R;
import br.com.alura.agenda.ui.activity.DAO.AlunoDAO;


public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_lista_alunos);

        configuraFabNovoAluno();

//        sua lista estatica anterior
//        List<String> alunos = new ArrayList<>(
//                Arrays.asList("alex", "fernando", "maria", "josé")
//        );
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoSalvar = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioAlunoActivity();
            }
        });
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }


    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listView);
        //vincular conteudo com lista, este arrayAdapter eu devo passar o contexto(activity atual, e o layout que eu desejo utilizar)
        //qualquer layout pronto, vc nao altera!
        listaDeAlunos.setAdapter(
                new ArrayAdapter<>(  //o tipo fica implicito em teempo de execução entao pode deixar <> de boa
                        this,
                        android.R.layout.simple_list_item_1,  //layout pronto
                        dao.todos()));   //array a ser renderizado
    }
}
