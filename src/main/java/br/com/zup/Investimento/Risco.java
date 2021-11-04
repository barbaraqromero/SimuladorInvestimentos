package br.com.zup.Investimento;

public enum Risco {
  BAIXO(0.05),
  MÉDIO(0.15),
  ALTO(0.25);

  private double taxa;

  Risco(double taxas) {
    this.taxa = taxas;
  }

  public double getTaxas() {
    return taxa;
  }
}
