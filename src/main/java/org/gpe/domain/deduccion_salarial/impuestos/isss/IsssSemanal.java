package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssSemanal extends Isss {

  @Getter private final Double salarioMaximoSemanal = (super.getSalarioMaximo() / 30) * 7;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoSemanal) {
      salarioPreIsss = salarioMaximoSemanal;
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
