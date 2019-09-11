package br.com.udemy.listadetarefas.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.udemy.listadetarefas.helper.DbHelper;
import br.com.udemy.listadetarefas.helper.RecyclerItemClickListener;
import br.com.udemy.listadetarefas.R;
import br.com.udemy.listadetarefas.adapter.TarefaAdapter;
import br.com.udemy.listadetarefas.model.Tarefa;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabNovo;
    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabNovo = findViewById(R.id.fabNovo);

        //configura recycler
        recyclerView = findViewById(R.id.rvListaTarefas);

        //instanciando um banco



        //adicionar evento de clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(MainActivity.this, "clique no item", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(MainActivity.this, "clique longo", Toast.LENGTH_SHORT).show();
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

        //configura banco


    }

    @Override
    protected void onStart() {
        carrregarListaTarefas();
        super.onStart();
    }

    //montagem das tarefas
    public void carrregarListaTarefas(){
        //listar tarefas (recupera do banco)
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setNomeTarefa("Ir ao mercado");
        listaTarefas.add(tarefa1);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setNomeTarefa("Lavar Roupa");
        listaTarefas.add(tarefa2);

        Tarefa tarefa3 = new Tarefa();
        tarefa3.setNomeTarefa("Estudar");
        listaTarefas.add(tarefa3);


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
