package org.gpe.domain.deduccion_salarial.impuestos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpSemanal extends Afp {

  @Getter private final Double salarioMaximoSemanal = (super.getSalarioMaximo() / 30) * 7;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoSemanal) {
      salarioPreAfp = salarioMaximoSemanal;
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
