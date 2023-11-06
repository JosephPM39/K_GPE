package org.gpe.domain.deduccion_salarial.tributos.afp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.gpe.domain.utils.Dinero;

@AllArgsConstructor
public class DeduccionAfp {
  @Getter private Dinero empleado;
  @Getter private Dinero patronal;
  @Getter private Dinero salarioLiquido;
}
