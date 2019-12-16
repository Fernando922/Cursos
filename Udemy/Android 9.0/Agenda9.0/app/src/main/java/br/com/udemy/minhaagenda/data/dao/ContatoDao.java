package br.com.udemy.minhaagenda.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import br.com.udemy.minhaagenda.data.model.Contato;

public class ContatoDao extends SQLiteOpenHelper {

    public ContatoDao(@Nullable Context context) {
        //numero da versão sempre é incremental e a primeira é 1
        super(context, "agenda_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Contato (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "email TEXT, " +
                "telefone TEXT, " +
                "imagem TEXT, " +
                "excluido INT DEFAULT 0)";
        db.execSQL(sql);

    }

    @Override  //caso aconteça alguma mudança nessa tabela
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Contato> buscaContatos(){
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Contato WHERE excluido = 0";
        ArrayList<Contato> lista = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null){  //se retornou uma busca

            while(cursor.moveToNext()){
                Contato contato = new Contato();
                contato.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                contato.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
                contato.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
                contato.setTelefone(cursor.getString(cursor.getColumnIndexOrThrow("telefone")));
                contato.setImagem(cursor.getString(cursor.getColumnIndexOrThrow("imagem")));
                contato.setExcluido(cursor.getInt(cursor.getColumnIndexOrThrow("excluido")));
                lista.add(contato);
            }

            cursor.close();
        }

        return  lista;
    }

    public void insere(Contato contato) {
        ContentValues cv = criaContentValues(contato);

        SQLiteDatabase db = getWritableDatabase();
        long id = db.insert("Contato", null, cv);
        contato.setId((int) id); //cast


    }

    private ContentValues criaContentValues(Contato contato) {
        ContentValues cv = new ContentValues();
        cv.put("nome", contato.getNome());
        cv.put("email", contato.getEmail());
        cv.put("telefone", contato.getTelefone());
        cv.put("imagem", contato.getImagem());
        cv.put("excluido", contato.getExcluido());
        return cv;
    }

    public void edita(Contato contato) {
        ContentValues cv = criaContentValues(contato);

        String sql = "id = " + contato.getId();
        SQLiteDatabase db = getWritableDatabase();
        db.update("Contato", cv, sql, null);

    }

    public void remove(Contato contato) {
        contato.setExcluido(1);
        edita(contato);
    }
}
