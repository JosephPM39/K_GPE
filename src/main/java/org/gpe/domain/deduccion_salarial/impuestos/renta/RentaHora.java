package org.gpe.domain.deduccion_salarial.impuestos.renta;

import lombok.Getter;
import org.gpe.domain.utils.RangoDecimal;

import java.util.ArrayList;

public class RentaHora extends Renta {
    @Getter final private ArrayList<Tramo> tramosHora;

    public RentaHora() {
        this.tramosHora = convertirTramosAHora();
    }

    @Override
    public DeduccionRenta calcularDeduccion(Double salario) {
        return this.aplicarTramo(buscarTramo(tramosHora, salario), salario);
    }

    private ArrayList<Tramo> convertirTramosAHora() {
        ArrayList<Tramo> tramos = new ArrayList<>();
        for (Tramo tramo: super.getTramos()) {
            tramos.add(convertirTramoAHora(tramo));
        }
        return tramos;
    }

    private Tramo convertirTramoAHora(Tramo tramo) {
        RangoDecimal rangoSalarial = new RangoDecimal(
                tramo.getRangoSalarial().getInicio() / 30 / 8,
                tramo.getRangoSalarial().getFin() / 30 / 8
        );
        Double sobreExceso = tramo.getSobreExceso() / 30 / 8;
        Double cuotaFija = tramo.getCuotaFija() / 30 / 8;
        return new Tramo(tramo.getNombre(), tramo.getPorcentajeAplicar(), rangoSalarial, sobreExceso, cuotaFija);
    }
}



