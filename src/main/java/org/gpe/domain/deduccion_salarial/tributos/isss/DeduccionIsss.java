package org.gpe.domain.deduccion_salarial.tributos.isss;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.gpe.domain.utils.Dinero;

@AllArgsConstructor
public class DeduccionIsss {
  @Getter private Dinero empleado;
  @Getter private Dinero patronal;
  @Getter private Dinero salarioLiquido;
}
