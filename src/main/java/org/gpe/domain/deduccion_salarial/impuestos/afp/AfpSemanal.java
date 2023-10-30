package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.gpe.domain.salario.SalarioPorSemana;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpSemanal extends Afp {

  @Getter final private SalarioPorSemana salarioMaximoSemanal = new SalarioPorSemana(super.getSalarioMaximo());

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoSemanal.getSalario()) {
      salarioPreAfp = salarioMaximoSemanal.getSalario();
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
