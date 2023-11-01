package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.gpe.domain.salario.SalarioPorDia;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpDiario extends Afp {

  @Getter final private Double salarioMaximoDiario = super.getSalarioMaximo() / 30.0;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoDiario) {
      salarioPreAfp = salarioMaximoDiario;
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
