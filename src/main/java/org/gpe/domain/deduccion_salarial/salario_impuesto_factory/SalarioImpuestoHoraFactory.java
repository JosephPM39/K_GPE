package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpHora;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssHora;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaHora;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.salario.SalarioMensual;
import org.gpe.domain.salario.SalarioPorHora;

public class SalarioImpuestoHoraFactory implements SalarioImpuestoFactory {
    @Override
    public IsssHora crearIsss() {
        return new IsssHora();
    }

    @Override
    public AfpHora crearAfp() {
        return new AfpHora();
    }

    @Override
    public RentaHora crearRenta() {
        return new RentaHora();
    }
}