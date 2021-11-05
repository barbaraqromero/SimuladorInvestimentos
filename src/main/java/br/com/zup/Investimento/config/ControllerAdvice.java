package br.com.zup.Investimento.config;

import br.com.zup.Investimento.exceptions.ValorInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public List<MensagemDeErro> tratarValidacoes(MethodArgumentNotValidException excecao) {

    List<MensagemDeErro> mensagens = new ArrayList<>();
    for (FieldError fieldError : excecao.getFieldErrors()) {
      mensagens.add(new MensagemDeErro(fieldError.getDefaultMessage()));
    }

    return mensagens;

  }


  @ExceptionHandler(ValorInvalidoException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public MensagemDeErro ValorInvalidoException(ValorInvalidoException valorInvalidoException) {
    return new MensagemDeErro(valorInvalidoException.getMessage());

  }
}

