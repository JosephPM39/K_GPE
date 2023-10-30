package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.gpe.domain.salario.SalarioPorHora;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssHora extends Isss {

  @Getter final private SalarioPorHora salarioMaximoHora = new SalarioPorHora(super.getSalarioMaximo());

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoHora.getSalario()) {
      salarioPreIsss = salarioMaximoHora.getSalario();
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
