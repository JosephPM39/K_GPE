package org.gpe.domain.deduccion_salarial.tributos.renta;

import java.util.ArrayList;
import java.util.List;
import org.gpe.domain.utils.Dinero;

public abstract class Renta {

  public DeduccionRenta calcularDeduccion(Dinero salario) {
    return aplicarTramo(buscarTramo(this.getTramos(), salario), salario);
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
    Dinero retencion = new Dinero(salario);
    retencion.restar(tramo.getSobreExceso());
    retencion.aplicarPorcentaje(tramo.getPorcentajeAplicar());
    retencion.sumar(tramo.getCuotaFija());

    Dinero salarioLiquido = new Dinero(salario);
    salarioLiquido.restar(retencion);
    return new DeduccionRenta(tramo, retencion, salarioLiquido);
  }

  protected abstract ArrayList<Tramo> getTramos();
}
