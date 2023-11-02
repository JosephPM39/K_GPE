package org.gpe.domain.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Getter;

public class Dinero {
  @Getter private BigDecimal monto = new BigDecimal("0.00");

  public Dinero(Double monto) {
    this.monto = this.monto.add(toBigDecimal(monto));
  }

  public void sumar(Dinero monto) {
    this.monto = this.monto.add(monto.getMonto());
  }

  public void restar(Dinero monto) {
    this.monto = this.monto.subtract(monto.getMonto());
  }

  public void dividir(Double factor) {
    this.monto = this.monto.divide(toBigDecimal(factor), 2, RoundingMode.HALF_UP);
  }

  public void multiplicar(Double factor) {
    this.monto = this.monto.multiply(toBigDecimal(factor)).setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal toBigDecimal(Double monto) {
    return new BigDecimal(String.valueOf(monto)).setScale(2, RoundingMode.HALF_UP);
  }
}
