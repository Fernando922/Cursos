package br.com.udemy.listadetarefas.helper;


import java.util.List;

import br.com.udemy.listadetarefas.model.Tarefa;

//data access object, ler e salvar dados no banco
public class TarefaDAO implements ITarefaDAO {

    @Override
    public boolean salvar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        return null;
    }
}
