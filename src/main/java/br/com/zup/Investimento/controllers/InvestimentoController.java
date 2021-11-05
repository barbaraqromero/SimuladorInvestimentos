package br.com.zup.Investimento.controllers;

import br.com.zup.Investimento.dtos.InvestimentoDTO;
import br.com.zup.Investimento.dtos.RetornoDTO;
import br.com.zup.Investimento.services.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

  @Autowired
  private InvestimentoService investimentoService;

  /*@PutMapping
  public InvestimentoDTO inserirInvestimento(@RequestBody @Valid InvestimentoDTO investimento) {
    investimentoService.inserirInvestimento(investimento);
    return investimento;
  }*/

  @PutMapping
  public RetornoDTO simularInvestimento(@RequestBody @Valid InvestimentoDTO investimento){
    return investimentoService.simularInvestimento(investimento);
  }



}
