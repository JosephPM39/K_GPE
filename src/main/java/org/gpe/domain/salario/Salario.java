package org.gpe.domain.salario;

import org.gpe.domain.deduccion_salarial.tributo_factory.TributoFactory;
import org.gpe.domain.utils.Dinero;

public interface Salario {
  public Dinero getSalario();

  public TributoFactory getTributo();
}
