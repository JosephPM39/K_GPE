package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpQuincenal;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssQuincenal;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaQuincenal;

public class SalarioImpuestoQuincenalFactory implements SalarioImpuestoFactory {
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
