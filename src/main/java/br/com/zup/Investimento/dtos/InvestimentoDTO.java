package br.com.zup.Investimento.dtos;

import br.com.zup.Investimento.Risco;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class InvestimentoDTO {
  @Email(message = "E-mail inválido!")
  private String email;
  private String nome;
  @CPF(message = "CPF inválido!")
  private String cpf;
  private double valorInvestido;
  @Min(2)
  private int periodoDeAplicacao;
  private Risco risco;

  public InvestimentoDTO() {
  }

  public InvestimentoDTO(String email, String nome, String cpf, double valorInvestido, int periodoDeAplicacao, Risco risco) {
    this.email = email;
    this.nome = nome;
    this.cpf = cpf;
    this.valorInvestido = valorInvestido;
    this.periodoDeAplicacao = periodoDeAplicacao;
    this.risco = risco;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public double getValorInvestido() {
    return valorInvestido;
  }

  public void setValorInvestido(double valorInvestido) {
    this.valorInvestido = valorInvestido;
  }

  public int getPeriodoDeAplicacao() {
    return periodoDeAplicacao;
  }

  public void setPeriodoDeAplicacao(int periodoDeAplicacao) {
    this.periodoDeAplicacao = periodoDeAplicacao;
  }

  public Risco getRisco() {
    return risco;
  }

  public void setRisco(Risco risco) {
    this.risco = risco;
  }
}
