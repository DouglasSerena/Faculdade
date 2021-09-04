public class Locacao {
  public int Codigo {get; set;}
  public DateTime DataHora {get; set;}
  public Cliente Cliente {get; set;}
  public Quadra Quadra {get; set;}

  public Locacao(int codigo, DateTime dataHora, Cliente cliente, Quadra quadra) {
    this.Codigo = codigo;
    this.DataHora = dataHora;
    this.Cliente = cliente;
    this.Quadra = quadra;
  }

  /** Retornar o código da quadra que esta sendo utilizado na instância */
  public string RetornaQuadraUtilizada() {
    return this.Quadra.Codigo;
  }

  /** Retornar o nome do cliente atual */
  public string RetornaNomeCliente() {
    return this.Cliente.Nome;
  }
}