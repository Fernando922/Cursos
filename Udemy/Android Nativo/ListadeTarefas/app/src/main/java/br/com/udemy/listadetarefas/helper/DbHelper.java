package br.com.udemy.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1; //ao trocar vc força uma atualização no dispositivo dos usuários
    public static String NOME_DB = "db_tarefas";
    public static String TABELA_TAREFAS = "tarefas";

    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //é chamado uma vez, quando o app é instalado
        String sql = "CREATE TABLE IF NOT EXISTS "
                + TABELA_TAREFAS + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL ); ";
//
//     String usuarios = "CREATE TABLE IF NOT EXISTS "
//                + TABELA_TAREFAS + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                " nome TEXT NOT NULL ); ";

        try {
            db.execSQL(sql);
            //db.execSQL(usuarios);
            Log.i("BANCO", "onCreate: Sucesso ao criar a tabela!!");
        } catch (Exception e) {
            Log.i("BANCO", "onCreate: ERRo ao criar a tabela" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int nova) {
        //quando o app está instalado e vc subiu novas versoes
        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ;";

        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("BANCO", "onCreate: Sucesso ao atualizar app!!");
        } catch (Exception e) {
            Log.i("BANCO", "onCreate: ERRo ao atualizar app" + e.getMessage());
        }
    }
}
