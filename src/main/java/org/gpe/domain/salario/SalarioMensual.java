package org.gpe.domain.salario;

import lombok.Getter;

public class SalarioMensual implements Salario {
  @Getter private final Double salario;

  public SalarioMensual(Double salario) {
    this.salario = salario;
  }

  public SalarioMensual(SalarioMensual salario) {
    this.salario = salario.getSalario();
  }
}
