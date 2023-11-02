package org.gpe.domain.deduccion_salarial.impuestos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpDiario extends Afp {

  @Getter private final Double salarioMaximoDiario = super.getSalarioMaximo() / 30.0;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoDiario) {
      salarioPreAfp = salarioMaximoDiario;
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
