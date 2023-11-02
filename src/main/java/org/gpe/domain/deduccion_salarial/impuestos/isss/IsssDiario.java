package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssDiario extends Isss {

  @Getter private final Double salarioMaximoDiario = super.getSalarioMaximo() / 30;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoDiario) {
      salarioPreIsss = salarioMaximoDiario;
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
