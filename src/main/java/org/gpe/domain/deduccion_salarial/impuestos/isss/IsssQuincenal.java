package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.gpe.domain.salario.SalarioQuincenal;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssQuincenal extends Isss {

  @Getter final private SalarioQuincenal salarioMaximoQuincenal = new SalarioQuincenal(super.getSalarioMaximo());

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoQuincenal.getSalario()) {
      salarioPreIsss = salarioMaximoQuincenal.getSalario();
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
