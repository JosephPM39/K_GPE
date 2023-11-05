package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;

@NoArgsConstructor
public class IsssMensual extends Isss {

  @Getter private final Dinero salarioMaximoMensual = super.getSalarioMaximo().clone();

  @Override
  protected Dinero aplicarSalarioMaximo(Dinero salario) {
    if (salario.mayorQue(salarioMaximoMensual)) {
      return salarioMaximoMensual.clone();
    }
    return salario.clone();
  }
}
