package org.gpe.domain.deduccion_salarial.tributo_factory;

import org.gpe.domain.deduccion_salarial.tributos.afp.Afp;
import org.gpe.domain.deduccion_salarial.tributos.isss.Isss;
import org.gpe.domain.deduccion_salarial.tributos.renta.Renta;

public interface TributoFactory {
  public Renta crearRenta();

  public Afp crearAfp();

  public Isss crearIsss();
}
