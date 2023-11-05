package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;

public abstract class Isss {
  @Getter private final Porcentaje isssPorcentajeEmpleado = new Porcentaje(3);
  @Getter private final Porcentaje isssPorcentajePatronal = new Porcentaje(7.5);
  @Getter private Dinero isssEmpleado;
  @Getter private Dinero isssPatronal;
  @Getter private Dinero salarioLiquido;

  public void calcularDeduccion(Dinero salario) {
    aplicarIsssEmpleado(salario);
    aplicarIsssEmpleador(salario);
    calcularSalarioLiquido(salario);
  }

  protected void calcularSalarioLiquido(Dinero salario) {
    Dinero salarioLiquido = salario.clone();
    salarioLiquido.restar(isssEmpleado);
    this.salarioLiquido = salarioLiquido;
  }

  protected void aplicarIsssEmpleado(Dinero salario) {
    Dinero isssEmpleado = aplicarSalarioMaximo(salario);
    isssEmpleado.aplicarPorcentaje(isssPorcentajeEmpleado);
    this.isssEmpleado = isssEmpleado;
  }

  protected void aplicarIsssEmpleador(Dinero salario) {
    Dinero isssPatronal = salario.clone();
    isssPatronal.aplicarPorcentaje(isssPorcentajePatronal);
    this.isssPatronal = isssPatronal;
  }

  protected Dinero aplicarSalarioMaximo(Dinero monto) {
    if (monto.mayorQue(this.getSalarioMaximo())) {
      return this.getSalarioMaximo().clone();
    }
    return monto.clone();
  }

  protected abstract Dinero getSalarioMaximo();
}
