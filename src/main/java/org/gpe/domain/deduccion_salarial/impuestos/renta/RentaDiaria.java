package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import lombok.Getter;
import org.gpe.domain.utils.RangoDecimal;

public class RentaDiaria extends Renta {
  @Getter private final ArrayList<Tramo> tramosDiarios;

  public RentaDiaria() {
    this.tramosDiarios = convertirTramosADiarios();
  }

  @Override
  public DeduccionRenta calcularDeduccion(Double salario) {
    return this.aplicarTramo(buscarTramo(tramosDiarios, salario), salario);
  }

  private ArrayList<Tramo> convertirTramosADiarios() {
    ArrayList<Tramo> tramos = new ArrayList<>();
    for (Tramo tramo : super.getTramos()) {
      tramos.add(convertirTramoADiario(tramo));
    }
    return tramos;
  }

  private Tramo convertirTramoADiario(Tramo tramo) {
    RangoDecimal rangoSalarial =
        new RangoDecimal(
            tramo.getRangoSalarial().getInicio() / 30, tramo.getRangoSalarial().getFin() / 30);
    Double sobreExceso = tramo.getSobreExceso() / 30;
    Double cuotaFija = tramo.getCuotaFija() / 30;
    return new Tramo(
        tramo.getNombre(), tramo.getPorcentajeAplicar(), rangoSalarial, sobreExceso, cuotaFija);
  }
}
