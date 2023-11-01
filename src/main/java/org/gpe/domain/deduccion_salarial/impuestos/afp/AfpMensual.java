package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.gpe.domain.salario.SalarioMensual;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfpMensual extends Afp {

  @Getter final private Double salarioMaximoMensual = super.getSalarioMaximo();

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximoMensual) {
      salarioPreAfp = salarioMaximoMensual;
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
