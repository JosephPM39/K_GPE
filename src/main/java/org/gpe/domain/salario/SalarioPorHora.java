package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoHoraFactory;

public class SalarioPorHora implements Salario {
  @Getter private final Double salario;

  public SalarioPorHora(Double salario) {
    this.salario = salario;
  }

  public SalarioImpuestoHoraFactory getSalarioImpuesto() {
    return new SalarioImpuestoHoraFactory();
  }
}
