package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.gpe.domain.salario.SalarioMensual;

import lombok.Getter;

public class Isss {
  @Getter private final Double isssPorcentajeEmpleado = 3.0 / 100.0;
  @Getter private final Double isssPorcentajePatronal = 7.5 / 100.0;
  @Getter private Double isssEmpleado;
  @Getter private Double isssPatronal;
  @Getter private Double salarioLiquido;
  @Getter private SalarioMensual salarioMaximo = new SalarioMensual(1000.0);

  public void calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= salarioMaximo.getSalario()) {
      salarioPreIsss = salarioMaximo.getSalario();
    }
    aplicarIsss(salarioPreIsss);
  }

  protected void aplicarIsss(Double salario) {
    this.isssEmpleado = salario * isssPorcentajeEmpleado;
    this.isssPatronal = salario * isssPorcentajePatronal;
    this.salarioLiquido = salario - isssEmpleado;
  }
}
