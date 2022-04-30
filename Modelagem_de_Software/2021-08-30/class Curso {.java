class Curso {
  public int codigo;
  public ArrayList<Turma> turmas
}

class Turma {
  public int codigo;
  public Curso curso;
  public String nome;
  public long qntAlunos;
  public ArrayList<Matricula> matriculas
}

class Matricula {
  public int codigo;
  public Aluno alunos;
}


class Aluno {
  public int id;
  public String nome;
  public String telefone;
}