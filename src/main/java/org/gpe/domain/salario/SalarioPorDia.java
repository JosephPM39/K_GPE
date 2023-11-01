package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoDiarioFactory;

public class SalarioPorDia implements Salario {
  @Getter private final Double salario;

  public SalarioPorDia(Double salario) {
    this.salario = salario;
  }

  @Override
  public SalarioImpuestoDiarioFactory getSalarioImpuesto() {
    return new SalarioImpuestoDiarioFactory();
  }
}
