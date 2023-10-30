package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.gpe.domain.salario.SalarioQuincenal;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpQuincenal extends Afp {

  @Getter final private SalarioQuincenal salarioMaximoQuincenal = new SalarioQuincenal(super.getSalarioMaximo());

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoQuincenal.getSalario()) {
      salarioPreAfp = salarioMaximoQuincenal.getSalario();
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
