package org.gpe.domain.utils;

import lombok.Getter;
import lombok.Setter;

public class RangoDecimal {

  @Getter @Setter private Double inicio;
  @Getter @Setter private Double fin;

  public RangoDecimal(Double inicio, Double fin) {
    this.inicio = inicio;
    this.fin = fin;
  }

  public Boolean esEnRango(Double decimal) {
    if (decimal >= inicio && decimal <= fin) {
      return true;
    }
    return false;
  }

  public Boolean esPreRango(Double decimal) {
    if (decimal <= inicio) {
      return true;
    }
    return false;
  }

  public Boolean esPosRango(Double decimal) {
    if (decimal >= fin) {
      return true;
    }
    return false;
  }
}
