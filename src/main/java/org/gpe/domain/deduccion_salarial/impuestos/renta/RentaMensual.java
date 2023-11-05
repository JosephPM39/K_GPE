package org.gpe.domain.deduccion_salarial.impuestos.renta;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;
import org.gpe.domain.utils.RangoSalarial;

public class RentaMensual extends Renta {
  @Getter private final ArrayList<Tramo> tramosMensual;

  public RentaMensual() {
    this.tramosMensual = createTramos();
  }

  private ArrayList<Tramo> createTramos() {
    Tramo tramo1 = new Tramo(
            "Tramo 1",
            new Porcentaje(0),
            new RangoSalarial(new Dinero(0.01), new Dinero(472.00)),
            new Dinero(0.00),
            new Dinero(0.00)
    );
    Tramo tramo2 = new Tramo(
            "Tramo 2",
            new Porcentaje(10),
            new RangoSalarial(new Dinero(472.01), new Dinero(895.24)),
            new Dinero(472.00),
            new Dinero(17.67)
    );

    Tramo tramo3 = new Tramo(
            "Tramo 3",
            new Porcentaje(20),
            new RangoSalarial(new Dinero(895.25), new Dinero(2038.10)),
            new Dinero(895.24),
            new Dinero(60.00)
    );

    Tramo tramo4 = new Tramo(
            "Tramo 4",
            new Porcentaje(30),
            new RangoSalarial(new Dinero(2038.11), new Dinero(1000000000000.0)),
            new Dinero(2038.10),
            new Dinero(288.57)
    );
    return new ArrayList<>(List.of(tramo1, tramo2, tramo3, tramo4));
  }

  @Override
  protected ArrayList<Tramo> getTramos() {
    return tramosMensual;
  }

}
