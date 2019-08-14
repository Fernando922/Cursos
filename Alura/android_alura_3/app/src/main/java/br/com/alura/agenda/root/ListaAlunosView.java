package br.com.alura.agenda.root;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import br.com.alura.agenda.root.DAO.AlunoDAO;
import br.com.alura.agenda.root.model.Aluno;
import br.com.alura.agenda.root.adapter.ListaAlunosAdapter;

public class ListaAlunosView {

    private final ListaAlunosAdapter adapter;
    private final Context context;
    private final AlunoDAO dao;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunosAdapter(this.context);
        this.dao = new AlunoDAO();
    }

    public void confirmaRemocao(final MenuItem item) {
        new AlertDialog
                .Builder(context) //padrão builder (construir, instanciar e fazer chamadas na criação
                .setTitle("Remover aluno")
                .setMessage("Tem certeza que deseja remover o aluno?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);  //remove da lista original e nao da copia
        adapter.remove(aluno);  //remove do adapter, para atualizar a lista em tempo real!
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        //é necessario vincular a referencia da view para um adapter,
        //para exbir os dados no layout adequado e também manipular os dados caso necessário!
        listaDeAlunos.setAdapter(adapter);   //atribuo o adapter a lista!!!
    }
}
