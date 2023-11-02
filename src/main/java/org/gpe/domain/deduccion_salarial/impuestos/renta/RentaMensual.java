package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import lombok.Getter;
import org.gpe.domain.utils.RangoDecimal;

public class RentaMensual extends Renta {
  @Getter private final ArrayList<Tramo> tramosMensual;

  public RentaMensual() {
    this.tramosMensual = convertirTramosAMensual();
  }

  @Override
  public DeduccionRenta calcularDeduccion(Double salario) {
    return this.aplicarTramo(buscarTramo(tramosMensual, salario), salario);
  }

  private ArrayList<Tramo> convertirTramosAMensual() {
    ArrayList<Tramo> tramos = new ArrayList<>();
    for (Tramo tramo : super.getTramos()) {
      tramos.add(convertirTramoAMensual(tramo));
    }
    return tramos;
  }

  private Tramo convertirTramoAMensual(Tramo tramo) {
    RangoDecimal rangoSalarial =
        new RangoDecimal(tramo.getRangoSalarial().getInicio(), tramo.getRangoSalarial().getFin());
    Double sobreExceso = tramo.getSobreExceso();
    Double cuotaFija = tramo.getCuotaFija();
    return new Tramo(
        tramo.getNombre(), tramo.getPorcentajeAplicar(), rangoSalarial, sobreExceso, cuotaFija);
  }
}
