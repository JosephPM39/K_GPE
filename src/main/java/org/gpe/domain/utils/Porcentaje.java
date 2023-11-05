package org.gpe.domain.utils;

import lombok.Getter;

public class Porcentaje {
  @Getter private final Double valorNatural;
  @Getter private Double valor;
  @Getter private Double complementario;

  public Porcentaje(Double valorNatural) {
    this.valorNatural = valorNatural;
    calcularPorcentajes();
  }

  public Porcentaje(Integer valorNatural) {
    this.valorNatural = Double.parseDouble(String.valueOf(valorNatural));
    calcularPorcentajes();
  }

  private void calcularPorcentajes() {
    valor = valorNatural / 100.00;
    complementario = 1.0 - valor;
  }
}
