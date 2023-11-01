package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.gpe.domain.salario.SalarioQuincenal;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssQuincenal extends Isss {

  @Getter final private Double salarioMaximoQuincenal = super.getSalarioMaximo() / 2;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoQuincenal) {
      salarioPreIsss = salarioMaximoQuincenal;
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
