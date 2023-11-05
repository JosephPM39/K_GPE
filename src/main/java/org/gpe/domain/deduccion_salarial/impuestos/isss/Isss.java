package org.gpe.domain.deduccion_salarial.impuestos.isss;

import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;

public abstract class Isss {
  @Getter private final Porcentaje isssPorcentajeEmpleado = new Porcentaje(3);
  @Getter private final Porcentaje isssPorcentajePatronal = new Porcentaje(7.5);
  private Dinero isssEmpleado;
  private Dinero isssPatronal;
  private Dinero salarioLiquido;

  public DeduccionIsss calcularDeduccion(Dinero salario) {
    aplicarIsssEmpleado(salario);
    aplicarIsssEmpleador(salario);
    calcularSalarioLiquido(salario);

    return new DeduccionIsss(isssEmpleado, isssPatronal, salarioLiquido);
  }

  protected void calcularSalarioLiquido(Dinero salario) {
    Dinero salarioLiquido = new Dinero(salario);
    salarioLiquido.restar(isssEmpleado);
    this.salarioLiquido = salarioLiquido;
  }

  protected void aplicarIsssEmpleado(Dinero salario) {
    Dinero isssEmpleado = aplicarSalarioMaximo(salario);
    isssEmpleado.aplicarPorcentaje(isssPorcentajeEmpleado);
    this.isssEmpleado = isssEmpleado;
  }

  protected void aplicarIsssEmpleador(Dinero salario) {
    Dinero isssPatronal = new Dinero(salario);
    isssPatronal.aplicarPorcentaje(isssPorcentajePatronal);
    this.isssPatronal = isssPatronal;
  }

  protected Dinero aplicarSalarioMaximo(Dinero monto) {
    if (monto.mayorQue(this.getSalarioMaximo())) {
      return new Dinero(this.getSalarioMaximo());
    }
    return new Dinero(monto);
  }

  protected abstract Dinero getSalarioMaximo();
}
