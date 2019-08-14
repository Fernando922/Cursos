package br.com.alura.agenda.root;

import android.app.Application;

import br.com.alura.agenda.root.DAO.AlunoDAO;
import br.com.alura.agenda.root.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeExemplo();

    }

    private void criaAlunosDeExemplo() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Fernando", "37217996", "dipaula018@gmail.com"));
        dao.salva(new Aluno("Rodrigo", "993456969", "rodj@gmail.com"));
        dao.salva(new Aluno("Maria", "994156565", "msanta12@gmail.com"));
        dao.salva(new Aluno("João", "998586521", "loks12@gmail.com"));
        dao.salva(new Aluno("Marta", "37218585", "irmadovo43@gmail.com"));
    }

}
