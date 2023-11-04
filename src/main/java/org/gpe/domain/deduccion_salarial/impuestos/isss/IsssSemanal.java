package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssSemanal extends Isss {

  @Getter private final Double salarioMaximoSemanal = (super.getSalarioMaximo() / 30) * 7;

  @Override
  public Double aplicarSalarioMaximo(Double salario) {
    if (salario >= salarioMaximoSemanal) {
      return salarioMaximoSemanal;
    }
    return salario;
  }
}
