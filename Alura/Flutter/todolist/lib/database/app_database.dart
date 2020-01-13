import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';
import 'package:todolist/database/dao/tarefa_dao.dart';

Future<Database> getDatabase() async{
 final String path = join(await getDatabasesPath(), 'todo_db.db');
 //retorna a referencia do banco
 return openDatabase(
   path,
   //é chamado apenas na criação do banco
   onCreate: (db, version){
     //responsável por criar as tabelas desejadas, executando script sql
     db.execute(TarefaDao.tableSql);
   },
   version: 1
 );
}
