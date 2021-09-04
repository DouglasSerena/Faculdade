public class Quadra {
  public int Codigo {get; set;}
  public long QuantidadePessoa {get; set;}
  public List<string> DiasDisponiveis {get; set;}

  public Quadra(int codigo, long quantidadePessoa, List<string> diasDisponiveis) {
    this.Codigo = codigo;
    this.QuantidadePessoa = quantidadePessoa;
    this.DiasDisponiveis = diasDisponiveis;
  }
}