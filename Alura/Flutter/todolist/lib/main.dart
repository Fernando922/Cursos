import 'package:flutter/material.dart';
import 'package:todolist/screens/listaTarefas.dart';

void main()  =>   runApp(MyApp());


class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primaryColor: Colors.lightBlue[900],
        accentColor: Colors.deepPurple[700],
        buttonTheme: ButtonThemeData(
          buttonColor: Colors.deepPurple[700],
          textTheme: ButtonTextTheme.primary,
        ),
      ),
      home: ListaTarefas(),
      debugShowCheckedModeBanner: false,
    );
  }
}
