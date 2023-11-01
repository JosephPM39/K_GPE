package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoFactory;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoMensualFactory;

public class SalarioMensual implements Salario {
  @Getter private final Double salario;

  public SalarioMensual(Double salario) {
    this.salario = salario;
  }

  @Override
  public SalarioImpuestoMensualFactory getSalarioImpuesto() {
    return new SalarioImpuestoMensualFactory();
  }

}
