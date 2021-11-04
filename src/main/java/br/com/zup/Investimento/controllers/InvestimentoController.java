package br.com.zup.Investimento.controllers;

import br.com.zup.Investimento.dtos.InvestimentoDTO;
import br.com.zup.Investimento.services.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

  @Autowired
  private InvestimentoService investimentoService;

  @PutMapping
  public InvestimentoDTO inserirInvestimento(@RequestBody @Valid InvestimentoDTO investimento) {
    investimentoService.dadosDeEntrada(investimento);
    return investimento;
  }



}
