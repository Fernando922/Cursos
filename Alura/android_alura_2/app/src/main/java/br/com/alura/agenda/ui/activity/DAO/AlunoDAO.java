package br.com.alura.agenda.ui.activity.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.ui.activity.model.Aluno;

public class AlunoDAO {

    private static int contadorDeIds = 1;

    private final static List<Aluno> alunos = new ArrayList<>();  //metodo de classe ( estático ) fica em memoria!

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);
        if (alunoEncontrado != null) {
            //encontra a posição do aluno e logo em seguida, adiciona o novo aluno no mesmo lugar
            //fazendo a substituição
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }
    }

    private Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }


    //retorna uma cópia evitando a quebra de encapsulamento
    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    //remove da lista original
    public void remove(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPeloId(aluno);
        if (alunoDevolvido != null) {
            alunos.remove(aluno);
        }
    }
}
