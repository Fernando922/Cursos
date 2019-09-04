package com.udemy.cardview.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.udemy.cardview.Activity.adapter.PostagemAdapter;
import com.udemy.cardview.Activity.model.Postagem;
import com.udemy.cardview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();   //tem que instanciar ja que vc vai adicionar dados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //define layout
        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayout.HORIZONTAL);  //mostra os cards em horizontal
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        recyclerPostagem.setLayoutManager(layoutManager);


        //define adapter
        this.prepararPostagens();
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);

    }

    public void prepararPostagens() {
        Postagem p = new Postagem("Fernando de Paula", "#top", R.drawable.imagem1);
        this.postagens.add(p);

        p = new Postagem("José Rodrigues", "#foi chique!", R.drawable.imagem2);
        this.postagens.add(p);

        p = new Postagem("Claudia Paiva", "#Paris!!", R.drawable.imagem3);
        this.postagens.add(p);

        p = new Postagem("Marcela", "#EOQ", R.drawable.imagem4);
        this.postagens.add(p);

    }

}
