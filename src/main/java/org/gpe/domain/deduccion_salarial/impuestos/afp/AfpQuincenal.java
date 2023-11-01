package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.gpe.domain.salario.SalarioQuincenal;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpQuincenal extends Afp {

  @Getter final private Double salarioMaximoQuincenal = super.getSalarioMaximo() / 2;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoQuincenal) {
      salarioPreAfp = salarioMaximoQuincenal;
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
