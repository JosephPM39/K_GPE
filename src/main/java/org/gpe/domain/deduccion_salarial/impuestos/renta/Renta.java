package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;
import org.gpe.domain.utils.RangoSalarial;

public abstract class Renta {
  @Getter
  private final ArrayList<Tramo> tramos =
      new ArrayList<>(
          List.of(
              new Tramo(
                  "Tramo 1",
                  new Porcentaje(0),
                  new RangoSalarial(new Dinero(0.01), new Dinero(472.00)),
                  new Dinero(0.00),
                  new Dinero(0.00)),
              new Tramo(
                  "Tramo 2",
                  new Porcentaje(10),
                  new RangoSalarial(new Dinero(472.01), new Dinero(895.24)),
                  new Dinero(472.00),
                  new Dinero(17.67)),
              new Tramo(
                  "Tramo 3",
                  new Porcentaje(20),
                  new RangoSalarial(new Dinero(895.25), new Dinero(2038.10)),
                  new Dinero(895.24),
                  new Dinero(60.00)),
              new Tramo(
                  "Tramo 4",
                  new Porcentaje(30),
                  new RangoSalarial(new Dinero(2038.11), new Dinero(1000000000000.0)),
                  new Dinero(2038.10),
                  new Dinero(288.57))));

  public DeduccionRenta calcularDeduccion(Dinero salario) {
    return aplicarTramo(buscarTramo(tramos, salario), salario);
  }

  protected Tramo buscarTramo(List<Tramo> tramos, Dinero salario) {
    for (Tramo tramo : tramos) {
      if (tramo.esEnRangoSalarial(salario)) {
        return tramo;
      }
    }
    return null;
  }

  protected DeduccionRenta aplicarTramo(Tramo tramo, Dinero salario) {
    Dinero retencion = salario.clone();
    retencion.restar(tramo.getSobreExceso());
    retencion.aplicarPorcentaje(tramo.getPorcentajeAplicar());
    retencion.sumar(tramo.getCuotaFija());

    Dinero salarioLiquido = salario.clone();
    salarioLiquido.restar(retencion);
    return new DeduccionRenta(tramo, retencion, salarioLiquido);
  }
}
