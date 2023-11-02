package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.deduccion_salarial.impuestos.afp.Afp;
import org.gpe.domain.deduccion_salarial.impuestos.isss.Isss;
import org.gpe.domain.deduccion_salarial.impuestos.renta.Renta;

public interface SalarioImpuestoFactory {
  public Renta crearRenta();

  public Afp crearAfp();

  public Isss crearIsss();
}
