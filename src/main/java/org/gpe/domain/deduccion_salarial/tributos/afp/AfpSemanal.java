package org.gpe.domain.deduccion_salarial.tributos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class AfpSemanal extends Afp {

  @Getter private final Dinero salarioMaximoSemanal = new Dinero(1639.93);

  @Override
  protected Dinero getSalarioMaximo() {
    return salarioMaximoSemanal;
  }
}
