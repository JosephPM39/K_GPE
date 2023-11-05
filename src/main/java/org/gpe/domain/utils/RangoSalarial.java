package org.gpe.domain.utils;

import lombok.Getter;
import lombok.Setter;

public class RangoSalarial {

  @Getter @Setter private Dinero inicio;
  @Getter @Setter private Dinero fin;

  public RangoSalarial(Dinero inicio, Dinero fin) {
    this.inicio = inicio;
    this.fin = fin;
  }

  public boolean esEnRango(Dinero decimal) {
    return !esPreRango(decimal) && !esPosRango(decimal);
  }

  public boolean esPreRango(Dinero decimal) {
    return decimal.getMonto().doubleValue() < inicio.getMonto().doubleValue();
  }

  public boolean esPosRango(Dinero decimal) {
    return decimal.getMonto().doubleValue() > fin.getMonto().doubleValue();
  }
}
