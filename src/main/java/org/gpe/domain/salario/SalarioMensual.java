package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.deduccion_salarial.tributo_factory.TributoMensualFactory;
import org.gpe.domain.utils.Dinero;

public class SalarioMensual implements Salario {
  @Getter private final Dinero salario;

  public SalarioMensual(Double salario) {
    this.salario = new Dinero(salario);
  }

  @Override
  public TributoMensualFactory getTributo() {
    return new TributoMensualFactory();
  }
}
