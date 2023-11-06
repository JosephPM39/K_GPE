package org.gpe.domain.deduccion_salarial.tributos.renta;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;
import org.gpe.domain.utils.RangoSalarial;

public class RentaSemanal extends Renta {
  @Getter private final ArrayList<Tramo> tramosSemanal;

  public RentaSemanal() {
    this.tramosSemanal = createTramos();
  }

  private ArrayList<Tramo> createTramos() {
    Tramo tramo1 =
        new Tramo(
            "Tramo 1",
            new Porcentaje(0),
            new RangoSalarial(new Dinero(0.01), new Dinero(118.00)),
            new Dinero(0.00),
            new Dinero(0.00));
    Tramo tramo2 =
        new Tramo(
            "Tramo 2",
            new Porcentaje(10),
            new RangoSalarial(new Dinero(118.01), new Dinero(223.81)),
            new Dinero(118.00),
            new Dinero(4.42));

    Tramo tramo3 =
        new Tramo(
            "Tramo 3",
            new Porcentaje(20),
            new RangoSalarial(new Dinero(223.82), new Dinero(509.52)),
            new Dinero(223.81),
            new Dinero(15.00));

    Tramo tramo4 =
        new Tramo(
            "Tramo 4",
            new Porcentaje(30),
            new RangoSalarial(new Dinero(509.53), new Dinero(1000000000000.0)),
            new Dinero(509.52),
            new Dinero(72.14));
    return new ArrayList<>(List.of(tramo1, tramo2, tramo3, tramo4));
  }

  @Override
  protected ArrayList<Tramo> getTramos() {
    return tramosSemanal;
  }
}
