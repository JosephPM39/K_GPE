package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import org.gpe.domain.utils.RangoDecimal;

public abstract class Renta {
  @Getter private final ArrayList<Tramo> tramos =
      new ArrayList<>(
          List.of(
              new Tramo("Tramo 1", 0.00, new RangoDecimal(0.01, 472.00), 0.00, 0.00),
              new Tramo("Tramo 2", 10.00/100, new RangoDecimal(472.01, 895.24), 472.00, 17.67),
              new Tramo("Tramo 3", 20.00/100, new RangoDecimal(895.25, 2038.10), 895.24, 60.00),
              new Tramo("Tramo 4", 30.00/100, new RangoDecimal(2038.11, Double.POSITIVE_INFINITY), 2038.10, 288.57)
          )
      );

  public DeduccionRenta calcularDeduccion(Double salario) {
    return aplicarTramo(buscarTramo(tramos, salario), salario);
  }

  protected Tramo buscarTramo(List<Tramo> tramos, Double salario) {
    for (Tramo tramo : tramos) {
      if (tramo.esEnRangoSalarial(salario)) {
        return tramo;
      }
    }
    return null;
  }

  protected DeduccionRenta aplicarTramo(Tramo tramo, Double salario) {
    Double retencion =
        ((salario - tramo.getSobreExceso()) * tramo.getPorcentajeAplicar()) + tramo.getCuotaFija();
    Double salarioLiquido = salario - retencion;
    return new DeduccionRenta(tramo, retencion, salarioLiquido);
  }
}
