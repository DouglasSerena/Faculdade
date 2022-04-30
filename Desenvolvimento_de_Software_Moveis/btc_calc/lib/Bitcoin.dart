class Bitcoin {
  late double _cotacao;

  double get cotacao => _cotacao;

  set cotacao(double cotacao) {
    _cotacao = cotacao;
  }

  late double _valor;

  double get valor => _valor;

  set valor(double valor) {
    _valor = valor;
  }

  String calcular() {
    double btc = valor / cotacao;
    return "Valor em Bitcoins = ${btc.toStringAsPrecision(8)}\n";
  }
}
