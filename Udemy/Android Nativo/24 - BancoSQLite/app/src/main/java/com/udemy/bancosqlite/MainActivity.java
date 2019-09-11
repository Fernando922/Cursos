package com.udemy.bancosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar tabela se ela nao existir
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3))");
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
            //chave primaria incrementa de forma automatica

            //deleta tabela
            //bancoDados.execSQL("DROP TABLE pessoas");


            //inserir dados
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Carla', 26)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Carlos', 19)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Joaquim', 12)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('José', 29)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Marcela', 31)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Marta', 14)");


            //atualizar dados
           // bancoDados.execSQL("UPDATE pessoas SET idade = 190 WHERE nome LIKE 'Joana'");

            //deletar um dado
            //bancoDados.execSQL("DELETE FROM pessoas WHERE idade= 190");

            //apagar todos os dados
            //bancoDados.execSQL("DELETE FROM pessoas"); ou truncate

            //recuperar pessoas
//            String consulta =
//                    "SELECT nome,idade FROM pessoas " +
//                            "WHERE nome = 'Marcelo' AND idade>20";

//            String consulta =
//                    "SELECT nome,idade FROM pessoas " +
//                            "WHERE idade>=26 OR idade=19";

//            String consulta =
//                    "SELECT nome,idade FROM pessoas" +
//                            " WHERE idade IN(19,21)";  //IN não é ENTRE é quando da um match mesmo

//            String consulta =
//                    "SELECT nome,idade FROM pessoas" +
//                            " WHERE idade BETWEEN(18,21)";

//            String busca = "Mar";
//            String consulta =
//                    "SELECT nome,idade FROM pessoas" +
//                            " WHERE nome LIKE '%" + busca + "%' ";   //like permite uma maior opção de filtros ex: ('mar%' qualquer coisa a direita)
//            //LIKE É UTILIZADO EM BUSCAS!!!!!!! campo de pesquisa, etc....


//            String consulta =
//                    "SELECT nome,idade FROM pessoas" +
//                            " WHERE idade>=18 ORDER BY idade LIMIT 2";   //descrescente ou crescente (DESC)

            String consulta = "SELECT * FROM pessoas ORDER BY id";

            Cursor cursor = bancoDados.rawQuery(consulta, null);


            //indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst(); //pq após o insert ele parou no ultimo dado
            //o cursor aponta para um linha da tabela ( um registro )

            //enquanto tiver registros, faça
            while (cursor != null) {

                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceId);

                Log.i("REGISTRO", id + " " + nome + " idade " + idade);
                cursor.moveToNext(); //faz o cursor andar !
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
