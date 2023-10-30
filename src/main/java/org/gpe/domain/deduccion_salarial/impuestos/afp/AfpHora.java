package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.gpe.domain.salario.SalarioPorHora;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpHora extends Afp {

  @Getter final private SalarioPorHora salarioMaximoHora = new SalarioPorHora(super.getSalarioMaximo());

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoHora.getSalario()) {
      salarioPreAfp = salarioMaximoHora.getSalario();
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
