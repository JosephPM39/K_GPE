package org.gpe.domain.deduccion_salarial.impuestos.afp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;

@NoArgsConstructor
public abstract class Afp {

  @Getter private final Porcentaje afpPorcentajeEmpleado = new Porcentaje(7.25);
  @Getter private final Porcentaje afpPorcentajePatronal = new Porcentaje(7.75);
  @Getter private final Dinero salarioMaximo = new Dinero(7028.29);
  @Getter private Dinero afpEmpleado;
  @Getter private Dinero afpPatronal;
  @Getter private Dinero salarioLiquido;

  public void calcularDeduccion(Dinero salario) {
    Dinero salarioPreAfp = salario.clone();
    if (salario.getMonto().doubleValue() >= salarioMaximo.getMonto().doubleValue()) {
      salarioPreAfp = salarioMaximo.clone();
    }
    aplicarAfp(salarioPreAfp);
  }

  protected void aplicarAfp(Dinero salario) {
    Dinero afpEmpleado = salario.clone();
    Dinero afpPatronal = salario.clone();
    Dinero salarioLiquido = salario.clone();
    afpPatronal.aplicarPorcentaje(afpPorcentajePatronal);
    afpEmpleado.aplicarPorcentaje(afpPorcentajeEmpleado);
    salarioLiquido.restar(afpEmpleado);
    this.afpEmpleado = afpEmpleado;
    this.afpPatronal = afpPatronal;
    this.salarioLiquido = salarioLiquido;
  }
}
