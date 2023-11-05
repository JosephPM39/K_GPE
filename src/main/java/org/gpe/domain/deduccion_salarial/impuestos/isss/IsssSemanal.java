package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class IsssSemanal extends Isss {

  @Getter private final Dinero salarioMaximoSemanal = super.getSalarioMaximo().clone();

  @Override
  public Dinero aplicarSalarioMaximo(Dinero salario) {
    salarioMaximoSemanal.dividir(30);
    salarioMaximoSemanal.multiplicar(7);
    if (salario.mayorQue(salarioMaximoSemanal)) {
      return salarioMaximoSemanal.clone();
    }
    return salario.clone();
  }
}
