package com.udemy.recyclerview.activity.activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.udemy.recyclerview.R;
import com.udemy.recyclerview.activity.activity.adapter.Adapter;
import com.udemy.recyclerview.activity.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //listagem de filmes
        this.criarFilmes();

        //configura adapter
        Adapter adapter = new Adapter(listaFilmes);


        //configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        MainActivity.this,
                                        filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(
                                        MainActivity.this,
                                        "Click longo",
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    public void criarFilmes() {
        Filme filme = new Filme("Homem Aranha - De Volta ao lar", "Aventura", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Capitão América - Guerra Civil", "Aventura/Ficção", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Pica-Pau: O Filme", "Comédia/Animação", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("A Múmia", "Terror", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
        this.listaFilmes.add(filme);


    }
}
