package org.gpe.domain.deduccion_salarial.tributos.isss;

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
    salarioLiquido = new Dinero(salario);
    salarioLiquido.restar(isssEmpleado);
  }

  protected void aplicarIsssEmpleado(Dinero salario) {
    isssEmpleado = aplicarSalarioMaximo(salario);
    isssEmpleado.aplicarPorcentaje(isssPorcentajeEmpleado);
  }

  protected void aplicarIsssEmpleador(Dinero salario) {
    isssPatronal = new Dinero(salario);
    isssPatronal.aplicarPorcentaje(isssPorcentajePatronal);
  }

  protected Dinero aplicarSalarioMaximo(Dinero monto) {
    if (monto.mayorQue(this.getSalarioMaximo())) {
      return new Dinero(this.getSalarioMaximo());
    }
    return new Dinero(monto);
  }

  protected abstract Dinero getSalarioMaximo();
}
