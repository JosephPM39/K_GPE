package org.gpe.domain.deduccion_salarial.tributo_factory;

import org.gpe.domain.deduccion_salarial.tributos.afp.AfpQuincenal;
import org.gpe.domain.deduccion_salarial.tributos.isss.IsssQuincenal;
import org.gpe.domain.deduccion_salarial.tributos.renta.RentaQuincenal;

public class TributoQuincenalFactory implements TributoFactory {
  @Override
  public IsssQuincenal crearIsss() {
    return new IsssQuincenal();
  }

  @Override
  public AfpQuincenal crearAfp() {
    return new AfpQuincenal();
  }

  @Override
  public RentaQuincenal crearRenta() {
    return new RentaQuincenal();
  }
}
