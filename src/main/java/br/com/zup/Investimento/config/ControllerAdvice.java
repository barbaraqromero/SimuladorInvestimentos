package br.com.zup.Investimento.config;

import br.com.zup.Investimento.exceptions.ValorInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(ValorInvalidoException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public MensagemDeErro ValorInvalidoException (ValorInvalidoException valorInvalidoException){
    return new MensagemDeErro(valorInvalidoException.getMessage());

  }
}

