import 'package:sqflite/sqflite.dart';
import 'package:todolist/database/app_database.dart';
import 'package:todolist/models/Tarefa.dart';

class TarefaDao {
  static const String tableSql = 'CREATE TABLE tarefas ('
      'id INTEGER PRIMARY KEY, '
      'descricao TEXT, '
      'grauDeUrgencia TEXT)';

  Future<int> save(Tarefa tarefa) async {
    //instancia o banco
    final Database db = await getDatabase();
    //cria um MAP com a tarefa recebida e insere no banco
    Map<String, dynamic> tarefaMap = _toMap(tarefa);
    return db.insert('tarefas', tarefaMap);
  }

  Map<String, dynamic> _toMap(Tarefa tarefa) {
    final Map<String, dynamic> tarefaMap = Map();
    tarefaMap['descricao'] = tarefa.descricao;
    tarefaMap['grauDeUrgencia'] = tarefa.grauDeUrgencia;
    return tarefaMap;
  }

  List<Tarefa> _toList(List<Map<String, dynamic>> result) {
    final List<Tarefa> tarefas = List();
    for (Map<String, dynamic> row in result) {
      final Tarefa tarefa =
      Tarefa(row['id'], row['descricao'], row['grauDeUrgencia']);
      tarefas.add(tarefa);
    }
    return tarefas;
  }

  Future<List<Tarefa>> findAll() async {
    final Database db = await getDatabase();
    final List<Map<String, dynamic>> result = await db.query('tarefas');
    List<Tarefa> tarefas = _toList(result);
    return tarefas;
  }


}
