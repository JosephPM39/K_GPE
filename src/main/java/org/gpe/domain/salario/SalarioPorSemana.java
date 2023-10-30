package org.gpe.domain.salario;

import lombok.Getter;

public class SalarioPorSemana implements Salario {
  @Getter private final Double salario;

  public SalarioPorSemana(Double salario) {
    this.salario = salario;
  }

  public SalarioPorSemana(SalarioMensual salario) {
    this.salario = calcularSalario(salario);
  }

  private Double calcularSalario(SalarioMensual salario) {
    return (salario.getSalario() / 30) * 7;
  }
}
