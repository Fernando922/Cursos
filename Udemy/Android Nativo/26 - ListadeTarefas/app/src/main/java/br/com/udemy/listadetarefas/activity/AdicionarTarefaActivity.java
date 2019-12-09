package br.com.udemy.listadetarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import br.com.udemy.listadetarefas.R;
import br.com.udemy.listadetarefas.helper.TarefaDAO;
import br.com.udemy.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);


        editTarefa = findViewById(R.id.textTarefa);

        //recuperar tarefa, caso seja edição
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        //configurar tarefa na caixa de texto
        if (tarefaAtual != null) {
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adicionar_tarefa_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemSalvar:
                //executa a ação de salvar
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                String nomeTarefa = editTarefa.getText().toString();
                if (nomeTarefa.isEmpty()) {
                    Toast.makeText(this, "Digite o nome da tarefa!", Toast.LENGTH_SHORT).show();
                } else {
                    if (tarefaAtual == null) {  //inserindo nova
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        if (tarefaDAO.salvar(tarefa)) {
                            Toast.makeText(this, "Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(this, "Erro ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        }
                    } else {   //editando tarefa
                        if (!nomeTarefa.isEmpty()) {
                            Tarefa tarefa = new Tarefa();
                            tarefa.setNomeTarefa(nomeTarefa);
                            tarefa.setId(tarefaAtual.getId());

                            //atualizar no banco de dados
                            if (tarefaDAO.atualizar(tarefa)) {
                                Toast.makeText(this, "Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(this, "Erro ao salvar tarefa!", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
