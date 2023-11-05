package org.gpe.domain.deduccion_salarial.impuestos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;

@NoArgsConstructor
public abstract class Afp {

  @Getter private final Porcentaje afpPorcentajeEmpleado = new Porcentaje(7.25);
  @Getter private final Porcentaje afpPorcentajePatronal = new Porcentaje(7.75);
  private Dinero afpEmpleado;
  private Dinero afpPatronal;
  private Dinero salarioLiquido;

  public DeduccionAfp calcularDeduccion(Dinero salario) {
    aplicarAfpEmpleado(salario);
    aplicarAfpEmpleador(salario);
    calcularSalarioLiquido(salario);

    return new DeduccionAfp(afpEmpleado, afpPatronal, salarioLiquido);
  }

  protected void calcularSalarioLiquido(Dinero salario) {
    Dinero salarioLiquido = salario.clone();
    salarioLiquido.restar(afpEmpleado);
    this.salarioLiquido = salarioLiquido;
  }

  protected void aplicarAfpEmpleado(Dinero salario) {
    Dinero afpEmpleado = aplicarSalarioMaximo(salario);
    afpEmpleado.aplicarPorcentaje(afpPorcentajeEmpleado);
    this.afpEmpleado = afpEmpleado;
  }

  protected void aplicarAfpEmpleador(Dinero salario) {
    Dinero afpPatronal = salario.clone();
    afpPatronal.aplicarPorcentaje(afpPorcentajePatronal);
    this.afpPatronal = afpPatronal;
  }

  protected Dinero aplicarSalarioMaximo(Dinero monto) {
    if (monto.mayorQue(this.getSalarioMaximo())) {
      return this.getSalarioMaximo().clone();
    }
    return monto.clone();
  }

  protected abstract Dinero getSalarioMaximo();
}
