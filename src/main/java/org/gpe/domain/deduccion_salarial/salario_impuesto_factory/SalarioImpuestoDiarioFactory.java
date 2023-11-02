package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpDiario;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssDiario;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaDiaria;

public class SalarioImpuestoDiarioFactory implements SalarioImpuestoFactory {

  @Override
  public IsssDiario crearIsss() {
    return new IsssDiario();
  }

  @Override
  public AfpDiario crearAfp() {
    return new AfpDiario();
  }

  @Override
  public RentaDiaria crearRenta() {
    return new RentaDiaria();
  }
}
