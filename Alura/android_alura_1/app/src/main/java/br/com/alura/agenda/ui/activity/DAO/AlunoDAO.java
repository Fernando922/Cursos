package br.com.alura.agenda.ui.activity.DAO;

import java.util.ArrayList;
import java.util.List;
import br.com.alura.agenda.ui.activity.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();  //metodo de classe ( estático ) fica em memoria!

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }


    //retorna uma cópia evitando a quebra de encapsulamento
    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
