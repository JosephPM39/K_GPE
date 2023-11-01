package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.gpe.domain.salario.SalarioMensual;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssMensual extends Isss {

  @Getter final private Double salarioMaximoMensual = super.getSalarioMaximo();

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoMensual) {
      salarioPreIsss = salarioMaximoMensual;
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
