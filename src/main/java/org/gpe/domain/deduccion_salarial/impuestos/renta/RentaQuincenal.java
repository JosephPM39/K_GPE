package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import lombok.Getter;
import org.gpe.domain.utils.RangoDecimal;

public class RentaQuincenal extends Renta {
  @Getter private final ArrayList<Tramo> tramosQuincenal;

  public RentaQuincenal() {
    this.tramosQuincenal = convertirTramosAQuincenal();
  }

  @Override
  public DeduccionRenta calcularDeduccion(Double salario) {
    return this.aplicarTramo(buscarTramo(tramosQuincenal, salario), salario);
  }

  private ArrayList<Tramo> convertirTramosAQuincenal() {
    ArrayList<Tramo> tramos = new ArrayList<>();
    for (Tramo tramo : super.getTramos()) {
      tramos.add(convertirTramoAQuincenal(tramo));
    }
    return tramos;
  }

  private Tramo convertirTramoAQuincenal(Tramo tramo) {
    RangoDecimal rangoSalarial =
        new RangoDecimal(
            tramo.getRangoSalarial().getInicio() / 2, tramo.getRangoSalarial().getFin() / 2);
    Double sobreExceso = tramo.getSobreExceso() / 2;
    Double cuotaFija = tramo.getCuotaFija() / 2;
    return new Tramo(
        tramo.getNombre(), tramo.getPorcentajeAplicar(), rangoSalarial, sobreExceso, cuotaFija);
  }
}
