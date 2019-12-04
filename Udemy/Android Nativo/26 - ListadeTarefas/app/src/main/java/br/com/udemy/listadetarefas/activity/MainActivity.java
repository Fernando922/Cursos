package br.com.udemy.listadetarefas.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.udemy.listadetarefas.R;
import br.com.udemy.listadetarefas.adapter.TarefaAdapter;
import br.com.udemy.listadetarefas.helper.RecyclerItemClickListener;
import br.com.udemy.listadetarefas.helper.TarefaDAO;
import br.com.udemy.listadetarefas.model.Tarefa;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabNovo;
    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private Tarefa tarefaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabNovo = findViewById(R.id.fabNovo);

        //configura recycler
        recyclerView = findViewById(R.id.rvListaTarefas);

        //adicionar evento de clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //recuperar a tarefa para edição
                                Tarefa tarefaSelecionada = listaTarefas.get(position);

                                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                                intent.putExtra("tarefaSelecionada", tarefaSelecionada);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                //Recuperar para deletar
                                tarefaSelecionada = listaTarefas.get(position);

                                //confirmar se é isso mesmo!
                                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                                dialog.setTitle("Confirmar exclusão");
                                dialog.setMessage("Deseja excluir a tarefa: " + tarefaSelecionada.getNomeTarefa() + "?");

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        TarefaDAO tarefaDAO = new TarefaDAO((getApplicationContext()));

                                        if (tarefaDAO.deletar(tarefaSelecionada)) {
                                            carrregarListaTarefas();
                                            Toast.makeText(MainActivity.this, "Tarefa excluída com sucesso!", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(MainActivity.this, "Erro ao excluir a tarefa!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                dialog.setNegativeButton("Não", null);
                                dialog.create();
                                dialog.show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )

        );

        fabNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        carrregarListaTarefas();
        super.onStart();
    }

    //montagem das tarefas
    public void carrregarListaTarefas() {

        //quando era estático
//        Tarefa tarefa1 = new Tarefa();
//        tarefa1.setNomeTarefa("Ir ao mercado");
//        listaTarefas.add(tarefa1);
//
//        Tarefa tarefa2 = new Tarefa();
//        tarefa2.setNomeTarefa("Lavar Roupa");
//        listaTarefas.add(tarefa2);
//
//        Tarefa tarefa3 = new Tarefa();
//        tarefa3.setNomeTarefa("Estudar");
//        listaTarefas.add(tarefa3);


        //listar tarefas (recupera do banco)
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listaTarefas = tarefaDAO.listar();

        //exibe a lista de tarefas no RecyclerView

        //configurar adapter
        tarefaAdapter = new TarefaAdapter(listaTarefas);

        //configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));  //divisor entre cada item
        recyclerView.setAdapter(tarefaAdapter);
    }
}
