package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.gpe.domain.salario.SalarioPorSemana;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsssSemanal extends Isss {

  @Getter final private Double salarioMaximoSemanal = (super.getSalarioMaximo() / 30) * 7;

  @Override
  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximoSemanal) {
      salarioPreIsss = salarioMaximoSemanal;
    }
    super.aplicarIsss(salarioPreIsss);
  }
}
