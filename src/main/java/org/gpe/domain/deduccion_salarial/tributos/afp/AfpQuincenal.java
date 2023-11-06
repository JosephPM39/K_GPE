package org.gpe.domain.deduccion_salarial.tributos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class AfpQuincenal extends Afp {

  @Getter private final Dinero salarioMaximoQuincenal = new Dinero(3514.15);

  @Override
  protected Dinero getSalarioMaximo() {
    return this.salarioMaximoQuincenal;
  }
}
