package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.gpe.domain.salario.SalarioPorSemana;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssSemanal extends Isss {

  @Getter final private SalarioPorSemana salarioMaximoSemanal = new SalarioPorSemana(super.getSalarioMaximo());

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoSemanal.getSalario()) {
      salarioPreIsss = salarioMaximoSemanal.getSalario();
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
