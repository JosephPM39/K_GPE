package org.gpe.domain.deduccion_salarial.impuestos.renta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.gpe.domain.utils.RangoDecimal;

@AllArgsConstructor
@Getter
class Tramo {
  private final String nombre;
  private final Double porcentajeAplicar;
  private final RangoDecimal rangoSalarial;
  private final Double sobreExceso;
  private final Double cuotaFija;

  public Boolean esEnRangoSalarial(Double salario) {
    return rangoSalarial.esEnRango(salario);
  }
}
