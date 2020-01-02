class Tarefa {
  final String descricao;
  final String grauDeUrgencia;

  Tarefa(
    this.descricao,
    this.grauDeUrgencia,
  );

  @override
  String toString() {
    return 'Tarefa{descricao: $descricao, grauDeUrgencia: $grauDeUrgencia}';
  }


}
