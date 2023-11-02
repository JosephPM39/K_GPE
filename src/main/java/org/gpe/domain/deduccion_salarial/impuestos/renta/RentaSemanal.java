package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import lombok.Getter;
import org.gpe.domain.utils.RangoDecimal;

public class RentaSemanal extends Renta {
  @Getter private final ArrayList<Tramo> tramosSemanal;

  public RentaSemanal() {
    this.tramosSemanal = convertirTramosASemanal();
  }

  @Override
  public DeduccionRenta calcularDeduccion(Double salario) {
    return this.aplicarTramo(buscarTramo(tramosSemanal, salario), salario);
  }

  private ArrayList<Tramo> convertirTramosASemanal() {
    ArrayList<Tramo> tramos = new ArrayList<>();
    for (Tramo tramo : super.getTramos()) {
      tramos.add(convertirTramoASemanal(tramo));
    }
    return tramos;
  }

  private Tramo convertirTramoASemanal(Tramo tramo) {
    RangoDecimal rangoSalarial =
        new RangoDecimal(
            tramo.getRangoSalarial().getInicio() / 4, tramo.getRangoSalarial().getFin() / 4);
    Double sobreExceso = tramo.getSobreExceso() / 4;
    Double cuotaFija = tramo.getCuotaFija() / 4;
    return new Tramo(
        tramo.getNombre(), tramo.getPorcentajeAplicar(), rangoSalarial, sobreExceso, cuotaFija);
  }
}
