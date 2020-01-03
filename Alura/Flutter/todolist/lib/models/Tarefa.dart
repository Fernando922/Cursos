class Tarefa {
  final String descricao;
  final String grauDeUrgencia;
  final int id;

  Tarefa(
      this.id,
    this.descricao,
    this.grauDeUrgencia,
  );

  @override
  String toString() {
    return 'Tarefa{descricao: $descricao, grauDeUrgencia: $grauDeUrgencia, id: $id}';
  }



}
