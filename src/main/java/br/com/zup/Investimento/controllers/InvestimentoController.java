package br.com.zup.Investimento.controllers;

import br.com.zup.Investimento.services.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

  @Autowired
  private InvestimentoService investimentoService;

}
