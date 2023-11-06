package org.gpe.domain.deduccion_salarial.tributos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class IsssMensual extends Isss {

  @Getter private final Dinero salarioMaximoMensual = new Dinero(1000.00);

  @Override
  protected Dinero getSalarioMaximo() {
    return salarioMaximoMensual;
  }
}
