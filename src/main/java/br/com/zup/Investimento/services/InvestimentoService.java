package br.com.zup.Investimento.services;

import br.com.zup.Investimento.Risco;
import br.com.zup.Investimento.dtos.InvestimentoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestimentoService {
  List<InvestimentoDTO> investimentos = new ArrayList<>();

  public InvestimentoDTO inserirInvestimento(InvestimentoDTO investimento) {
    investimentos.add(investimento);
    return investimento;

  }

  public double calcularTaxaCumulativa(int periodoDeAplicacao, Risco risco) {
    double taxasCumulativas = Math.pow((1 + risco.getTaxas()), periodoDeAplicacao);
    return taxasCumulativas;

  }

  public double calcularValorIntegral(double valorInvestido, int periodoDeAplicacao, Risco risco) {
    double valorIntegral = valorInvestido * calcularTaxaCumulativa(periodoDeAplicacao, risco);
    return valorIntegral;
  }

  public double calcularLucro(double valorInvestido, double valorIntegral) {
    double lucro = valorIntegral - valorInvestido;
    return lucro;
  }

}
