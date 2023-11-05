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

  public Boolean esEnRango(Dinero decimal) {
    if (decimal.getMonto().doubleValue() >= inicio.getMonto().doubleValue()
        && decimal.getMonto().doubleValue() <= fin.getMonto().doubleValue()) {
      return true;
    }
    return false;
  }

  public Boolean esPreRango(Dinero decimal) {
    if (decimal.getMonto().doubleValue() <= inicio.getMonto().doubleValue()) {
      return true;
    }
    return false;
  }

  public Boolean esPosRango(Dinero decimal) {
    if (decimal.getMonto().doubleValue() >= fin.getMonto().doubleValue()) {
      return true;
    }
    return false;
  }
}
