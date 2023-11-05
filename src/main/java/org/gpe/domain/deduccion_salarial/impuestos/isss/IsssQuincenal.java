package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class IsssQuincenal extends Isss {

  @Getter private final Dinero salarioMaximoQuincenal = new Dinero(500.00);

  @Override
  protected Dinero getSalarioMaximo() {
    return salarioMaximoQuincenal;
  }
}
