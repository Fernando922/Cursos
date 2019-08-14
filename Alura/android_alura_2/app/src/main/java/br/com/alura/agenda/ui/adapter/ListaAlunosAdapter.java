package br.com.alura.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.ui.activity.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {


    private List<Aluno> alunos = new ArrayList<>();
    private Context context;

    public ListaAlunosAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        //tamanho da lista
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) {
        //retorna um aluno a partir de sua posição
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        //retorna o id do item (não é obrigatório, caso nao existir ID)
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
        return viewCriada;
    }

    public void clear() {
        alunos.clear();
    }

    public void addAll(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
    }
}
