package org.gpe.domain.deduccion_salarial.impuestos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class AfpQuincenal extends Afp {

  @Getter private final Dinero salarioMaximoQuincenal = super.getSalarioMaximo().clone();

  @Override
  public void calcularDeduccion(Dinero salario) {
    salarioMaximoQuincenal.dividir(2);
    Dinero salarioPreAfp = salario.clone();
    if (salario.getMonto().doubleValue() >= salarioMaximoQuincenal.getMonto().doubleValue()) {
      salarioPreAfp = salarioMaximoQuincenal.clone();
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
