package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssQuincenal extends Isss {

  @Getter private final Double salarioMaximoQuincenal = super.getSalarioMaximo() / 2;

  @Override
  public Double aplicarSalarioMaximo(Double salario) {
    if (salario >= salarioMaximoQuincenal) {
      return salarioMaximoQuincenal;
    }
    return salario;
  }
}
