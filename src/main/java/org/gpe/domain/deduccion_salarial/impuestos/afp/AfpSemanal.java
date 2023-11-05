package org.gpe.domain.deduccion_salarial.impuestos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class AfpSemanal extends Afp {

  @Getter private final Dinero salarioMaximoSemanal = super.getSalarioMaximo().clone();

  @Override
  public void calcularDeduccion(Dinero salario) {
    salarioMaximoSemanal.dividir(30);
    salarioMaximoSemanal.multiplicar(7);
    Dinero salarioPreAfp = salario.clone();
    if (salario.getMonto().doubleValue() >= salarioMaximoSemanal.getMonto().doubleValue()) {
      salarioPreAfp = salarioMaximoSemanal.clone();
    }
    super.aplicarAfp(salarioPreAfp);
  }
}
