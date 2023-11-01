package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.gpe.domain.salario.SalarioPorHora;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpHora extends Afp {

  @Getter final private Double salarioMaximoHora = super.getSalarioMaximo() / 30 / 8;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoHora) {
      salarioPreAfp = salarioMaximoHora;
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
