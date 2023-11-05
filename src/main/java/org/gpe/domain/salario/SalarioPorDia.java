package org.gpe.domain.salario;

import lombok.Getter;

public class SalarioPorDia implements SalarioEspecial {
  @Getter private final Double tarifa;
  @Getter private final Integer unidades;
  @Getter private final Double salario;

  public SalarioPorDia(Double tarifa, Integer unidades) {
    this.tarifa = tarifa;
    this.unidades = unidades;
    this.salario = tarifa * unidades;
  }
}
