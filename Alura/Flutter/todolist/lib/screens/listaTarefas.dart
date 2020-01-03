import 'package:flutter/material.dart';
import 'package:todolist/database/dao/tarefa_dao.dart';
import 'package:todolist/models/Tarefa.dart';
import 'package:todolist/utils/constants/Constants.dart';

import 'FormularioTarefa.dart';

//todos os statefulwidget devem retornar a classe de estado
class ListaTarefas extends StatefulWidget {
  final List<Tarefa> _tarefas = List();

  @override
  State<StatefulWidget> createState() {
    return ListaTarefasState();
  }
}

//classe que representa o estado da classe de lista de tarefas
class ListaTarefasState extends State<ListaTarefas> {

  final TarefaDao _dao = TarefaDao();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(Constants.tituloAppBarLista),
      ),
      body: FutureBuilder<List<Tarefa>>(
        initialData: List(),
        future:
        itemCount: widget._tarefas.length,
        itemBuilder: (context, indice) {
          final tarefa = widget._tarefas[indice];
          return _ItemTarefa(tarefa);
        },
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          Navigator.push(context, MaterialPageRoute(builder: (context) {
            return FormularioTarefa();
          })).then((tarefaRecebida) => _atualiza(tarefaRecebida));
        },
      ),
    );
  }

  void _atualiza(Tarefa tarefaRecebida) {
    if (tarefaRecebida != null) {
      setState(() {
        widget._tarefas.add(tarefaRecebida);
      });
    }
  }
}

class _ItemTarefa extends StatelessWidget {
  final Tarefa _tarefa;

  _ItemTarefa(this._tarefa);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        leading: Icon(Icons.check_circle),
        title: Text(_tarefa.descricao.toString()),
        subtitle: Text(_tarefa.grauDeUrgencia.toString()),
        onLongPress: () {
          showDialog<void>(
            context: context,
            barrierDismissible: false, // user must tap button!
            builder: (BuildContext context) {
              return AlertDialog(
                title: Text('Deseja excluir a tarefa selecionada?'),
                content: SingleChildScrollView(
                  child: ListBody(
                    children: <Widget>[
                      Text('Esta ação não pode ser desfeita!'),
                    ],
                  ),
                ),
                actions: <Widget>[
                  FlatButton(
                    child: Text('Cancelar'),
                    onPressed: () {
                      Navigator.of(context).pop();
                    },
                  ),
                  FlatButton(
                    child: Text('Confirmar'),
                    onPressed: (){
                      Navigator.of(context).pop();
                    },
                  )
                ],
              );
            },
          );
        },
      ),
    );
  }
}
