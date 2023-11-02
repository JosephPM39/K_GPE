package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssMensual extends Isss {

  @Getter private final Double salarioMaximoMensual = super.getSalarioMaximo();

  @Override
  protected Double aplicarSalarioMaximo(Double salario) {
    if (salario >= salarioMaximoMensual) {
      return salarioMaximoMensual;
    }
    return salario;
  }
}
