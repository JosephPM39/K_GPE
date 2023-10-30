package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.gpe.domain.salario.SalarioPorDia;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssDiario extends Isss {

  @Getter final private SalarioPorDia salarioMaximoDiario = new SalarioPorDia(super.getSalarioMaximo());

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoDiario.getSalario()) {
      salarioPreIsss = salarioMaximoDiario.getSalario();
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
