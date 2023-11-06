package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.deduccion_salarial.tributo_factory.TributoQuincenalFactory;
import org.gpe.domain.utils.Dinero;

public class SalarioQuincenal implements Salario {
  @Getter private final Dinero salario;

  public SalarioQuincenal(Double salario) {
    this.salario = new Dinero(salario);
  }

  public TributoQuincenalFactory getSalarioImpuesto() {
    return new TributoQuincenalFactory();
  }
}
