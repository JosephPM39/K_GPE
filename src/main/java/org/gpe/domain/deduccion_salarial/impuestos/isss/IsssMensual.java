package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.gpe.domain.salario.SalarioMensual;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssMensual extends Isss {

  @Getter final private SalarioMensual salarioMaximoMensual = new SalarioMensual(super.getSalarioMaximo());

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoMensual.getSalario()) {
      salarioPreIsss = salarioMaximoMensual.getSalario();
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
