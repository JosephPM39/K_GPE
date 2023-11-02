package org.gpe.domain.utils;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dinero {
    @Getter
    private BigDecimal monto = new BigDecimal("0.0");

    public Dinero(Double monto) {
        this.monto = this.monto.add(new BigDecimal(String.valueOf(monto)));
    }

    public Dinero(Integer monto) {
        this.monto = this.monto.add(new BigDecimal(String.valueOf(monto)));
    }

    public Dinero(String monto) {
        this.monto = this.monto.add(new BigDecimal(String.valueOf(monto)));
    }

    public void sumar(Dinero monto) {
        this.monto = this.monto.add(monto.getMonto());
    }

    public void restar(Dinero monto) {
        this.monto = this.monto.subtract(monto.getMonto());
    }

    public void dividir(Double factor) {
        this.monto = this.monto.divide(convertFactor(factor), 2, RoundingMode.HALF_UP);
    }

    public void multiplicar(Double factor) {
        this.monto = this.monto.multiply(convertFactor(factor));
    }

    private BigDecimal convertFactor(Double factor) {
        return new BigDecimal(String.valueOf(factor));
    }

}
