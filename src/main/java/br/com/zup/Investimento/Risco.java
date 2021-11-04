package br.com.zup.Investimento;

public enum Risco {
  BAIXO(0.005),
  MÉDIO(0.015),
  ALTO(0.025);

  private double taxa;

  Risco(double taxas) {
    this.taxa = taxas;
  }

  public double getTaxas() {
    return taxa;
  }
}
