package br.com.udemy.minhaagenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.udemy.minhaagenda.R;
import br.com.udemy.minhaagenda.data.model.Contato;

public class ListaAdapter extends BaseAdapter {

    private ArrayList<Contato> contatos;
    private Context context;

    public ListaAdapter(Context context, ArrayList<Contato> contatos) {  //construtor do adapter
        this.contatos = contatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Contato getItem(int position) {
        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {

        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_contatos, parent, false);
        }

        Contato contato = getItem(position);

        TextView txtNome = convertView.findViewById(R.id.item_lista_contato_nome);
        TextView txtEmail = convertView.findViewById(R.id.item_lista_contato_email);
        ImageView viewImage = convertView.findViewById(R.id.item_lista_contato_imagem);

        txtEmail.setText(contato.getEmail());
        txtNome.setText(contato.getNome());


        return convertView;
    }
}
