package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.gpe.domain.salario.SalarioPorDia;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpDiario extends Afp {

  @Getter final private SalarioPorDia salarioMaximoDiario = new SalarioPorDia(super.getSalarioMaximo());

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoDiario.getSalario()) {
      salarioPreAfp = salarioMaximoDiario.getSalario();
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
