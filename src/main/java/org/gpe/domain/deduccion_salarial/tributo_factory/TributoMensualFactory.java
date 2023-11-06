package org.gpe.domain.deduccion_salarial.tributo_factory;

import org.gpe.domain.deduccion_salarial.tributos.afp.AfpMensual;
import org.gpe.domain.deduccion_salarial.tributos.isss.IsssMensual;
import org.gpe.domain.deduccion_salarial.tributos.renta.RentaMensual;

public class TributoMensualFactory implements TributoFactory {
  @Override
  public IsssMensual crearIsss() {
    return new IsssMensual();
  }

  @Override
  public AfpMensual crearAfp() {
    return new AfpMensual();
  }

  @Override
  public RentaMensual crearRenta() {
    return new RentaMensual();
  }
}
