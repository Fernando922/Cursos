package br.com.udemy.listaparafazer.ui.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import br.com.udemy.listaparafazer.ui.model.Tarefa;


//esta é a classe que extende sqlite
//entao é obrigatório implementar todos os métodos viu

public class TarefaDao extends SQLiteOpenHelper {


    public TarefaDao(@Nullable Context context) {
        super(context, "tarefa_db", null, 1);
    }


    //será executado apenas uma vez, é aqui será criado as tabelas e tal
    //você precisa rodar um comando SQL
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Tarefa (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "descricao TEXT, " +
                "imagem TEXT, " +
                "excluido INT DEFAULT 0)";
        db.execSQL(sql);  //executa o sql inteiro criado
    }


    //no caso de surgir alguma atualização no banco de dados
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Tarefa> buscaTarefas() {
        SQLiteDatabase db = getReadableDatabase();  //apenas para recuperar dados do banco

        String sql = "SELECT * FROM Tarefa WHERE excluido = 0";
        ArrayList<Tarefa> lista = new ArrayList<>();  //estancia da lista onde serão armazenados os dados

        Cursor cursor = db.rawQuery(sql, null);  //a busca é armazenada nesse cursor


        if (cursor != null) {  //se for diferente de null, então uma busca foi retornada

            while (cursor.moveToNext()) {  //vai percorrer cada item do cursor
                Tarefa tarefa = new Tarefa();
                tarefa.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));  //retorna a colula daquele registro que corresponda a um inteiro do nome "id"
                tarefa.setDescricao(cursor.getString(cursor.getColumnIndexOrThrow("descricao")));
                tarefa.setImagem(cursor.getString(cursor.getColumnIndexOrThrow("imagem")));
                tarefa.setExcluido(cursor.getInt(cursor.getColumnIndexOrThrow("excluido")));

            }

        }
        return lista;   //retorna a lista com tudo que foi retornado do banco ou uma lista vazia

    }

    //o métdo de inserir pode ser  um void, afinal não precisa retornar nada mesmo!
    public void insere(Tarefa tarefa){
        ContentValues cv = criaContentValues(tarefa);
        SQLiteDatabase db = getWritableDatabase();  //para escrever no banco
        long id = db.insert("Tarefa", null, cv); //já que ao inserir é retornado o id
        tarefa.setId((int) id); // é efetuado um cast para int pq o valor de id não é do tipo int

    }


    public void edita(Tarefa tarefa){
        ContentValues cv = criaContentValues(tarefa);  //cria o conteudo a ser inserido na tabela do banco

        String sql = "id = " + tarefa.getId();
        SQLiteDatabase db = getWritableDatabase(); //novamente, para escrever no banco
        db.update("Tarefa", cv, sql,  null);
        //A string sql em questão se refere a clausula where, necessário em cada update ou delete!!
    }

    //ContentValues é o conteudo que será inserido em cada insert feito no banco!
    private ContentValues criaContentValues(Tarefa tarefa){
        ContentValues cv = new ContentValues();
        cv.put("descricao", tarefa.getDescricao());
        cv.put("imagem", tarefa.getImagem());
        cv.put("excluido",tarefa.getExcluido());
        return cv;
    }


    //para remover, não vamos de fato remover, apenas deixar com status diferente no banco, caso
    //futuramente, você deseja enviar um contato para a lixeira ao inves de apagar para sempre
    //fazendo assim fica mais fácil de expandir as funcionalidades do sistema futuramente!
    public void remove(Tarefa tarefa){
        tarefa.setExcluido(1);  //sim, pq a lista só é montada com valores diferentes de 1 em excluido
        edita(tarefa);
    }

}
