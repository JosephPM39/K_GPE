package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.RangoSalarial;

public class RentaSemanal extends Renta {
  @Getter private final ArrayList<Tramo> tramosSemanal;

  public RentaSemanal() {
    this.tramosSemanal = convertirTramosASemanal();
  }

  @Override
  public DeduccionRenta calcularDeduccion(Dinero salario) {
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
    Dinero salarioInicio = tramo.getRangoSalarial().getInicio().clone();
    Dinero salarioFin = tramo.getRangoSalarial().getFin().clone();
    salarioInicio.dividir(4);
    salarioFin.dividir(4);

    RangoSalarial rangoSalarial = new RangoSalarial(salarioInicio, salarioFin);

    Dinero sobreExceso = tramo.getSobreExceso().clone();
    Dinero cuotaFija = tramo.getCuotaFija().clone();
    sobreExceso.dividir(4);
    cuotaFija.dividir(4);

    return new Tramo(
        tramo.getNombre(), tramo.getPorcentajeAplicar(), rangoSalarial, sobreExceso, cuotaFija);
  }
}
