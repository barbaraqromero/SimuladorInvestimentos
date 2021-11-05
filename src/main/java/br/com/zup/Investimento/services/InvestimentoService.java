package br.com.zup.Investimento.services;

import br.com.zup.Investimento.Risco;
import br.com.zup.Investimento.dtos.InvestimentoDTO;
import br.com.zup.Investimento.dtos.RetornoDTO;
import br.com.zup.Investimento.exceptions.ValorInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestimentoService {
  List<InvestimentoDTO> investimentos = new ArrayList<>();

  public void inserirInvestimento(InvestimentoDTO investimento) {
    investimentos.add(investimento);

  }

  public double calcularTaxaCumulativa(InvestimentoDTO investimento) {
    double taxasCumulativas = Math.pow((1 + investimento.getRisco().getTaxas()), investimento.getPeriodoDeAplicacao());
    return taxasCumulativas;

  }

  public double calcularLucro(InvestimentoDTO investimento) {
    double lucro = calcularValorTotal(investimento) - investimento.getValorInvestido();
    return lucro;
  }

  public double calcularValorTotal(InvestimentoDTO investimento) {
    double valorTotal = investimento.getValorInvestido() * calcularTaxaCumulativa(investimento);
    return valorTotal;
  }

  public void validarAltoRisco(InvestimentoDTO investimentoDTO) {
    if (investimentoDTO.getValorInvestido() < 5000 & investimentoDTO.getRisco().equals(Risco.ALTO)) {
      throw new ValorInvalidoException("Esse tipo de investimento permite apenas valores a partir de R$ 5000.");
    }
  }


  public RetornoDTO simularInvestimento(InvestimentoDTO investimento) {
    RetornoDTO retornoDTO = new RetornoDTO();
    retornoDTO.setValorInvestido(investimento.getValorInvestido());
    validarAltoRisco(investimento);
    retornoDTO.setValorLucro(calcularLucro(investimento));
    retornoDTO.setValorTotal(calcularValorTotal(investimento));
    inserirInvestimento(investimento);
    return retornoDTO;
  }


}
