package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpQuincenal;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssQuincenal;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaQuincenal;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.salario.SalarioMensual;
import org.gpe.domain.salario.SalarioQuincenal;

public class SalarioImpuestoQuincenalFactory implements SalarioImpuestoFactory {
    @Override
    public IsssQuincenal crearIsss() {
        return new IsssQuincenal();
    }

    @Override
    public AfpQuincenal crearAfp() {
        return new AfpQuincenal();
    }

    @Override
    public RentaQuincenal crearRenta() {
        return new RentaQuincenal();
    }
}