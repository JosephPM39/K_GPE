package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;

public class Isss {
  @Getter private final Porcentaje isssPorcentajeEmpleado = new Porcentaje(3);
  @Getter private final Porcentaje isssPorcentajePatronal = new Porcentaje(7.5);
  @Getter private Dinero isssEmpleado;
  @Getter private Dinero isssPatronal;
  @Getter private Dinero salarioLiquido;
  @Getter private Dinero salarioMaximo = new Dinero(1000.00);

  public void calcularDeduccion(Dinero salario) {
    aplicarIsss(salario);
  }

  protected void aplicarIsss(Dinero salario) {
    Dinero isssEmpleado = salario.clone();
    Dinero isssPatronal = salario.clone();
    Dinero salarioLiquido = salario.clone();
    isssEmpleado.aplicarPorcentaje(isssPorcentajeEmpleado);
    isssPatronal.aplicarPorcentaje(isssPorcentajePatronal);
    salarioLiquido.restar(isssEmpleado);
    this.isssEmpleado = isssEmpleado;
    this.isssPatronal = isssPatronal;
    this.salarioLiquido = salarioLiquido;
  }

  protected Dinero aplicarSalarioMaximo(Dinero salario) {
    if (salario.getMonto().doubleValue() >= salarioMaximo.getMonto().doubleValue()) {
      return salarioMaximo.clone();
    }
    return salario.clone();
  }
}
