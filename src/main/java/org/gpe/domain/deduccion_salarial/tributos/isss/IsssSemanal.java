package org.gpe.domain.deduccion_salarial.tributos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class IsssSemanal extends Isss {

  @Getter private final Dinero salarioMaximoSemanal = new Dinero(233.33);

  @Override
  protected Dinero getSalarioMaximo() {
    return salarioMaximoSemanal;
  }
}
