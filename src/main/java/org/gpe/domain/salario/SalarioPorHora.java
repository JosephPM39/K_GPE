package org.gpe.domain.salario;

import lombok.Getter;

public class SalarioPorHora implements Salario {
  @Getter private final Double salario;

  public SalarioPorHora(Double salario) {
    this.salario = salario;
  }

  public SalarioPorHora(SalarioMensual salario) {
    this.salario = calcularSalario(salario);
  }

  private Double calcularSalario(SalarioMensual salario) {
    return (salario.getSalario() / 30) / 8;
  }
}
