package org.gpe.domain.deduccion_salarial.tributo_factory;

import org.gpe.domain.deduccion_salarial.tributos.afp.AfpSemanal;
import org.gpe.domain.deduccion_salarial.tributos.isss.IsssSemanal;
import org.gpe.domain.deduccion_salarial.tributos.renta.RentaSemanal;

public class TributoSemanalFactory implements TributoFactory {
  @Override
  public IsssSemanal crearIsss() {
    return new IsssSemanal();
  }

  @Override
  public AfpSemanal crearAfp() {
    return new AfpSemanal();
  }

  @Override
  public RentaSemanal crearRenta() {
    return new RentaSemanal();
  }
}
