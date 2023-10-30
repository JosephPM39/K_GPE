package org.gpe.domain.salario;

import lombok.Getter;

public class SalarioPorDia implements Salario {
  @Getter private final Double salario;

  public SalarioPorDia(Double salario) {
    this.salario = salario;
  }

  public SalarioPorDia(SalarioMensual salario) {
    this.salario = calcularSalario(salario);
  }

  private Double calcularSalario(SalarioMensual salario) {
    return salario.getSalario() / 30;
  }
}
