package br.com.udemy.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import br.com.udemy.listadetarefas.model.Tarefa;

//data access object, ler e salvar dados no banco
public class TarefaDAO implements ITarefaDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;


    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();

    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());  //chave valor
        //cv.put("status", "E");  e por ai vai

        try {
            //null columnHack permite salvar campos como null, deixe desativado isso ae!
            escreve.insert(DbHelper.TABELA_TAREFAS, null, cv);
            Log.i("INFO SALVAR", "TAREFA SALVA COM SUCESSO!");
        } catch (Exception e) {
            Log.e("INFO SALVAR", "Erro ao salvar tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());  //valores que vamos atualizar

        try{
            //String[] args = { Long.toString(tarefa.getId())};
            String[] args = {tarefa.getId().toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args);   //"id=? AND status = ?"
            Log.i("INFO SALVAR", "TAREFA SALVA COM SUCESSO!");
        }catch(Exception e ){
            Log.e("INFO SALVAR", "Erro ao salvar tarefa" + e.getMessage());
        }
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        try{
            String[] args = {tarefa.getId().toString()};
            escreve.delete(DbHelper.TABELA_TAREFAS,"id=?", args);
            Log.i("INFO DELETAR", "TAREFA EXCLUIDA COM SUCESSO!");
        }catch(Exception e ){
            Log.e("INFO DELETAR", "Erro ao remover tarefa" + e.getMessage());
        }
        return true;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> listaTarefas = new ArrayList<>();
        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";
        Cursor c = le.rawQuery(sql, null);   //filtros em selectionArgs

        while(c.moveToNext()){
            Tarefa tarefa = new Tarefa();

            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefa = c.getString(c.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);
            listaTarefas.add(tarefa);

        }

        return listaTarefas;
    }
}
