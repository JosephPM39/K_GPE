package org.gpe.domain.salario;

import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoFactory;
import org.gpe.domain.utils.Dinero;

public interface Salario {
  public Dinero getSalario();

  public SalarioImpuestoFactory getSalarioImpuesto();
}
