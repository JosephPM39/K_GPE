package org.gpe.domain.deduccion_salarial.impuestos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.salario.SalarioMensual;

@NoArgsConstructor
public abstract class Afp {

  @Getter private final Double afpPorcentajeEmpleado = 7.25 / 100.0;
  @Getter private final Double afpPorcentajePatronal = 7.75 / 100.0;
  @Getter private final Double salarioMaximo = 7028.29;
  @Getter private Double afpEmpleado;
  @Getter private Double afpPatronal;
  @Getter private Double salarioLiquido;

  public void calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= salarioMaximo) {
      salarioPreAfp = salarioMaximo;
    }
    aplicarAfp(salarioPreAfp);
  }

  protected void aplicarAfp(Double salario) {
    this.afpEmpleado = salario * afpPorcentajeEmpleado;
    this.afpPatronal = salario * afpPorcentajePatronal;
    this.salarioLiquido = salario - afpEmpleado;
  }
}
