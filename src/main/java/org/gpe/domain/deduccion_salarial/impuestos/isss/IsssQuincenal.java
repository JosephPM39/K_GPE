package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class IsssQuincenal extends Isss {

  @Getter private final Dinero salarioMaximoQuincenal = super.getSalarioMaximo().clone();

  @Override
  public Dinero aplicarSalarioMaximo(Dinero salario) {
    salarioMaximoQuincenal.dividir(2);
    if (salario.mayorQue(salarioMaximoQuincenal)) {
      return salarioMaximoQuincenal.clone();
    }
    return salario.clone();
  }
}
