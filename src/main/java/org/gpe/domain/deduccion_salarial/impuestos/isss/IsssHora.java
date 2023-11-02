package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssHora extends Isss {

  @Getter private final Double salarioMaximoHora = super.getSalarioMaximo() / 30 / 8;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoHora) {
      salarioPreIsss = salarioMaximoHora;
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
