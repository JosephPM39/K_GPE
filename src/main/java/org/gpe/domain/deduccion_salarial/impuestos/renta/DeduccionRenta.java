package org.gpe.domain.deduccion_salarial.impuestos.renta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class DeduccionRenta {
  private final Tramo tramo;
  private final Double retencion;
  private final Double salarioLiquido;
}
