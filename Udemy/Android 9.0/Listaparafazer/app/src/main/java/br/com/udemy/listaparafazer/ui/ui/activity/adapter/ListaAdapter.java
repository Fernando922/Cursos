package br.com.udemy.listaparafazer.ui.ui.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.udemy.listaparafazer.R;
import br.com.udemy.listaparafazer.ui.model.Tarefa;
import br.com.udemy.listaparafazer.ui.utils.ImageUtils;

public class ListaAdapter extends BaseAdapter {


    private ArrayList<Tarefa> tarefas;
    private Context context;

    public ListaAdapter(Context context, ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Tarefa getItem(int position) {
        return tarefas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_tarefas, parent, false);
        }

        Tarefa tarefa = getItem(position);

        TextView tvDescricao = convertView.findViewById(R.id.item_tvDescricao);
        ImageView ivFoto = convertView.findViewById(R.id.item_ivTarefa);


        tvDescricao.setText(tarefa.getDescricao());
        ImageUtils.setImagem(ivFoto, tarefa.getImagem(), 60, 60);

        return convertView;

    }
}
