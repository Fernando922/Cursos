import 'package:bytebankpersist/database/dao/contact_dao.dart';
import 'package:bytebankpersist/models/Contact.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ContactForm extends StatefulWidget {
  @override
  _ContactFormState createState() => _ContactFormState();
}

class _ContactFormState extends State<ContactForm> {
  final TextEditingController _controladorNome = TextEditingController();
  final TextEditingController _controladorConta = TextEditingController();
  final ContactDao _dao = ContactDao();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('New Contact')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: <Widget>[
            TextField(
              controller: _controladorNome,
              decoration: InputDecoration(
                  labelText: "Full Name", hintText: "ex: Fernando de Paula"),
              style: TextStyle(fontSize: 16.0),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 8.0),
              child: TextField(
                controller: _controladorConta,
                decoration: InputDecoration(
                    labelText: "Account Number", hintText: "ex: 00000"),
                style: TextStyle(fontSize: 16.0),
                keyboardType: TextInputType.number,
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 8.0),
              child: SizedBox(  //para permitir que o botao seja estendido
                width: double.maxFinite, //ocupa o maximo de largura que a tela permitir
                child: RaisedButton(
                  child: Text("Create"),
                  onPressed: () {
                    //recupera os valores dos controladores
                    final String nome = _controladorNome.text;
                    final int accountNumber = int.tryParse(_controladorConta.text);

                    final Contact newContact = new Contact(0, nome, accountNumber);
                    _dao.save(newContact).then((id) => Navigator.pop(context));
                  },
                ),
              ),
            )
          ],
        ),
      ),
    );
  }
}
