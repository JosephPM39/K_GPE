package org.gpe.domain.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Getter;

public class Dinero {
  @Getter private BigDecimal monto = new BigDecimal("0.00");

  public Dinero(Dinero dinero) {
    this.monto = dinero.getMonto();
  }

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

  public void dividir(Integer factor) {
    this.monto = this.monto.divide(toBigDecimal(factor), 2, RoundingMode.HALF_UP);
  }

  public void multiplicar(Double factor) {
    this.monto =
        this.monto.multiply(toBigDecimalNotScaled(factor)).setScale(2, RoundingMode.HALF_UP);
  }

  public void multiplicar(Integer factor) {
    this.monto = this.monto.multiply(toBigDecimal(factor)).setScale(2, RoundingMode.HALF_UP);
  }

  public void sumar(Porcentaje porcentaje) {
    BigDecimal aumento =
        this.monto
            .multiply(toBigDecimal(porcentaje.getPorcentaje()))
            .setScale(2, RoundingMode.HALF_UP);
    this.monto = this.monto.add(aumento);
  }

  public void restar(Porcentaje porcentaje) {
    BigDecimal reduccion =
        this.monto
            .multiply(toBigDecimal(porcentaje.getPorcentaje()))
            .setScale(2, RoundingMode.HALF_UP);
    this.monto = this.monto.subtract(reduccion);
  }

  public void aplicarPorcentaje(Porcentaje porcentaje) {
    this.multiplicar(porcentaje.getPorcentaje());
  }

  public boolean mayorQue(Dinero dinero) {
    return this.monto.compareTo(dinero.getMonto()) > 0;
  }

  public boolean menorQue(Dinero dinero) {
    return this.monto.compareTo(dinero.getMonto()) < 0;
  }

  public boolean iguales(Dinero dinero) {
    return this.monto.compareTo(dinero.getMonto()) == 0;
  }

  private BigDecimal toBigDecimal(Double monto) {
    return new BigDecimal(String.valueOf(monto)).setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal toBigDecimalNotScaled(Double monto) {
    return new BigDecimal(String.valueOf(monto));
  }

  private BigDecimal toBigDecimal(Integer monto) {
    return new BigDecimal(String.valueOf(monto)).setScale(2, RoundingMode.HALF_UP);
  }

  @Override
  public String toString() {
    return this.monto.toString();
  }

  public Double getDecimal() {
    return this.monto.doubleValue();
  }
}
