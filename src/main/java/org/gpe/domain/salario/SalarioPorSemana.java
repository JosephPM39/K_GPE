package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.deduccion_salarial.tributo_factory.TributoSemanalFactory;
import org.gpe.domain.utils.Dinero;

public class SalarioPorSemana implements Salario {
  @Getter private final Dinero salario;

  public SalarioPorSemana(Double salario) {
    this.salario = new Dinero(salario);
  }

  public TributoSemanalFactory getSalarioImpuesto() {
    return new TributoSemanalFactory();
  }
}
