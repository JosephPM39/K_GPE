package org.gpe.domain.deduccion_salarial.tributos.afp;

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
    this.salarioLiquido = new Dinero(salario);
    salarioLiquido.restar(afpEmpleado);
  }

  protected void aplicarAfpEmpleado(Dinero salario) {
    this.afpEmpleado = aplicarSalarioMaximo(salario);
    afpEmpleado.aplicarPorcentaje(afpPorcentajeEmpleado);
  }

  protected void aplicarAfpEmpleador(Dinero salario) {
    this.afpPatronal = new Dinero(salario);
    afpPatronal.aplicarPorcentaje(afpPorcentajePatronal);
  }

  protected Dinero aplicarSalarioMaximo(Dinero monto) {
    if (monto.mayorQue(this.getSalarioMaximo())) {
      return new Dinero(this.getSalarioMaximo());
    }
    return new Dinero(monto);
  }

  protected abstract Dinero getSalarioMaximo();
}
