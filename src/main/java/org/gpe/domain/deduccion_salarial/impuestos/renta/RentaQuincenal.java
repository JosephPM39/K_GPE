package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.RangoSalarial;

public class RentaQuincenal extends Renta {
  @Getter private final ArrayList<Tramo> tramosQuincenal;

  public RentaQuincenal() {
    this.tramosQuincenal = convertirTramosAQuincenal();
  }

  @Override
  public DeduccionRenta calcularDeduccion(Dinero salario) {
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
    Dinero salarioInicio = tramo.getRangoSalarial().getInicio().clone();
    Dinero salarioFin = tramo.getRangoSalarial().getFin().clone();
    salarioInicio.dividir(2);
    salarioFin.dividir(2);

    RangoSalarial rangoSalarial = new RangoSalarial(salarioInicio, salarioFin);

    Dinero sobreExceso = tramo.getSobreExceso().clone();
    Dinero cuotaFija = tramo.getCuotaFija().clone();
    sobreExceso.dividir(2);
    cuotaFija.dividir(2);

    return new Tramo(tramo.getNombre(), tramo.getPorcentajeAplicar(), rangoSalarial, sobreExceso, cuotaFija);
  }
}
