import 'package:flutter/material.dart';
import 'package:todolist/components/editor.dart';
import 'package:todolist/database/dao/tarefa_dao.dart';
import 'package:todolist/models/Tarefa.dart';
import 'package:todolist/utils/constants/Constants.dart';

class FormularioTarefa extends StatefulWidget {
  @override
  _FormularioTarefaState createState() => _FormularioTarefaState();
}

class _FormularioTarefaState extends State<FormularioTarefa> {
  final TextEditingController _controladorCampoTarefa = TextEditingController();
  String dropdownValue = Constants.normal;
  final TarefaDao _dao = TarefaDao();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(Constants.tituloAppBarNovaTarefa),
      ),
      body: Column(
        children: <Widget>[
          Editor(
            controlador: _controladorCampoTarefa,
            rotulo: Constants.rotuloCampoTarefa,
            dica: Constants.dicaCampoTarefa,
          ),
          Padding(
            padding: const EdgeInsets.fromLTRB(16.0, 0, 16.0, 16.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Text(
                  Constants.grauDeUrgencia,
                  textAlign: TextAlign.center,
                ),
                DropdownButton<String>(
                  value: dropdownValue,
                  icon: Icon(Icons.arrow_drop_down),
                  iconSize: 24,
                  elevation: 16,
                  style: TextStyle(color: Colors.deepPurple),
                  underline: Container(
                    height: 2,
                    color: Colors.deepPurpleAccent,
                  ),
                  onChanged: (String newValue) {
                    setState(() {
                      dropdownValue = newValue;
                    });
                  },
                  items: <String>[
                    Constants.normal,
                    Constants.medio,
                    Constants.urgente
                  ].map<DropdownMenuItem<String>>(
                    (String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      );
                    },
                  ).toList(),
                ),
              ],
            ),
          ),
          RaisedButton(
            child: Text(Constants.textoBotaoConfirmar),
            onPressed: () {
              _criaTarefa(context);
            },
          )
        ],
      ),
    );
  }

  void _criaTarefa(BuildContext context) {
    final String nomeTarefa = _controladorCampoTarefa.text;
    if (nomeTarefa != null) {
      final tarefaCriada = Tarefa(0, nomeTarefa, dropdownValue);
      _dao.save(tarefaCriada).then((id) => Navigator.pop(context));
    }
  }
}
