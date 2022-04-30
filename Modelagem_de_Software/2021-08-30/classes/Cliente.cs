public class Cliente {
  public int Codigo {get; set;}
  public string Nome {get; set;}
  public string Whatsapp {get; set;}

  public Cliente(int codigo, string nome, string whatsapp) {
    this.Codigo = codigo;
    this.Nome = nome;
    this.Whatsapp = whatsapp;
  }
}