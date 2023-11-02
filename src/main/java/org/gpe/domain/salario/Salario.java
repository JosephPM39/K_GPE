package org.gpe.domain.salario;

import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoFactory;

public interface Salario {
  public Double getSalario();

  public SalarioImpuestoFactory getSalarioImpuesto();
}
