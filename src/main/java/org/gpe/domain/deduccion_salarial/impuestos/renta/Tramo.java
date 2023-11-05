package org.gpe.domain.deduccion_salarial.impuestos.renta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;
import org.gpe.domain.utils.RangoSalarial;

@AllArgsConstructor
@Getter
class Tramo {
  private final String nombre;
  private final Porcentaje porcentajeAplicar;
  private final RangoSalarial rangoSalarial;
  private final Dinero sobreExceso;
  private final Dinero cuotaFija;

  public boolean esEnRangoSalarial(Dinero salario) {
    return rangoSalarial.esEnRango(salario);
  }
}
