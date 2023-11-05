package org.gpe.domain.deduccion_salarial.impuestos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class AfpMensual extends Afp {

  @Getter private final Dinero salarioMaximoMensual = super.getSalarioMaximo();

  @Override
  public void calcularDeduccion(Dinero salario) {
    Dinero salarioPreAfp = salario.clone();
    if (salario.getMonto().doubleValue() >= salarioMaximoMensual.getMonto().doubleValue()) {
      salarioPreAfp = salarioMaximoMensual.clone();
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
