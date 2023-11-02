package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpHora;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssHora;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaHora;

public class SalarioImpuestoHoraFactory implements SalarioImpuestoFactory {
  @Override
  public IsssHora crearIsss() {
    return new IsssHora();
  }

  @Override
  public AfpHora crearAfp() {
    return new AfpHora();
  }

  @Override
  public RentaHora crearRenta() {
    return new RentaHora();
  }
}
