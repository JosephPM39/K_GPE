package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoSemanalFactory;

public class SalarioPorSemana implements Salario {
  @Getter private final Double salario;

  public SalarioPorSemana(Double salario) {
    this.salario = salario;
  }

  public SalarioImpuestoSemanalFactory getSalarioImpuesto() {
    return new SalarioImpuestoSemanalFactory();
  }
}
