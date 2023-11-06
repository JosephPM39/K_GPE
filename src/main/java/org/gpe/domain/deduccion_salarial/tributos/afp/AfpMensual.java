package org.gpe.domain.deduccion_salarial.tributos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class AfpMensual extends Afp {

  @Getter private final Dinero salarioMaximoMensual = new Dinero(7028.29);

  @Override
  protected Dinero getSalarioMaximo() {
    return this.salarioMaximoMensual;
  }
}
