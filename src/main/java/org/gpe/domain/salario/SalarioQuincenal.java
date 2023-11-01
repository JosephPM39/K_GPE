package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoQuincenalFactory;

public class SalarioQuincenal implements Salario {
  @Getter private final Double salario;

  public SalarioQuincenal(Double salario) {
    this.salario = salario;
  }

  public SalarioImpuestoQuincenalFactory getSalarioImpuesto() {
    return new SalarioImpuestoQuincenalFactory();
  }
}
