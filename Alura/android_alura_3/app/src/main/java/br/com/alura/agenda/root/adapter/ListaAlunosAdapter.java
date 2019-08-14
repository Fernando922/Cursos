package br.com.alura.agenda.root.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.root.model.Aluno;


//é necessário a criação de uma nova classe para a implementação de novos métodos!
public class ListaAlunosAdapter extends BaseAdapter {
    //é necessario criar uma lista interna (DATASET) para manipular
    //os itens, é necessário para nao ficar muito colado no DAO
    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }


    @Override
    //retorna a quantidade de elementos na lista
    public int getCount() {
        return alunos.size();
    }

    @Override
    //retona o item desejado baseado na sua posição
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
        //opcional, pq nem sempre seus dados vao ter um id (retorna o id do aluno )
    }

    @Override
    //view que será apresentada a cada item do adapter!
    //aqui que a view é criada para ser exibida de acordo com o seu layout
    //para isso o layout deve ser inflado na lista :)
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View viewCriada = criaView(viewGroup);

        Aluno alunoDevolvido = alunos.get(position);

        vinculaInformacoes(viewCriada, alunoDevolvido);
        return viewCriada;
    }

    private void vinculaInformacoes(View view, Aluno aluno) {
        TextView nome = view.findViewById(R.id.item_aluno_nome);
        nome.setText(aluno.getNome());
        TextView telefone = view.findViewById(R.id.item_aluno_telefone);
        telefone.setText(aluno.getTelefone());
    }

    private View criaView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
    }

    public void atualiza(List<Aluno> alunos){
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();  //notifica que o dataset foi modificado para atualizar a pagina !!!
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged(); //modifica que o dataset foi modificado para atualizar a pagina !!!!
    }
}
