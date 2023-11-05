package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.RangoSalarial;

public class RentaMensual extends Renta {
  @Getter private final ArrayList<Tramo> tramosMensual;

  public RentaMensual() {
    this.tramosMensual = convertirTramosAMensual();
  }

  @Override
  public DeduccionRenta calcularDeduccion(Dinero salario) {
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
    RangoSalarial rangoSalarial =
        new RangoSalarial(tramo.getRangoSalarial().getInicio(), tramo.getRangoSalarial().getFin());
    Dinero sobreExceso = tramo.getSobreExceso();
    Dinero cuotaFija = tramo.getCuotaFija();
    return new Tramo(
        tramo.getNombre(), tramo.getPorcentajeAplicar(), rangoSalarial, sobreExceso, cuotaFija);
  }
}
