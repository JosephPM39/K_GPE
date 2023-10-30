package org.gpe.domain.salario;

import lombok.Getter;

public class SalarioQuincenal implements Salario {
  @Getter private final Double salario;

  public SalarioQuincenal(Double salario) {
    this.salario = salario;
  }

  public SalarioQuincenal(SalarioMensual salario) {
    this.salario = calcularSalario(salario);
  }

  private Double calcularSalario(SalarioMensual salario) {
    return salario.getSalario() / 2;
  }
}
