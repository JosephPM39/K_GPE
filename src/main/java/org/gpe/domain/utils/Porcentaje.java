package org.gpe.domain.utils;

import lombok.Getter;

public class Porcentaje {
    @Getter private Double valor;
    @Getter private Double porcentaje;
    @Getter private Double porcentajeComplementario;

    public Porcentaje(Double valor) {
        this.valor = valor;
        calcularPorcentajes();
    }

    public Porcentaje(Integer valor) {
        this.valor = Double.parseDouble(String.valueOf(valor));
        calcularPorcentajes();
    }

    private void calcularPorcentajes() {
       porcentaje = valor / 100.00;
       porcentajeComplementario = 1.0 - porcentaje;
    }

}
