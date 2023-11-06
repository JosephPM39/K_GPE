package org.gpe.domain.deduccion_salarial.tributos.renta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.gpe.domain.utils.Dinero;

@AllArgsConstructor
@Getter
public class DeduccionRenta {
  private final Tramo tramo;
  private final Dinero retencion;
  private final Dinero salarioLiquido;
}
