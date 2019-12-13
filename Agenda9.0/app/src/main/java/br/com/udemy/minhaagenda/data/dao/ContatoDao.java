package br.com.udemy.minhaagenda.data.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
}
