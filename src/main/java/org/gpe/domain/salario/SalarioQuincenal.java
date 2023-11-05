package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoQuincenalFactory;
import org.gpe.domain.utils.Dinero;

public class SalarioQuincenal implements Salario {
  @Getter private final Dinero salario;

  public SalarioQuincenal(Double salario) {
    this.salario = new Dinero(salario);
  }

  public SalarioImpuestoQuincenalFactory getSalarioImpuesto() {
    return new SalarioImpuestoQuincenalFactory();
  }
}
